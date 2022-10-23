package gr.aueb.sev.dao;

import static gr.aueb.sev.dao.dbutil.DBUtil.closeConnection;
import static gr.aueb.sev.dao.dbutil.DBUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gr.aueb.sev.model.Course;
import gr.aueb.sev.model.StudentCourse;

public class StudentCourseDAOImple implements IStudentCourseDAO
{

	@Override
	public void insert(StudentCourse studentCourse) throws SQLException {
		PreparedStatement pst = null;
		
		//ftiaxnw ena connection
		Connection conn = getConnection(); 
		
		try 
		{
			//SQL STATEMENT - WITH PLACEHOLDERS ?, ?
			String sql = "INSERT INTO STUDENT_COURSE (STUDENT_ID, COURSE_ID) VALUES (?, ?)"; 
			//+ "'" +teacher.getFirstname() + "', " + "'" +  teacher.getLastname() + "'"; 
			//  den to kanoume auto gia na apofigume sql injection
			//giadto vazoume  place holders (?, ?) 
			
			
		
			
			//anigw to connection kai tu pernaw to query
			pst = conn.prepareStatement(sql);
			
			
			//to 1 adistixei ston place holder 1   
			//deuterh paramtros to value pou pernw ws isodo sthn methodo pou adistixei sto query
			pst.setInt(1, studentCourse.getStudentId());
			
			//to 2 adistixei ston place holder 2
			//deuterh paramtros to value pou pernw ws isodo sthn methodo pou adistixei sto query
			pst.setInt(2, studentCourse.getCourseId());
			
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
	public StudentCourse delete(StudentCourse studentCourse) throws SQLException {
		PreparedStatement pst = null;
		
		//ftiaxnw ena connection
		Connection conn = getConnection(); 
		
		try 
		{
			//SQL STATEMENT - WITH PLACEHOLDERS ?, ?
			String sql = "DELETE FROM STUDENT_COURSE WHERE STUDENT_ID = ? and COURSE_ID = ? "; 
			//+ "'" +teacher.getFirstname() + "', " + "'" +  teacher.getLastname() + "'"; 
			//  den to kanoume auto gia na apofigume sql injection
			//giadto vazoume  place holders (?, ?) 
			
			
		
			
			//anigw to connection kai tu pernaw to query
			pst = conn.prepareStatement(sql);
			
			
			//to 1 adistixei ston place holder 1   
			//deuterh paramtros to value pou pernw ws isodo sthn methodo pou adistixei sto query
			pst.setInt(1, studentCourse.getStudentId());
			pst.setInt(2, studentCourse.getCourseId());
			
		
			
			//to trexw kai epistefei ta rows an thelw int n = pst.executeUpdate();
			int n = pst.executeUpdate();
			
			if(n == 0) 
			{
				return null;
			}else 
			{
				return studentCourse;
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
	public void update(StudentCourse oldStudentCourse, StudentCourse newStudentCourse) throws SQLException {
	PreparedStatement pst = null;
		
		//ftiaxnw ena connection
		Connection conn = getConnection(); 
		
		try 
		{
			//SQL STATEMENT - WITH PLACEHOLDERS ?, ?
			String sql = "UPDATE STUDENT_COURSE SET STUDENT_ID = ? , COURSE_ID = ? WHERE STUDENT_ID = ? and COURSE_ID = ?"; 
			//+ "'" +teacher.getFirstname() + "', " + "'" +  teacher.getLastname() + "'"; 
			//  den to kanoume auto gia na apofigume sql injection
			//giadto vazoume  place holders (?, ?) 
			
			
		
			
			//anigw to connection kai tu pernaw to query
			pst = conn.prepareStatement(sql);
			
			
			//to 1 adistixei ston place holder 1   
			//deuterh paramtros to value pou pernw ws isodo sthn methodo pou adistixei sto query
			pst.setInt(1, newStudentCourse.getStudentId());
			pst.setInt(2, newStudentCourse.getCourseId());
			
			
			pst.setInt(3, oldStudentCourse.getStudentId());
			pst.setInt(4, oldStudentCourse.getCourseId());
			
			
		
			
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
	public List<StudentCourse> getAllStudentCourse() throws SQLException {
		PreparedStatement pst = null;
		//ftiaxnw ena connection
		Connection conn = getConnection(); 
		
		//ftiaxnw ena pinaka me teachers
		List<StudentCourse> studentcourses = new ArrayList<>();
		
		//otan kanei fetch - otan fernei apo thn vash dedomenwn h select fernei tis egrafes
		//se enan xwro po onomazete Resultset
		// to ResultSet einai mia -> anaparastash sthn mnhmh ton egrafwn tou pinaka pou epistrefonte
		// san na vlepeis enan pinaka sthn mnhmh
		//opos vlepoume ton pinaka sthn vash etsi akrivos vlepoume to  ResultSet sthn mnhmh
		ResultSet  rs = null;
		
		
		try 
		{
			//SQL STATEMENT - WITH PLACEHOLDERS ?, ?
			String sql = "SELECT STUDENT_ID, COURSE_ID FROM STUDENT_COURSE"; 
			//+ "'" +teacher.getFirstname() + "', " + "'" +  teacher.getLastname() + "'"; 
			//  den to kanoume auto gia na apofigume sql injection
			//giadto vazoume  place holders (?, ?) 
			
			
		
			
			//anigw to connection kai tu pernaw to query
			pst = conn.prepareStatement(sql);
			
			
			
		
			
			
		
			
			//kanoume execute query oxi update den alazei kati - to apotelesma einai to result set pou ftiaksame sthn arxh
			rs = pst.executeQuery();
			
			while(rs.next()) //SE KATHE EGRFH - GRAMH EAN IPARXEI BENEI MESA
			{
				StudentCourse studentcourse  = new StudentCourse();//GIA KATHE EGRAFH ENA NEO TEACHER
				studentcourse.setStudentId(rs.getInt("STUDENT_ID")); // PERNOUME TIMES KAI EKXOOUME STO TEACHER
				studentcourse.setCourseId(rs.getInt("COURSE_ID"));
				
				studentcourses.add(studentcourse);
				
			}
			return studentcourses;
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
	public StudentCourse getStudentCourseById(int student_id, int course_id) throws SQLException {
		PreparedStatement pst = null;
		//ftiaxnw ena connection
		Connection conn = getConnection(); 
		
		//autos pou tha epistrepsw.
		StudentCourse studentcourse = null ;
		
		//otan kanei fetch - otan fernei apo thn vash dedomenwn h select fernei tis egrafes
		//se enan xwro po onomazete Resultset
		// to ResultSet einai mia -> anaparastash sthn mnhmh ton egrafwn tou pinaka pou epistrefonte
		// san na vlepeis enan pinaka sthn mnhmh
		//opos vlepoume ton pinaka sthn vash etsi akrivos vlepoume to  ResultSet sthn mnhmh
		ResultSet  rs = null;
		
		
		try 
		{
			//SQL STATEMENT - WITH PLACEHOLDERS ?, ?
			String sql = "SELECT * FROM STUDENT_COURSE WHERE STUDENT_ID = ? AND COURSE_ID = ?"; 
			//+ "'" +teacher.getFirstname() + "', " + "'" +  teacher.getLastname() + "'"; 
			//  den to kanoume auto gia na apofigume sql injection
			//giadto vazoume  place holders (?, ?) 
			
			
		
			
			//anigw to connection kai tu pernaw to query
			pst = conn.prepareStatement(sql);
			
			
			//to 1 adistixei ston place holder 1   
			//deuterh paramtros to value pou pernw ws isodo sthn methodo pou adistixei sto query
			pst.setInt(1, student_id);
			pst.setInt(2, course_id);
		
			
			
		
			
			//kanoume execute query oxi update den alazei kati - to apotelesma einai to result set pou ftiaksame sthn arxh
			rs = pst.executeQuery();
			
			if(rs.next()) //SE KATHE EGRFH - GRAMH EAN IPARXEI BENEI MESA
			{
				studentcourse = new StudentCourse();
				studentcourse.setStudentId(rs.getInt("STUDENT_ID")); // PERNOUME TIMES KAI EKXOOUME STO TEACHER
				studentcourse.setCourseId(rs.getInt("COURSE_ID"));
			}
			return studentcourse;
			
			
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
