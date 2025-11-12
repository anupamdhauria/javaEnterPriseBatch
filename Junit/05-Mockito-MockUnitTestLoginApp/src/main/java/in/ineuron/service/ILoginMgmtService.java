package in.ineuron.service;

public interface ILoginMgmtService {

	public boolean login(String username,String password);
	public String register(String username,String role);
}
