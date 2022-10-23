package gr.aueb.sev.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.aueb.sev.dao.IStudentDAO;
import gr.aueb.sev.dao.StudentDAOImple;
import gr.aueb.sev.dto.StudentDTO;

import gr.aueb.sev.service.IStudentService;
import gr.aueb.sev.service.StudentServiceImple;
import gr.aueb.sev.service.exceptions.StudentNotFoundException;


/**
 * Servlet implementation class DeleteStudentControler
 */
@WebServlet("/delete-student")
public class DeleteStudentControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	IStudentDAO studentDAO = new StudentDAOImple();
	IStudentService studentServ = new StudentServiceImple(studentDAO);
	
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		response.setContentType("text/html, charset=UTF-8");
		
		//pernw to id gia to delete apo string se int
		int id = Integer.parseInt(request.getParameter("id").trim());
		String firstname = request.getParameter("firstname").trim();
		String lastname = request.getParameter("lastname").trim();
		
		
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setId(id);
		studentDTO.setFirstname(firstname);
		studentDTO.setLastname(lastname);
		
		
		
		try 
		{	
			
			studentServ.deleteStudent(studentDTO);
			// edw epistrefw ta dedomena apo to dto pisw ston client gia tu diksw ti ekane insert 
			request.setAttribute("student", studentDTO);
			
			request.getRequestDispatcher("/jsps/studentdeleted.jsp")
			.forward(request, response);//edw tha me stilei ean ginei to insert mazi me ta dedomena pou ekana insert kai ta diavazei
		}
		catch(SQLException e)
		{
			request.setAttribute("deleteAPIerrorstudent", true);
			request.getRequestDispatcher("/jsps/students.jsp")//edw tha me stilei ean den ginei to insert mazi me ena lathos
			.forward(request, response);
		}
		catch(StudentNotFoundException e) 
		{
			request.setAttribute("studentNotFound", true);
			request.getRequestDispatcher("/jsps/students.jsp")//edw tha me stilei ean den ginei to insert mazi me ena lathos
			.forward(request, response);
		}
	}



}
