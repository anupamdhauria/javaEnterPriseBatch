package in.ineuron.test;

import in.ineuron.comp.WishMessageGenerator;

public class UsingCoreJava {

	public static void main(String[] args) {
		
		WishMessageGenerator wm=new WishMessageGenerator();
		System.out.println("Before setter injection:"+wm);
		
		java.util.Date date=new java.util.Date();
		
		wm.setDate(date);
		System.out.println("After Setter Injection :"+wm);
		
		String msg=wm.generateMessage("Anupam");
		System.out.println(msg);
	}

}
