package in.ineuron.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import in.ineuron.bo.CustomerBO;

public class CustomerMySqlDAOImpl implements ICustomerDAO {
	
	private DataSource dataSource;
	private int count=0;
	private String SqlInsertQuery="insert into customer (`cname`,`caddress`,`cpmnt`,`crate`,`ctime`,`cintrAmt`)"
			+ "values(?,?,?,?,?,?)";
		
	
	public CustomerMySqlDAOImpl(DataSource dataSource) {
		this.dataSource = dataSource;
		System.out.println("1 param constructor::"+dataSource.getClass().getName());
	}

	@Override
	public int save(CustomerBO custBO) throws Exception {
		
		try(Connection connection=dataSource.getConnection()){
			
			PreparedStatement pstmt = connection.prepareStatement(SqlInsertQuery);
			pstmt.setString(1, custBO.getCustomerName());
			pstmt.setString(2, custBO.getCustomerAddress());
			pstmt.setFloat(3, custBO.getPamt());
			pstmt.setFloat(4, custBO.getRate());
			pstmt.setFloat(5, custBO.getTime());
			pstmt.setFloat(6, custBO.getIntrAmt());
			count=pstmt.executeUpdate();
			
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return count;
	}

}
