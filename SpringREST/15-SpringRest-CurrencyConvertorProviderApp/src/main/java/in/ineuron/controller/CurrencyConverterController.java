package in.ineuron.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import in.ineuron.response.CurrencyConverter;

@RestController
@RequestMapping("/api/currency")
public class CurrencyConverterController {

	@GetMapping(value="/getCurrencyExchange/from/{from}/to/{to}")
	public ResponseEntity<CurrencyConverter>getCurrencyDetails(@PathVariable String from,@PathVariable String to){
		CurrencyConverter currency = new CurrencyConverter();
		currency.setCurrencyId(1);
		currency.setCurrencyFrom(from);
		currency.setCurrencyTo(to);
		currency.setCurrencyValue(82);
		
		return new ResponseEntity<CurrencyConverter>(currency,HttpStatus.OK);
	}
}
