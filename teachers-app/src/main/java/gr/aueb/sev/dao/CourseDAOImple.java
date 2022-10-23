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
import gr.aueb.sev.model.Teacher;

public class CourseDAOImple implements ICourseDAO
{

	@Override
	public void insert(Course course) throws SQLException {
		PreparedStatement pst = null;
		
		//ftiaxnw ena connection
		Connection conn = getConnection(); 
		
		try 
		{
			//SQL STATEMENT - WITH PLACEHOLDERS ?, ?
			String sql = "INSERT INTO courses(DESCRIPTION, TEACHER_ID) VALUES(?,?)";
			
		
		
			
			
		
			
			//anigw to connection kai tu pernaw to query
			pst = conn.prepareStatement(sql);
			
			
			//to 1 adistixei ston place holder 1   
			//deuterh paramtros to value pou pernw ws isodo sthn methodo pou adistixei sto query
			pst.setString(1, course.getDescription());
			
			//to 2 adistixei ston place holder 2
			//deuterh paramtros to value pou pernw ws isodo sthn methodo pou adistixei sto query
			pst.setInt(2, course.getTeacherId());
			
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
	public Course delete(Course course) throws SQLException {
		PreparedStatement pst = null;
		
		//ftiaxnw ena connection
		Connection conn = getConnection(); 
		
		try 
		{
			//SQL STATEMENT - WITH PLACEHOLDERS ?, ?
			String sql = "DELETE FROM COURSES WHERE ID = ?"; 
			//+ "'" +teacher.getFirstname() + "', " + "'" +  teacher.getLastname() + "'"; 
			//  den to kanoume auto gia na apofigume sql injection
			//giadto vazoume  place holders (?, ?) 
			
			
		
			
			//anigw to connection kai tu pernaw to query
			pst = conn.prepareStatement(sql);
			
			
			//to 1 adistixei ston place holder 1   
			//deuterh paramtros to value pou pernw ws isodo sthn methodo pou adistixei sto query
			pst.setInt(1, course.getId());
			
		
			
			//to trexw kai epistefei ta rows an thelw int n = pst.executeUpdate();
			int n = pst.executeUpdate();
			
			if(n == 0) 
			{
				return null;
			}else 
			{
				return course;
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
	public void update(Course oldCourse, Course newCourse) throws SQLException {
		PreparedStatement pst = null;
		
		//ftiaxnw ena connection
		Connection conn = getConnection(); 
		
		try 
		{
			//SQL STATEMENT - WITH PLACEHOLDERS ?, ?
			String sql = "UPDATE COURSES SET DESCRIPTION = ? , TEACHER_ID = ? WHERE ID = ?"; 
			//+ "'" +teacher.getFirstname() + "', " + "'" +  teacher.getLastname() + "'"; 
			//  den to kanoume auto gia na apofigume sql injection
			//giadto vazoume  place holders (?, ?) 
			
			
		
			
			//anigw to connection kai tu pernaw to query
			pst = conn.prepareStatement(sql);
			
			
			//to 1 adistixei ston place holder 1   
			//deuterh paramtros to value pou pernw ws isodo sthn methodo pou adistixei sto query
			pst.setString(1, newCourse.getDescription());
			pst.setInt(2, newCourse.getTeacherId());
			pst.setInt(3, oldCourse.getId());
			
			
		
			
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
	public List<Course> getCourses() throws SQLException {
		PreparedStatement pst = null;
		//ftiaxnw ena connection
		Connection conn = getConnection(); 
		
		//ftiaxnw ena pinaka me teachers
		List<Course> courses = new ArrayList<>();
		
		//otan kanei fetch - otan fernei apo thn vash dedomenwn h select fernei tis egrafes
		//se enan xwro po onomazete Resultset
		// to ResultSet einai mia -> anaparastash sthn mnhmh ton egrafwn tou pinaka pou epistrefonte
		// san na vlepeis enan pinaka sthn mnhmh
		//opos vlepoume ton pinaka sthn vash etsi akrivos vlepoume to  ResultSet sthn mnhmh
		ResultSet  rs = null;
		
		
		try 
		{
			//SQL STATEMENT - WITH PLACEHOLDERS ?, ?
			String sql = "SELECT ID, DESCRIPTION, TEACHER_ID FROM COURSES"; 
			//+ "'" +teacher.getFirstname() + "', " + "'" +  teacher.getLastname() + "'"; 
			//  den to kanoume auto gia na apofigume sql injection
			//giadto vazoume  place holders (?, ?) 
			
			
		
			
			//anigw to connection kai tu pernaw to query
			pst = conn.prepareStatement(sql);
			
			
			
		
			
			
		
			
			//kanoume execute query oxi update den alazei kati - to apotelesma einai to result set pou ftiaksame sthn arxh
			rs = pst.executeQuery();
			
			while(rs.next()) //SE KATHE EGRFH - GRAMH EAN IPARXEI BENEI MESA
			{
				Course course  = new Course();//GIA KATHE EGRAFH ENA NEO TEACHER
				course.setId(rs.getInt("ID")); // PERNOUME TIMES KAI EKXOOUME STO TEACHER
				course.setDescription(rs.getString("DESCRIPTION"));
				course.setTeacherId(rs.getInt("TEACHER_ID"));
				
				courses.add(course);
			}
			return courses;
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
	public Course getCourseById(int id) throws SQLException {
		PreparedStatement pst = null;
		//ftiaxnw ena connection
		Connection conn = getConnection(); 
		
		//autos pou tha epistrepsw.
		Course course = null ;
		
		//otan kanei fetch - otan fernei apo thn vash dedomenwn h select fernei tis egrafes
		//se enan xwro po onomazete Resultset
		// to ResultSet einai mia -> anaparastash sthn mnhmh ton egrafwn tou pinaka pou epistrefonte
		// san na vlepeis enan pinaka sthn mnhmh
		//opos vlepoume ton pinaka sthn vash etsi akrivos vlepoume to  ResultSet sthn mnhmh
		ResultSet  rs = null;
		
		
		try 
		{
			//SQL STATEMENT - WITH PLACEHOLDERS ?, ?
			String sql = "SELECT * FROM COURSES WHERE ID = ?"; 
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
				course = new Course();
				course.setId(rs.getInt("ID")); // PERNOUME TIMES KAI EKXOOUME STO TEACHER
				course.setDescription(rs.getString("DESCRIPTION"));
				course.setTeacherId(rs.getInt("TEACHER_ID"));
			}
			return course;
			
			
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
