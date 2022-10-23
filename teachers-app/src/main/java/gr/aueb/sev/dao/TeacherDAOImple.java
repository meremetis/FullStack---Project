package gr.aueb.sev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static gr.aueb.sev.dao.dbutil.DBUtil.*;

//import static gr.aueb.sev.dao.dbutil.DBUtil.getConnection;
//import static gr.aueb.sev.dao.dbutil.DBUtil.closeConnection;


import gr.aueb.sev.model.Teacher;

public class TeacherDAOImple implements ITeacherDAO
{

	//PreparedStatement implements sql DML - DATA MANIPULATION LANGUAGE -  CRUD 
	@Override
	public void insert(Teacher teacher) throws SQLException {
		PreparedStatement pst = null;
		
		//ftiaxnw ena connection
		Connection conn = getConnection(); 
		
		try 
		{
			//SQL STATEMENT - WITH PLACEHOLDERS ?, ?
			String sql = "INSERT INTO TEACHERS (FIRSTNAME, LASTNAME) VALUES (?, ?)"; 
			//+ "'" +teacher.getFirstname() + "', " + "'" +  teacher.getLastname() + "'"; 
			//  den to kanoume auto gia na apofigume sql injection
			//giadto vazoume  place holders (?, ?) 
			
			
		
			
			//anigw to connection kai tu pernaw to query
			pst = conn.prepareStatement(sql);
			
			
			//to 1 adistixei ston place holder 1   
			//deuterh paramtros to value pou pernw ws isodo sthn methodo pou adistixei sto query
			pst.setString(1, teacher.getFirstname());
			
			//to 2 adistixei ston place holder 2
			//deuterh paramtros to value pou pernw ws isodo sthn methodo pou adistixei sto query
			pst.setString(2, teacher.getLastname());
			
			//to trexw kai epistefei ta rows an thelw int n = pst.executeUpdate();
			pst.executeUpdate();
			
			
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
			throw e;
		}finally 
		{
			//klinw ta resources
			if(pst != null) pst.close();
			if(conn != null) closeConnection();
		}
	}

