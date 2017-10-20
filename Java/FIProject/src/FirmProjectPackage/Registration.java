package FirmProjectPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Registration() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String connectionUrl=("jdbc:mysql://localhost:3306/FirmIntDb");
		Connection connection = null;
		
		try {
			String fname= request.getParameter("fname");
			String lname= request.getParameter("lname");
			String email= request.getParameter("email");
			String password= request.getParameter("password");
			String username= request.getParameter("username");
			
			String sql = "insert into users(fname, lname, username, email, password) values(?,?,?,?,?)"; 
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(connectionUrl, "root", "root");
			PreparedStatement statement = connection.prepareStatement(sql);
			
			
			
			statement.setString(1, fname);
			statement.setString(2, lname);
			statement.setString(3, username);
			statement.setString(4, email);
			statement.setString(5, password);
			
			
			statement.executeUpdate();
			
			PrintWriter out = response.getWriter();
			out.println("You have successfully Registered");
			System.out.println("Hello");
			
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
