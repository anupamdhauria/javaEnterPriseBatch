package in.ineuron.comp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value="bill")
public class BillGenerator {
	
	@Value("Haveli")
	private String hotelName;
	
	@Value("#{itemInfo.idlyPrice+itemInfo.dosaPrice+itemInfo.vadaPrice}")
	private Integer billAmount;
	
	@Autowired
	private ItemsInfo items;
	@Override
	public String toString() {
		return "BillGenerator [hotelName=" + hotelName + ", billAmount=" + billAmount + ", items=" + items + "]";
	}
	
	

}
