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
import gr.aueb.sev.dao.ITeacherDAO;
import gr.aueb.sev.dao.TeacherDAOImple;
import gr.aueb.sev.model.Course;
import gr.aueb.sev.model.Teacher;
import gr.aueb.sev.service.CourseServiceImple;
import gr.aueb.sev.service.ICourseService;
import gr.aueb.sev.service.ITeacherService;
import gr.aueb.sev.service.TeacherServiceImple;

/**
 * Servlet implementation class SearchCourseController
 */
@WebServlet("/search-course")
public class SearchCourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ICourseDAO courseDAO = new CourseDAOImple();
	ICourseService courseServ = new CourseServiceImple(courseDAO);
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		try 
		{
			List<Course> courses = courseServ.getCourses();
			if(courses.size() == 0) //dene xoun erthei apotelesmata
			{
				request.setAttribute("courseNotFound", true);
				request.getRequestDispatcher("/jsps/menu.jsp").forward(request, response);
			}
			else //exoun erthei apotelesmata
			{
				request.setAttribute("courses", courses);
				request.getRequestDispatcher("/jsps/courses.jsp")
				.forward(request, response);
			}
		
		}
		catch(SQLException e)
		{
			request.setAttribute("sqlErrorsearchcourse", true);
			request.getRequestDispatcher("/jsps/menu.jsp")//edw tha me stilei ean den ginei to insert mazi me ena lathos
			.forward(request, response);
		}
		
	}

	
}
