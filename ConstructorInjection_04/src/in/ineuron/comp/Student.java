package in.ineuron.comp;

public class Student {

	private Integer sid;
	private String sname;
	private Integer sage;
	private String saddress;
	private Float smarks;

	public Student(Integer sid, String sname, Integer sage, String saddress, Float smarks) {
		this.sid = sid;
		this.sname = sname;
		this.sage = sage;
		this.saddress = saddress;
		this.smarks = smarks;

		System.out.println("Constructor Injection Happens: 5 param constructor.");
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", sage=" + sage + ", saddress=" + saddress + ", smarks="
				+ smarks + "]";
	}

}
