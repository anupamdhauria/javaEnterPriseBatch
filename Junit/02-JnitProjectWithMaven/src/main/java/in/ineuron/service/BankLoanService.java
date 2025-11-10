package in.ineuron.service;

public class BankLoanService {

	
	public BankLoanService() {
		System.out.println("\nBankLoanService:Zero args Constructor\n");
	}

	public float calculateSimpleIntereset(float pAmount,float rate,float time) {
		System.out.println("BankLoanService.calculateSimpleIntereset()");
		if(pAmount<=0 || rate<=0 || time<=0) {
			throw new IllegalArgumentException("Illigal Arguments Exception");
		}
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
		return pAmount*rate*time/100.0f;
	}
}
