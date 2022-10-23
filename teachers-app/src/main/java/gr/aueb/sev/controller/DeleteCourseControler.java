package gr.aueb.sev.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.aueb.sev.dao.CourseDAOImple;
import gr.aueb.sev.dao.ICourseDAO;
import gr.aueb.sev.dto.CourseDTO;
import gr.aueb.sev.service.CourseServiceImple;
import gr.aueb.sev.service.ICourseService;
import gr.aueb.sev.service.exceptions.CourseNotFoundException;
import gr.aueb.sev.service.exceptions.TeacherNotFoundException;


@WebServlet("/delete-course")
public class DeleteCourseControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ICourseDAO courseDAO = new CourseDAOImple();
	ICourseService courseServ = new CourseServiceImple(courseDAO);
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		response.setContentType("text/html, charset=UTF-8");
		
		int id = Integer.parseInt(request.getParameter("id").trim());
		String description = request.getParameter("description").trim();
		int teacherId =  Integer.parseInt(request.getParameter("teacherId").trim());
		
		
		CourseDTO courseDTO= new CourseDTO();
		courseDTO.setId(id);
		courseDTO.setDescription(description);
		courseDTO.setTeacherId(teacherId);
		
		try 
		{	
			courseServ.deleteCourse(courseDTO);
			
			// edw epistrefw ta dedomena apo to dto pisw ston client gia tu diksw ti ekane insert 
			request.setAttribute("course", courseDTO);
			
			request.getRequestDispatcher("/jsps/coursesdeleted.jsp")
			.forward(request, response);//edw tha me stilei ean ginei to insert mazi me ta dedomena pou ekana insert kai ta diavazei
		}
		catch(SQLException e)
		{
			request.setAttribute("deleteAPIerror", true);
			request.getRequestDispatcher("/jsps/courses.jsp")//edw tha me stilei ean den ginei to insert mazi me ena lathos
			.forward(request, response);
		}
		catch(CourseNotFoundException e) 
		{
			request.setAttribute("courseNotFound", true);
			request.getRequestDispatcher("/jsps/courses.jsp")//edw tha me stilei ean den ginei to insert mazi me ena lathos
			.forward(request, response);
		}
		
	}



}
