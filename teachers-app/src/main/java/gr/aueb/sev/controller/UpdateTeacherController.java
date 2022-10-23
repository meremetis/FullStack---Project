package gr.aueb.sev.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.aueb.sev.dao.ITeacherDAO;
import gr.aueb.sev.dao.TeacherDAOImple;

import gr.aueb.sev.dto.TeacherDTO;
import gr.aueb.sev.service.ITeacherService;
import gr.aueb.sev.service.TeacherServiceImple;

@WebServlet("/update-teacher")
public class UpdateTeacherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ITeacherDAO teacherDAO = new TeacherDAOImple();
	ITeacherService teacherServ = new TeacherServiceImple(teacherDAO);
	
	//
	
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		response.setContentType("text/html, charset=UTF-8");
		
		int id = Integer.parseInt(request.getParameter("id").trim());
		String firstname = request.getParameter("firstname").trim();
		String lastname = request.getParameter("lastname").trim();
		
		
		TeacherDTO teacherDTO = new TeacherDTO(); 
		teacherDTO.setId(id);
		teacherDTO.setFirstname(firstname);
		teacherDTO.setLastname(lastname);
		
		
		
		request.setAttribute("teacher", teacherDTO);
		request.getRequestDispatcher("/jsps/teacherupdate.jsp")
		.forward(request, response);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		response.setContentType("text/html; charset=UTF-8");
		
		int id = Integer.parseInt(request.getParameter("id").trim());
		String firstname = request.getParameter("firstname").trim();
		String lastname = request.getParameter("lastname").trim();
		
		
		TeacherDTO oldTeacherDTO= new TeacherDTO();
		oldTeacherDTO.setId(id);
		
		
		TeacherDTO newTeacherDTO= new TeacherDTO();
		newTeacherDTO.setFirstname(firstname);
		newTeacherDTO.setLastname(lastname);
		
		
		try 
		{	
			
			teacherServ.updateTeacher(oldTeacherDTO,newTeacherDTO);
			
			
			request.setAttribute("teacher", newTeacherDTO);
			
			request.getRequestDispatcher("/jsps/teacherupdated.jsp")
			.forward(request, response);
		}
		catch(SQLException e)
		{		
			request.setAttribute("sqlError", true);
			request.getRequestDispatcher("/jsps/menu.jsp")
			.forward(request, response);
		}
		
				
	}

	
	

}
