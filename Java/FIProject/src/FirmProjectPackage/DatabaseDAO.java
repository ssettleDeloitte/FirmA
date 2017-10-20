package FirmProjectPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseDAO {
	public Connection getConnection(){
		
		String connectionUrl = "jdbc:mysql://localhost:3306/FirmIntDb";
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(connectionUrl, "root", "root");
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
		
	}
	
	public void closeConnection(Connection connection)
	{
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	
	
	
	public void create(Database database)
	{
		String sql = "insert into firmintdb.databases(name, location) values(?,?)";
				
		Connection connection = getConnection();
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, database.getName());
			statement.setString(2, database.getLocation());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeConnection(connection);
		}
			
	}
	
	public List<Database> selectAll(){
		List<Database> db = new ArrayList<Database>();
		
		String sql = "select * from firmintdb.databases";
		
		Connection connection = getConnection();
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet results = statement.executeQuery();
			while(results.next())
			{
				int id = results.getInt("id");
				String name = results.getString("name");
				String location = results.getString("location");
				Database database = new Database(id, name, location);
				db.add(database);
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally{
			closeConnection(connection);
		}
		
		return db ;
	}
	
	
	public void remove(int id)
	{
		String sql = "delete from firmintdb.databases where id=?";
		
		Connection connection = getConnection();
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			statement.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			closeConnection(connection);
		}
		}
	
	public Database selectOne(int id)
	{
		Database env = null;
	
		String sql = "select * from firmintdb.databases where id=?";
		
		Connection connection = getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			if(result.next())
			{
				 id = result.getInt("id");
				 String name = result.getString("name");
				 String location = result.getString("location");
				 env = new Database(id, name, location);	
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			closeConnection(connection);
		}
		return env;
	}
	
	public void update(int id, Database env)
	{
		String sql = "update firmintdb.databases set name=?, location=? where id=?";
		Connection connection = getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, env.getName());
			statement.setString(2, env.getLocation());
			statement.setInt(3, id);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeConnection(connection);
		}
			
	}
	
	
	public List<Database> search(String name){
		List<Database> r = new ArrayList<Database>();
		
		String sql = "select * from firmintdb.databases where name = %?%";
		
		Connection connection = getConnection();
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, name);
			ResultSet results = statement.executeQuery();
			while(results.next())
			{
				int id = results.getInt("id");
				name = results.getString("name");
				String location = results.getString("location");
				Database database = new Database(id, name, location);
				r.add(database);
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally{
			closeConnection(connection);
		}
		
		return r ;
	}
	
	
	
	
	
	
	
	/*public List<Database> searchDatabase(String search, List<Database> old){
		 
		
		
		List<Database> newDb = new ArrayList<Database>();
		
		for(Database d: old)
		{
			if(d.getName().contains(search))
			{
				newDb.add(d);
			}
		}
		return newDb;
		
	}*/
	
	public static void main(String[] args) {
		ApplicationsDAO dao = new ApplicationsDAO();
		
		Environment en = new Environment("Google Environment", "http://www.google.com");
		dao.create(en);

	}

}

