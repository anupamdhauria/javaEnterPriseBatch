package in.ineuron.comp;

import java.util.Arrays;

public class MarksInfo {
	private int[] marks;


	public void setMarks(int[] marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "MarksInfo [marks=" + Arrays.toString(marks) + "]";
	}
	
	

}
