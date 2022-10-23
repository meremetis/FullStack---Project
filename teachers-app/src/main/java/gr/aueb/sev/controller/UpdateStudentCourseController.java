package gr.aueb.sev.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.aueb.sev.dao.IStudentCourseDAO;
import gr.aueb.sev.dao.StudentCourseDAOImple;
import gr.aueb.sev.dto.StudentCourseDTO;
import gr.aueb.sev.service.IStudentCourseService;
import gr.aueb.sev.service.StudentCourseServiceImple;


@WebServlet("/update-studentcourse")
public class UpdateStudentCourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	IStudentCourseDAO studentCourseDAO = new StudentCourseDAOImple();
	IStudentCourseService studentCourseServ = new StudentCourseServiceImple(studentCourseDAO);
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		response.setContentType("text/html, charset=UTF-8");
		
		
		int studentId = Integer.parseInt(request.getParameter("studentId").trim());
		int courseId =  Integer.parseInt(request.getParameter("courseId").trim());
		
		
		StudentCourseDTO studentCourseDTO= new StudentCourseDTO();
		studentCourseDTO.setStudentId(studentId);
		studentCourseDTO.setCourseId(courseId);
		
		request.setAttribute("studentcourse", studentCourseDTO);
		request.getRequestDispatcher("/jsps/studentcourseupdate.jsp")
		.forward(request, response);
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		response.setContentType("text/html, charset=UTF-8");
		
		int oldstudentId = Integer.parseInt(request.getParameter("oldstudentId").trim());
		int oldcourseId =  Integer.parseInt(request.getParameter("oldcourseId").trim());
		
		int studentId = Integer.parseInt(request.getParameter("studentId").trim());
		int courseId =  Integer.parseInt(request.getParameter("courseId").trim());
		
		
		StudentCourseDTO oldStudentCourseDTO= new StudentCourseDTO();
		oldStudentCourseDTO.setStudentId(oldstudentId);
		oldStudentCourseDTO.setCourseId(oldcourseId);
		
		StudentCourseDTO newStudentCourseDTO= new StudentCourseDTO();
		newStudentCourseDTO.setStudentId(studentId);
		newStudentCourseDTO.setCourseId(courseId);
		
		try 
		{	
			
			studentCourseServ.updateStudentCourse(oldStudentCourseDTO, newStudentCourseDTO);
			
			
			request.setAttribute("studentcourse", newStudentCourseDTO);
			
			request.getRequestDispatcher("/jsps/studentcourseupdated.jsp")
			.forward(request, response);
		}
		catch(SQLException e)
		{		
			request.setAttribute("sqlErrorstudentcourseupdate", true);
			request.getRequestDispatcher("/jsps/menu.jsp")
			.forward(request, response);
		}
		
	}

}
