package in.ineuron.service;

import java.net.URI;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import in.ineuron.response.CurrencyResponse;

@Service("service")
public class CurrencyService {

	private static final String REST_API_ENDPONT = "http://localhost:8888/15-SpringRest-CurrencyConvertorProviderApp/api/currency/getCurrencyExchange/from/{from}/to/{to}";

	public void invokeApiSync(String from, String to) {

		System.out.println("SYNCHRONOUS CALL STARTED");
		CurrencyResponse response = WebClient.create().get().uri(REST_API_ENDPONT, from, to)
				.accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(CurrencyResponse.class).block();
		System.out.println(response);
		System.out.println("SYNCHRONOUS CALL ENDED");
	}

	public void invokeApiASync(String from, String to) {

		System.out.println("ASYNCHRONOUS CALL STARTED");
		WebClient.create().get().uri(REST_API_ENDPONT, from, to).accept(MediaType.APPLICATION_JSON).retrieve()
				.bodyToMono(CurrencyResponse.class).subscribe(CurrencyService::myResponse);
		System.out.println("ASYNCHRONOUS CALL ENDED");

	}

	public static void myResponse(CurrencyResponse response) {
		System.out.println(response);
	}
}
