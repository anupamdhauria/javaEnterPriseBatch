package in.ineuron.comp;

import java.util.Set;

public class EnggCourse {

	private Set<String>subjects;

	public void setSubjects(Set<String> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "EnggCourse [subjects=" + subjects + "]";
	}

	public EnggCourse(Set<String> subjects) {
		System.out.println("1 param constructor");
		this.subjects = subjects;
	}
	
	
}
