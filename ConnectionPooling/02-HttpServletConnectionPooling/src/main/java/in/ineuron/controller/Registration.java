package in.ineuron.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

@WebServlet("/reg")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String INSERT_QUERY = "INSERT INTO connecttionpooling_user(`username`,`useraddr`,`useremail`) values(?,?,?)";
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try(Connection con=getPooledConnection()){

			String username = request.getParameter("username");
			String useraddr = request.getParameter("useraddr");
			String useremail = request.getParameter("useremail");
			
			if (con != null) {
				try (PreparedStatement pstmt = con.prepareStatement(INSERT_QUERY)) {
					if (pstmt != null) {
						pstmt.setString(1, username);
						pstmt.setString(2, useraddr);
						pstmt.setString(3, useremail);

						int rowAffected = pstmt.executeUpdate();
						if (rowAffected == 1)
							out.print("<h1 style='color:green; text-align:center;'>ROW INSERTED</h1>");
						else
							out.print("<h1 style='color:red; text-align:center;'>Proble in Row insertion</h1>");

					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(out!=null) {
				
				out.close();
			}
		}
	}
	
	private Connection getPooledConnection() throws Exception{
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jndi");
		Connection conn = ds.getConnection();
		return conn;
	}

}
