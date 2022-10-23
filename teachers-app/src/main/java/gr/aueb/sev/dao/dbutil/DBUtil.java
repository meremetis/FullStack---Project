package gr.aueb.sev.dao.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class DB util for connection
 * 
 * Edw ginete h sindesh
 * 
 * @author Admin
 *
 */
public class DBUtil {
	private static Connection conn;
	
	/**
	 * No instances of this class should be available
	 * private constructor
	 */
	private DBUtil() {}
	
	//this is the basic class that impliments connection
	public static Connection getConnection() throws SQLException
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");//loading the driver of mysql
			//class einai mia clash poue xei meta data
			
			
			//connection string eki vriskete h vahs mou//protokolo jdbc:mysql:// 
			//dns : localhost
			//port 3306
			//db name : ergasiadb
			//paramatros: ?serverTimezone=UTC --xreiazete meta ton 5 tou mysql
			String url = "jdbc:mysql://localhost:3306/ergasiadb?serverTimezone=UTC";//etsi sindeome me thn vash
			
			//to username kai pass kanonika mesa apo arxio gia lagous asfalias
			String username = "admin";//username gia log in
			String password = "admin";//password gia log in
			
			
			
			//thn driverManager mas thn dinei to import java.sql pou einai sto pom xml me to dependancy 
			//my sql connector
			//dinw to connection me 3 params (url/username/lastname)
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("connection successful");
			return conn;//epistrefw mia sindesh
					
		}
		catch(ClassNotFoundException e) 
		{
			e.printStackTrace();
			return null;
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			return null;
		}
	}
	
	
	/**
	 * Util method to close connection
	 * @throws SQLException
	 */
	public static void closeConnection() throws SQLException 
	{
		conn.close();
	}
	
}
