package gr.aueb.sev.service;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.sev.dao.IStudentCourseDAO;
import gr.aueb.sev.dto.StudentCourseDTO;
import gr.aueb.sev.model.Course;
import gr.aueb.sev.model.Student;
import gr.aueb.sev.model.StudentCourse;
import gr.aueb.sev.service.exceptions.CourseNotFoundException;

import gr.aueb.sev.service.exceptions.StudentCourseNotFoundException;
import gr.aueb.sev.service.exceptions.StudentNotFoundException;

public class StudentCourseServiceImple implements IStudentCourseService
{

	private final IStudentCourseDAO studentCourseDAO;
	
	public StudentCourseServiceImple(IStudentCourseDAO studentCourseDAO) 
	{
		this.studentCourseDAO = studentCourseDAO;
	}
	
	
	
	
	
	
	
	
	@Override
	public void insertStudentCourse(StudentCourseDTO studentCourseDTO) 
			throws SQLException
	{
		StudentCourse studentCourse = extract(studentCourseDTO);
		try 
		{
			
			studentCourseDAO.insert(studentCourse);
			
			
		}
		catch(SQLException e) 
		{
			throw e;
		}
		
	}

	
	
	
	

	
	
	
	
	
	
	
	
	
	@Override
	public void deleteStudentCourse(StudentCourseDTO studentCourseDTO)
			throws SQLException, StudentCourseNotFoundException 
	{
		StudentCourse studentCourseToDelete = extract(studentCourseDTO);
		
		try 
		{
			if(studentCourseDAO.delete(studentCourseToDelete) == null)
			{
				throw new StudentCourseNotFoundException(studentCourseToDelete);
			} 
		}
		catch(StudentCourseNotFoundException e) 
		{
			throw e;
		}
		catch(SQLException e) 
		{
			throw e;
		}
		
	}

	@Override
	public void updateStudentCourse(StudentCourseDTO oldStudentCourseDTO, StudentCourseDTO newStudentCourseDTO)
			throws SQLException 
	{
		StudentCourse oldStudentCourse = extract(oldStudentCourseDTO);
		StudentCourse newStudentCourse = extract(newStudentCourseDTO);
		
		try 
		{
			studentCourseDAO.update(oldStudentCourse, newStudentCourse);
		}
		catch(SQLException e) 
		{
			throw e;
		}
		
	}

	@Override
	public List<StudentCourse> getStudentCourses() 
			throws SQLException
	{
		try 
		{
			return studentCourseDAO.getAllStudentCourse();
			
		}
		catch(SQLException e) 
		{
			throw e;
		}
	}

	@Override
	public StudentCourse getStudentCourseByids(int student_id, int course_id)
			throws SQLException, StudentCourseNotFoundException
	{
		try 
		{
			StudentCourse studentCourse = studentCourseDAO.getStudentCourseById(student_id, course_id);
			
			if(studentCourse == null)
			{
				throw new StudentCourseNotFoundException(studentCourse);
			} 
			else 
			{
				return studentCourse;
			}
			
		}
		catch(StudentCourseNotFoundException e) 
		{
			throw e;
		}
		catch(SQLException e) 
		{
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	private StudentCourse extract(StudentCourseDTO studentCourseDTO) 
	{
		StudentCourse studentCourse = new StudentCourse();
		
		studentCourse.setStudentId(studentCourseDTO.getStudentId());
		studentCourse.setCourseId(studentCourseDTO.getCourseId());
		
		
		return studentCourse;
	}
}
