package in.ineuron.response;

import lombok.Data;

@Data
public class CurrencyConverter {
	private Integer currencyId;
	private String currencyFrom;
	private String currencyTo;
	private Integer currencyValue;
	

}
