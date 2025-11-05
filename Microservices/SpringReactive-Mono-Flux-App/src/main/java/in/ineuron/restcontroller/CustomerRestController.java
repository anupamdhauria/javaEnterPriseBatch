package in.ineuron.restcontroller;

import java.time.Duration;
import java.util.Date;
import java.util.stream.Stream;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.CustomerEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@RestController
@RequestMapping("/api/customer")
public class CustomerRestController {

    @GetMapping(value = "/getEvent", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Mono<CustomerEvent>> getCustomerEvent() {

        CustomerEvent customer = new CustomerEvent("Sachin", new Date());
        Mono<CustomerEvent> customerMono = Mono.just(customer);

        return new ResponseEntity<>(customerMono, HttpStatus.OK);
    }

    @GetMapping(value = "/getEvents", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public ResponseEntity<Flux<CustomerEvent>> getCustomerEvents() {

        // Creating initial CustomerEvent
        CustomerEvent event = new CustomerEvent("Smith", new Date());

        // Stream to continuously generate events
        Stream<CustomerEvent> customerStream = Stream.generate(() -> 
            new CustomerEvent("Smith", new Date())
        );

        // Convert Stream to Flux
        Flux<CustomerEvent> customerFlux = Flux.fromStream(customerStream);

        // Emit one event every 3 seconds (change as needed)
        Flux<Long> intervalFlux = Flux.interval(Duration.ofSeconds(3));

        // Combine time intervals with events
        Flux<CustomerEvent> eventStream = Flux
                .zip(intervalFlux, customerFlux)
                .map(Tuple2::getT2);

        // Return Flux as SSE response
        return new ResponseEntity<>(eventStream, HttpStatus.OK);
    }
}
