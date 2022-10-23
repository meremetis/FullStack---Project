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



@WebServlet("/insert-studentcourse")
public class InsertStudentCourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	IStudentCourseDAO studentCourseDAO = new StudentCourseDAOImple();
	IStudentCourseService studentCourseServ = new StudentCourseServiceImple(studentCourseDAO);
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		response.setContentType("text/html, charset=UTF-8");
		
		
		int studentId = Integer.parseInt(request.getParameter("studentcourse-studentId").trim());
		int courseId =  Integer.parseInt(request.getParameter("studentcourse-courseId").trim());
		
		
		StudentCourseDTO studentCourseDTO= new StudentCourseDTO();
		studentCourseDTO.setStudentId(studentId);
		studentCourseDTO.setCourseId(courseId);
		
		
		try 
		{	
			//pernaw ta data apo to dto pou pira apo thn forma
			studentCourseServ.insertStudentCourse(studentCourseDTO);
			
			// edw epistrefw ta dedomena apo to dto pisw ston client gia tu diksw ti ekane insert 
			request.setAttribute("insertedStudentCourse", studentCourseDTO);
			
			request.getRequestDispatcher("/jsps/studentcourseinserted.jsp")
			.forward(request, response);//edw tha me stilei ean ginei to insert mazi me ta dedomena pou ekana insert kai ta diavazei
		}
		catch(SQLException e)
		{
			
			request.setAttribute("sqlErrorstudentcourse", true);
			request.getRequestDispatcher("/jsps/menu.jsp")//edw tha me stilei ean den ginei to insert mazi me ena lathos
			.forward(request, response);
		}
	}

}
