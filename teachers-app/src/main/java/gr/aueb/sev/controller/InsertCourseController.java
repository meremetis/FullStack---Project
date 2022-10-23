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
import gr.aueb.sev.dao.ITeacherDAO;
import gr.aueb.sev.dao.TeacherDAOImple;
import gr.aueb.sev.dto.CourseDTO;
import gr.aueb.sev.dto.TeacherDTO;
import gr.aueb.sev.service.CourseServiceImple;
import gr.aueb.sev.service.ICourseService;
import gr.aueb.sev.service.ITeacherService;
import gr.aueb.sev.service.TeacherServiceImple;



@WebServlet("/insert-course")
public class InsertCourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	ICourseDAO courseDAO = new CourseDAOImple();
	ICourseService courseServ = new CourseServiceImple(courseDAO);
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		response.setContentType("text/html, charset=UTF-8");
		
		
		String description = request.getParameter("course-description").trim();
		int teacherId =  Integer.parseInt(request.getParameter("course-teacher-id").trim());
		
		
		CourseDTO courseDTO= new CourseDTO();
		courseDTO.setDescription(description);
		courseDTO.setTeacherId(teacherId);
		
		try 
		{	
			//pernaw ta data apo to dto pou pira apo thn forma
			courseServ.insertCourse(courseDTO);
			
			// edw epistrefw ta dedomena apo to dto pisw ston client gia tu diksw ti ekane insert 
			request.setAttribute("insertedCourse", courseDTO);
			
			request.getRequestDispatcher("/jsps/courseinserted.jsp")
			.forward(request, response);//edw tha me stilei ean ginei to insert mazi me ta dedomena pou ekana insert kai ta diavazei
		}
		catch(SQLException e)
		{
			
			request.setAttribute("sqlErrorcourse", true);
			request.getRequestDispatcher("/jsps/menu.jsp")//edw tha me stilei ean den ginei to insert mazi me ena lathos
			.forward(request, response);
		}
		
		
		
	}

}
