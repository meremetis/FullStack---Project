package gr.aueb.sev.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.aueb.sev.dao.IStudentDAO;

import gr.aueb.sev.dao.StudentDAOImple;

import gr.aueb.sev.model.Student;

import gr.aueb.sev.service.IStudentService;

import gr.aueb.sev.service.StudentServiceImple;



@WebServlet("/search-student")
public class SearchStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	IStudentDAO studentDAO = new StudentDAOImple();
	IStudentService studentServ = new StudentServiceImple(studentDAO);
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		response.setContentType("text/html, charset=UTF-8");
		
		//diavazw auta pou mas stelnei to request
		
		String lastname = request.getParameter("studentlastname").trim();//atribute name adistixei sto name ths formas
		
		try 
		{	
			List<Student> students = studentServ.getStudentByLastname(lastname);
			
		
			if(students.size() == 0) //dene xoun erthei apotelesmata
			{
				request.setAttribute("studentNotFound", true);
				request.getRequestDispatcher("/jsps/menu.jsp").forward(request, response);
			}
			else //exoun erthei apotelesmata
			{
				request.setAttribute("students", students);
				request.getRequestDispatcher("/jsps/students.jsp")
				.forward(request, response);
			}
		}
		catch(SQLException e)
		{
			request.setAttribute("sqlErrorsearchstudents", true);
			request.getRequestDispatcher("/jsps/menu.jsp")//edw tha me stilei ean den ginei to insert mazi me ena lathos
			.forward(request, response);
		}
	}


}
