package gr.aueb.sev.service;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.sev.dao.ITeacherDAO;
import gr.aueb.sev.dto.TeacherDTO;
import gr.aueb.sev.model.Teacher;
import gr.aueb.sev.service.exceptions.TeacherNotFoundException;

public class TeacherServiceImple implements ITeacherService
{
	
	private final ITeacherDAO teacherDAO;
	
	public TeacherServiceImple(ITeacherDAO teacherDAO) 
	{
		this.teacherDAO = teacherDAO;
	}
	
	@Override
	public void insertTeacher(TeacherDTO teacherDTO) throws SQLException {
		Teacher teacher = extract(teacherDTO);
		
		try 
		{
			teacherDAO.insert(teacher);
		}
		catch(SQLException e) 
		{
			throw e;
		}
		
	}

	
	
	
	
	
	
	@Override
	public void deleteTeacher(TeacherDTO teacherDTO) 
			throws SQLException, TeacherNotFoundException 
	{
		Teacher teacherToDelete = extract(teacherDTO);
		
		try 
		{
			if(teacherDAO.delete(teacherToDelete) == null)
			{
				throw new TeacherNotFoundException(teacherToDelete);
			} 
		}
		catch(TeacherNotFoundException e) 
		{
			throw e;
		}
		catch(SQLException e) 
		{
			throw e;
		}
		
		
	}

	@Override
	public void updateTeacher(TeacherDTO oldTeacherDTO, TeacherDTO newTeacherDTO)
			throws SQLException
	{
		
		
		Teacher oldteacher = extract(oldTeacherDTO);
		Teacher newteacher = extract(newTeacherDTO);
		
		try 
		{
			teacherDAO.update(oldteacher, newteacher);
		}
		catch(SQLException e) 
		{
			throw e;
		}
	}

	@Override
	public List<Teacher> getTeachersByLastname(String lastname) 
			throws SQLException 
	{
		try 
		{
			return teacherDAO.getTeachersByLastname(lastname);
			
		}
		catch(SQLException e) 
		{
			throw e;
		}
		
	}

	@Override
	public Teacher getTeacherByid(int id) 
			throws SQLException, TeacherNotFoundException 
	{
		try 
		{
			Teacher teacher = teacherDAO.getTeacherById(id);
			
			if(teacher == null)
			{
				throw new TeacherNotFoundException(teacher);
			} 
			else 
			{
				return teacher;
			}
		}
		catch(TeacherNotFoundException e) 
		{
			throw e;
		}
		catch(SQLException e) 
		{
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	private Teacher extract(TeacherDTO teacherDTO) 
	{
		Teacher teacher = new Teacher();
		
		teacher.setId(teacherDTO.getId());
		teacher.setFirstname(teacherDTO.getFirstname());
		teacher.setLastname(teacherDTO.getLastname());
		
		return teacher;
	}

}
