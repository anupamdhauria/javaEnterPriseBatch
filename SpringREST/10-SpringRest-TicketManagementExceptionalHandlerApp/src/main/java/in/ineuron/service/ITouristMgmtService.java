package in.ineuron.service;

import java.util.List;

import in.ineuron.model.Tourist;

public interface ITouristMgmtService {

	public String registerTourist(Tourist tourist);
	public List<Tourist>fetchAllTourist();
	public Tourist fetchTouristById(Integer id);
	public String updateTouristBtDetails(Tourist tourist);
	public String updateBudgetByHike(Integer id,Float hikeAmtPercentage);
	public String deleteTouristById(Integer id);
}
