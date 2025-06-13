package in.ineuron.comp;

import java.util.Random;

public class FlipKart {

	private Courier courier;
	private Float discount;

	static {
		System.out.println("\nFilpkart class is loading..");

	}

	public FlipKart() {
		System.out.println("Flipkart:: Zero param constructor");
	}

	public void setCourier(Courier courier) {
		System.out.println("FlipKart.setCourier()");
		this.courier = courier;
		

	}

	public void setDiscount(Float discount) {
		System.out.println("FlipKart.setDiscount()");
		this.discount = discount;
		System.out.println(this);

	}

	public String doShopping(String[] items, float prices[]) {

		System.out.println("FlipKart.doShopping()");
		System.out.println("Implementation class is::" + courier.getClass().getName());

		int oid = 0;
		Random random = new Random();
		oid = random.nextInt(1000);

		System.out.println("==============================================");
		System.out.println("Items\tPrice");
		for (int i = 0; i < items.length; i++) {
			System.out.println(items[i] + "\t" + prices[i]);
		}
		System.out.println("==============================================");
		float billAmount = 0.0f;
		for (float price : prices) {
			billAmount += price;
		}
		System.out.println("Total Amount::"+billAmount);
		System.out.println("Discount::"+discount+"%");
		billAmount = billAmount -((billAmount*discount)/ 100.0f);
		String msg = courier.deliver(oid);
		return "Final Bill Amount :" + billAmount + "\n==============================================\n" + msg;
	}

	@Override
	public String toString() {
		return "FlipKart [courier=" + courier + ", discount=" + discount + "]";
	}

}
