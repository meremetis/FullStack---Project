package gr.aueb.sev.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.aueb.sev.dao.CourseDAOImple;
import gr.aueb.sev.dao.ICourseDAO;
import gr.aueb.sev.dao.IStudentCourseDAO;
import gr.aueb.sev.dao.StudentCourseDAOImple;
import gr.aueb.sev.model.Course;
import gr.aueb.sev.model.StudentCourse;
import gr.aueb.sev.service.CourseServiceImple;
import gr.aueb.sev.service.ICourseService;
import gr.aueb.sev.service.IStudentCourseService;
import gr.aueb.sev.service.StudentCourseServiceImple;

/**
 * Servlet implementation class SearchStudentcourseController
 */
@WebServlet("/search-studentcourse")
public class SearchStudentcourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	IStudentCourseDAO studentCourseDAO = new StudentCourseDAOImple();
	IStudentCourseService studentCourseServ = new StudentCourseServiceImple(studentCourseDAO);
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		try 
		{
			List<StudentCourse> studentCourses = studentCourseServ.getStudentCourses();
			if(studentCourses.size() == 0) //dene xoun erthei apotelesmata
			{
				request.setAttribute("studentcourseNotFound", true);
				request.getRequestDispatcher("/jsps/menu.jsp").forward(request, response);
			}
			else //exoun erthei apotelesmata
			{
				request.setAttribute("studentcourses", studentCourses);
				request.getRequestDispatcher("/jsps/studentcourses.jsp")
				.forward(request, response);
			}
		
		}
		catch(SQLException e)
		{
			request.setAttribute("sqlErrorsearchstudentcourse", true);
			request.getRequestDispatcher("/jsps/menu.jsp")//edw tha me stilei ean den ginei to insert mazi me ena lathos
			.forward(request, response);
		}}


}
