package FirmProjectPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Login() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String connectionUrl=("jdbc:mysql://localhost:3306/FirmIntDb");
		Connection connection = null;
		
		try {
			
			
			String dbName = null;
			String dbPassword = null;
			String password= request.getParameter("password");
			String username= request.getParameter("username");
			
			String sql = "select * from firmintdb.users where username=? and password=?"; 
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(connectionUrl, "root", "root");
			PreparedStatement statement = connection.prepareStatement(sql);
			
			
			
			statement.setString(1, username);
			statement.setString(2, password);
			
			ResultSet rs = statement.executeQuery();
			while(rs.next()){
				dbName=rs.getString("username");
				dbPassword = rs.getString("password");
			}
			
	/*		if(username.equals(null) || password.equals(null))
			{
				out.println("lkj");
			}*/
			
			
			if( dbName.length() > 0 && dbName != null && dbPassword.length() > 0 && dbPassword != null && username.equals(dbName) && password.equals(dbPassword))
			{
				
				response.sendRedirect("index.jsp");
				//out.println("You have successfully logged in");
			}else{
				response.sendRedirect("login.jsp");
				out.println("Incorrect username or password");
				
				//RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				//rd.include(request, response);
			}
			
					
		} catch (InstantiationException e) {
			
			e.printStackTrace();
		} catch (IllegalAccessException e) {
		
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}



	}


