package gr.aueb.sev.dao;

import static gr.aueb.sev.dao.dbutil.DBUtil.closeConnection;
import static gr.aueb.sev.dao.dbutil.DBUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gr.aueb.sev.model.Student;
import gr.aueb.sev.model.Teacher;

public class StudentDAOImple  implements IStudentDAO{

	//PreparedStatement implements sql DML - DATA MANIPULATION LANGUAGE -  CRUD 
	@Override
	public void insert(Student student) throws SQLException {
		
		PreparedStatement pst = null;
		
		//ftiaxnw ena connection
		Connection conn = getConnection(); 
		
		try 
		{
			//SQL STATEMENT - WITH PLACEHOLDERS ?, ?
			String sql = "INSERT INTO STUDENTS (FIRSTNAME, LASTNAME) VALUES (?, ?)"; 
			//+ "'" +teacher.getFirstname() + "', " + "'" +  teacher.getLastname() + "'"; 
			//  den to kanoume auto gia na apofigume sql injection
			//giadto vazoume  place holders (?, ?) 
			
			
		
			
			//anigw to connection kai tu pernaw to query
			pst = conn.prepareStatement(sql);
			
			
			//to 1 adistixei ston place holder 1   
			//deuterh paramtros to value pou pernw ws isodo sthn methodo pou adistixei sto query
			pst.setString(1, student.getFirstname());
			
			//to 2 adistixei ston place holder 2
			//deuterh paramtros to value pou pernw ws isodo sthn methodo pou adistixei sto query
			pst.setString(2, student.getLastname());
			
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
	public Student delete(Student student) throws SQLException {
		PreparedStatement pst = null;
		
		//ftiaxnw ena connection
		Connection conn = getConnection(); 
		
		try 
		{
			//SQL STATEMENT - WITH PLACEHOLDERS ?, ?
			String sql = "DELETE FROM STUDENTS WHERE ID = ?"; 
			//+ "'" +teacher.getFirstname() + "', " + "'" +  teacher.getLastname() + "'"; 
			//  den to kanoume auto gia na apofigume sql injection
			//giadto vazoume  place holders (?, ?) 
			
			
		
			
			//anigw to connection kai tu pernaw to query
			pst = conn.prepareStatement(sql);
			
			
			//to 1 adistixei ston place holder 1   
			//deuterh paramtros to value pou pernw ws isodo sthn methodo pou adistixei sto query
			pst.setInt(1, student.getId());
			
		
			
			//to trexw kai epistefei ta rows an thelw int n = pst.executeUpdate();
			int n = pst.executeUpdate();
			
			
			if(n == 0) 
			{
				return null;
			}else 
			{
				return student;
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
	public void update(Student oldStudent, Student newStudent) throws SQLException {
		PreparedStatement pst = null;
		
		//ftiaxnw ena connection
		Connection conn = getConnection(); 
		
		try 
		{
			//SQL STATEMENT - WITH PLACEHOLDERS ?, ?
			String sql = "UPDATE STUDENTS SET FIRSTNAME = ? , LASTNAME = ? WHERE ID = ?"; 
			//+ "'" +teacher.getFirstname() + "', " + "'" +  teacher.getLastname() + "'"; 
			//  den to kanoume auto gia na apofigume sql injection
			//giadto vazoume  place holders (?, ?) 
			
			
		
			
			//anigw to connection kai tu pernaw to query
			pst = conn.prepareStatement(sql);
			
			
			//to 1 adistixei ston place holder 1   
			//deuterh paramtros to value pou pernw ws isodo sthn methodo pou adistixei sto query
			pst.setString(1, newStudent.getFirstname());
			pst.setString(2, newStudent.getLastname());
			pst.setInt(3, oldStudent.getId());
			
			
		
			
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
	public List<Student> getStudentsByLastname(String lastname) throws SQLException {
		PreparedStatement pst = null;
		//ftiaxnw ena connection
		Connection conn = getConnection(); 
		
		//ftiaxnw ena pinaka me teachers
		List<Student> students = new ArrayList<>();
		
		//otan kanei fetch - otan fernei apo thn vash dedomenwn h select fernei tis egrafes
		//se enan xwro po onomazete Resultset
		// to ResultSet einai mia -> anaparastash sthn mnhmh ton egrafwn tou pinaka pou epistrefonte
		// san na vlepeis enan pinaka sthn mnhmh
		//opos vlepoume ton pinaka sthn vash etsi akrivos vlepoume to  ResultSet sthn mnhmh
		ResultSet  rs = null;
		
		
		try 
		{
			//SQL STATEMENT - WITH PLACEHOLDERS ?, ?
			String sql = "SELECT ID, FIRSTNAME, LASTNAME FROM STUDENTS WHERE LASTNAME LIKE ?"; 
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
				Student student = new Student(); //GIA KATHE EGRAFH ENA NEO STUDENT
				student.setId(rs.getInt("ID")); // PERNOUME TIMES KAI EKXOOUME STO TEACHER
				student.setFirstname(rs.getString("FIRSTNAME"));
				student.setLastname(rs.getString("LASTNAME"));
				
				students.add(student);
			}
			return students;
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
	public Student getStudentById(int id) throws SQLException {
		PreparedStatement pst = null;
		//ftiaxnw ena connection
		Connection conn = getConnection(); 
		
		//autos pou tha epistrepsw.
		Student student = null ;
		
		//otan kanei fetch - otan fernei apo thn vash dedomenwn h select fernei tis egrafes
		//se enan xwro po onomazete Resultset
		// to ResultSet einai mia -> anaparastash sthn mnhmh ton egrafwn tou pinaka pou epistrefonte
		// san na vlepeis enan pinaka sthn mnhmh
		//opos vlepoume ton pinaka sthn vash etsi akrivos vlepoume to  ResultSet sthn mnhmh
		ResultSet  rs = null;
		
		
		try 
		{
			//SQL STATEMENT - WITH PLACEHOLDERS ?, ?
			String sql = "SELECT * FROM STUDENTS WHERE ID = ?"; 
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
				student = new Student();
				student.setId(rs.getInt("ID")); // PERNOUME TIMES KAI EKXOOUME STO TEACHER
				student.setFirstname(rs.getString("FIRSTNAME"));
				student.setLastname(rs.getString("LASTNAME"));
			}
			return student;
			
			
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
