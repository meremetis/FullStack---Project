package gr.aueb.sev.service;

import java.sql.SQLException;
import java.util.List;
import gr.aueb.sev.dao.IStudentDAO;
import gr.aueb.sev.dto.StudentDTO;
import gr.aueb.sev.model.Student;
import gr.aueb.sev.model.Teacher;
import gr.aueb.sev.service.exceptions.StudentNotFoundException;
import gr.aueb.sev.service.exceptions.TeacherNotFoundException;

public class StudentServiceImple implements IStudentService 
{

	private final IStudentDAO studentDAO;
	
	public StudentServiceImple(IStudentDAO studentDAO) 
	{
		this.studentDAO = studentDAO;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void insertStudent(StudentDTO studentDTO) throws SQLException {
		Student student = extract(studentDTO);
		
		try 
		{
			studentDAO.insert(student);
		}
		catch(SQLException e) 
		{
			throw e;
		}
		
	}

	
	
	
	
	
	
	
	@Override
	public void deleteStudent(StudentDTO studentDTO) throws SQLException, StudentNotFoundException {
		Student studentToDelete = extract(studentDTO);
		
		try 
		{
			if(studentDAO.delete(studentToDelete) == null)
			{
				throw new StudentNotFoundException(studentToDelete);
			} 
		}
		catch(StudentNotFoundException e) 
		{
			throw e;
		}
		catch(SQLException e) 
		{
			throw e;
		}
		
	}

	@Override
	public void updateStudent(StudentDTO oldStudentDTO, StudentDTO newStudentDTO) 
			throws SQLException 
	{
		Student oldStudent = extract(oldStudentDTO);
		Student newStudent = extract(newStudentDTO);
		
		try 
		{
			 studentDAO.update(oldStudent, newStudent);
		}
		catch(SQLException e) 
		{
			throw e;
		}
		
	}

	@Override
	public List<Student> getStudentByLastname(String lastname) throws SQLException {
		try 
		{
			return studentDAO.getStudentsByLastname(lastname);
			
		}
		catch(SQLException e) 
		{
			throw e;
		}
	}

	@Override
	public Student getStudentByid(int id) 
			throws SQLException, StudentNotFoundException 
	{
		try 
		{
			Student student = studentDAO.getStudentById(id);
			
			if(student == null)
			{
				throw new StudentNotFoundException(student);
			} 
			else 
			{
				return student;
			}
			
		}
		catch(StudentNotFoundException e) 
		{
			throw e;
		}
		catch(SQLException e) 
		{
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private Student extract(StudentDTO studentDTO) 
	{
		Student student = new Student();
		
		student.setId(studentDTO.getId());
		student.setFirstname(studentDTO.getFirstname());
		student.setLastname(studentDTO.getLastname());
	
		return student;
	}

}
