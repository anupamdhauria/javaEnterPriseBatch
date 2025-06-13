package in.ineuron.comp;
import java.util.*;
public class UniversityInfo {
	private Map<Integer,String>facultyDetails;
	private Map<String,Date>dateInfo;
	public void setFacultyDetails(Map<Integer, String> facultyDetails) {
		this.facultyDetails = facultyDetails;
		System.out.println("Implementation Class of Map is::"+facultyDetails.getClass().getName());
	}
	public void setDateInfo(Map<String, Date> dateInfo) {
		this.dateInfo = dateInfo;
	}
	@Override
	public String toString() {
		return "UniversityInfo [facultyDetails=" + facultyDetails + ", dateInfo=" + dateInfo + "]";
	}
	
	
	

}
