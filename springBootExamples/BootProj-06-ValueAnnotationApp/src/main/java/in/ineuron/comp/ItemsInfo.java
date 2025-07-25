package in.ineuron.comp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value="itemInfo")
public class ItemsInfo {

	@Value("${info.idli.price}")
	public Integer idlyPrice;
	
	@Value("${info.dosa.price}")
	public Integer dosaPrice;
	
	@Value("${info.vada.price}")
	public Integer vadaPrice;
	
	@Override
	public String toString() {
		return "ItemsInfo [idlyPrice=" + idlyPrice + ", dosaPrice=" + dosaPrice + ", vadaPrice=" + vadaPrice + "]";
	}
	
	
}