	@Override
	public Teacher delete(Teacher teacher) throws SQLException {
		PreparedStatement pst = null;
		
		//ftiaxnw ena connection
		Connection conn = getConnection(); 
		
		try 
		{
			//SQL STATEMENT - WITH PLACEHOLDERS ?, ?
			String sql = "DELETE FROM TEACHERS WHERE ID = ?"; 
			//+ "'" +teacher.getFirstname() + "', " + "'" +  teacher.getLastname() + "'"; 
			//  den to kanoume auto gia na apofigume sql injection
			//giadto vazoume  place holders (?, ?) 
			
			
		
			
			//anigw to connection kai tu pernaw to query
			pst = conn.prepareStatement(sql);
			
			
			//to 1 adistixei ston place holder 1   
			//deuterh paramtros to value pou pernw ws isodo sthn methodo pou adistixei sto query
			pst.setInt(1, teacher.getId());
			
		
			
			//to trexw kai epistefei ta rows an thelw int n = pst.executeUpdate();
			int n = pst.executeUpdate();
			
			if(n == 0) 
			{
				return null;
			}else 
			{
				return teacher;
			}
			
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
			throw e;
		}finally 
		{
			//klinw ta resources
			if(pst != null) pst.close();
			if(conn != null) closeConnection();
		}
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void update(Teacher oldTeacher, Teacher newTeacher) throws SQLException {
		PreparedStatement pst = null;
		
		//ftiaxnw ena connection
		Connection conn = getConnection(); 
		
		try 
		{
			//SQL STATEMENT - WITH PLACEHOLDERS ?, ?
			String sql = "UPDATE TEACHERS SET FIRSTNAME = ? , LASTNAME = ? WHERE ID = ?"; 
			//+ "'" +teacher.getFirstname() + "', " + "'" +  teacher.getLastname() + "'"; 
			//  den to kanoume auto gia na apofigume sql injection
			//giadto vazoume  place holders (?, ?) 
			
			
		
			
			//anigw to connection kai tu pernaw to query
			pst = conn.prepareStatement(sql);
			
			
			//to 1 adistixei ston place holder 1   
			//deuterh paramtros to value pou pernw ws isodo sthn methodo pou adistixei sto query
			pst.setString(1, newTeacher.getFirstname());
			pst.setString(2, newTeacher.getLastname());
			pst.setInt(3, oldTeacher.getId());
			
			
		
			
			//to trexw kai epistefei ta rows an thelw int n = pst.executeUpdate();
			pst.executeUpdate();
			
			
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
			throw e;
		}finally 
		{
			//klinw ta resources
			if(pst != null) pst.close();
			if(conn != null) closeConnection();
		}
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public List<Teacher> getTeachersByLastname(String lastname) throws SQLException {
		PreparedStatement pst = null;
		//ftiaxnw ena connection
		Connection conn = getConnection(); 
		
		//ftiaxnw ena pinaka me teachers
		List<Teacher> teachers = new ArrayList<>();
		
		//otan kanei fetch - otan fernei apo thn vash dedomenwn h select fernei tis egrafes
		//se enan xwro po onomazete Resultset
		// to ResultSet einai mia -> anaparastash sthn mnhmh ton egrafwn tou pinaka pou epistrefonte
		// san na vlepeis enan pinaka sthn mnhmh
		//opos vlepoume ton pinaka sthn vash etsi akrivos vlepoume to  ResultSet sthn mnhmh
		ResultSet  rs = null;
		
		
		try 
		{
			//SQL STATEMENT - WITH PLACEHOLDERS ?, ?
			String sql = "SELECT ID, FIRSTNAME, LASTNAME FROM TEACHERS WHERE LASTNAME LIKE ?"; 
			//String sql = "SELECT ID, FIRSTNAME, LASTNAME FROM TEACHERS WHERE LASTNAME LIKE '" + lastname + "%'";
			//+ "'" +teacher.getFirstname() + "', " + "'" +  teacher.getLastname() + "'"; 
			//  den to kanoume auto gia na apofigume sql injection
			//giadto vazoume  place holders (?, ?) 
			
			
		
			
			//anigw to connection kai tu pernaw to query
			pst = conn.prepareStatement(sql);
			
			
			//to 1 adistixei ston place holder 1   
			//deuterh paramtros to value pou pernw ws isodo sthn methodo pou adistixei sto query
			pst.setString(1, lastname + "%");
		
			
			
		
			
			//kanoume execute query oxi update den alazei kati - to apotelesma einai to result set pou ftiaksame sthn arxh
			rs = pst.executeQuery();
			
			while(rs.next()) //SE KATHE EGRFH - GRAMH EAN IPARXEI BENEI MESA
			{
				Teacher teacher  = new Teacher();//GIA KATHE EGRAFH ENA NEO TEACHER
				teacher.setId(rs.getInt("ID")); // PERNOUME TIMES KAI EKXOOUME STO TEACHER
				teacher.setFirstname(rs.getString("FIRSTNAME"));
				teacher.setLastname(rs.getString("LASTNAME"));
				
				teachers.add(teacher);
			}
			return teachers;
			//return (teachers.size() > 0) ? teachers : null;
			
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
			throw e;
		}finally 
		{
			//klinw ta resources
			if(pst != null) pst.close();
			if(conn != null) closeConnection();
		}
		
	}

	@Override
	public Teacher getTeacherById(int id) throws SQLException {
		PreparedStatement pst = null;
		//ftiaxnw ena connection
		Connection conn = getConnection(); 
		
		//autos pou tha epistrepsw.
		Teacher teacher = null ;
		
		//otan kanei fetch - otan fernei apo thn vash dedomenwn h select fernei tis egrafes
		//se enan xwro po onomazete Resultset
		// to ResultSet einai mia -> anaparastash sthn mnhmh ton egrafwn tou pinaka pou epistrefonte
		// san na vlepeis enan pinaka sthn mnhmh
		//opos vlepoume ton pinaka sthn vash etsi akrivos vlepoume to  ResultSet sthn mnhmh
		ResultSet  rs = null;
		
		
		try 
		{
			//SQL STATEMENT - WITH PLACEHOLDERS ?, ?
			String sql = "SELECT * FROM TEACHERS WHERE ID = ?"; 
			//+ "'" +teacher.getFirstname() + "', " + "'" +  teacher.getLastname() + "'"; 
			//  den to kanoume auto gia na apofigume sql injection
			//giadto vazoume  place holders (?, ?) 
			
			
		
			
			//anigw to connection kai tu pernaw to query
			pst = conn.prepareStatement(sql);
			
			
			//to 1 adistixei ston place holder 1   
			//deuterh paramtros to value pou pernw ws isodo sthn methodo pou adistixei sto query
			pst.setInt(1, id);
		
			
			
		
			
			//kanoume execute query oxi update den alazei kati - to apotelesma einai to result set pou ftiaksame sthn arxh
			rs = pst.executeQuery();
			
			if(rs.next()) //SE KATHE EGRFH - GRAMH EAN IPARXEI BENEI MESA
			{
				teacher = new Teacher();
				teacher.setId(rs.getInt("ID")); // PERNOUME TIMES KAI EKXOOUME STO TEACHER
				teacher.setFirstname(rs.getString("FIRSTNAME"));
				teacher.setLastname(rs.getString("LASTNAME"));
			}
			return teacher;
			
			
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
			throw e;
		}finally 
		{
			//klinw ta resources
			if(pst != null) pst.close();
			if(conn != null) closeConnection();
		}
	}
	
}
