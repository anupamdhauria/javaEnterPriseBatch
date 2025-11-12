package in.ineuron.service;

import in.ineuron.dao.ILoginDao;

public class LoginMgmtServiceImpl implements ILoginMgmtService {

	private ILoginDao dao;

	public LoginMgmtServiceImpl(ILoginDao dao) {
		this.dao = dao;
	}

	@Override
	public boolean login(String username, String password) {
		if (username.equals("") || password.equals("")) {
			throw new IllegalArgumentException("Empty creadentials");

		} else {
			int value = dao.authenticate(username, password);
			if (value == 0)
				return false;
			else
				return true;
		}

	}

	@Override
	public String register(String username, String role) {

		if(role==null)
			return "user not added";
		if ( !role.equalsIgnoreCase("") && !role.equalsIgnoreCase("visitors")) {
			
			 dao.addUser(username, role);
			
			
			return "user added";
		}
		return "user not added";
	}

}
