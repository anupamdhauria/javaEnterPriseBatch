package in.ineuron.dto;

public class EmployeeDTO {

	private String eid;
	private String ename;
	private int eage;
	private String eadress;
	private float esalary;
	private float hikeAmt;
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getEage() {
		return eage;
	}
	public void setEage(int eage) {
		this.eage = eage;
	}
	public String getEadress() {
		return eadress;
	}
	public void setEadress(String eadress) {
		this.eadress = eadress;
	}
	public float getEsalary() {
		return esalary;
	}
	public void setEsalary(float esalary) {
		this.esalary = esalary;
	}
	public float getHikeAmt() {
		return hikeAmt;
	}
	public void setHikeAmt(float hikeAmt) {
		this.hikeAmt = hikeAmt;
	}
	@Override
	public String toString() {
		return "EmployeeDTO [eid=" + eid + ", ename=" + ename + ", eage=" + eage + ", eadress=" + eadress + ", esalary="
				+ esalary + ", hikeAmt=" + hikeAmt + "]";
	}
	
	
}
