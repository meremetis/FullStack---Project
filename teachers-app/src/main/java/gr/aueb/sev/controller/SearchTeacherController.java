package gr.aueb.sev.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.aueb.sev.dao.ITeacherDAO;
import gr.aueb.sev.dao.TeacherDAOImple;

import gr.aueb.sev.model.Teacher;
import gr.aueb.sev.service.ITeacherService;
import gr.aueb.sev.service.TeacherServiceImple;

@WebServlet("/search-teacher")
public class SearchTeacherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	ITeacherDAO teacherDAO = new TeacherDAOImple();
	ITeacherService teacherServ = new TeacherServiceImple(teacherDAO);
	
	
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		response.setContentType("text/html, charset=UTF-8");
		
		//diavazw auta pou mas stelnei to request
		
		String lastname = request.getParameter("teacherlastname").trim();//atribute name adistixei sto name ths formas
		
		try 
		{	
			List<Teacher> teachers = teacherServ.getTeachersByLastname(lastname);
			
		
			if(teachers.size() == 0) //dene xoun erthei apotelesmata
			{
				request.setAttribute("teacherNotFound", true);
				request.getRequestDispatcher("/jsps/menu.jsp").forward(request, response);
			}
			else //exoun erthei apotelesmata
			{
				request.setAttribute("teachers", teachers);
				request.getRequestDispatcher("/jsps/teachers.jsp")
				.forward(request, response);
			}
		}
		catch(SQLException e)
		{
			request.setAttribute("sqlErrorsearch", true);
			request.getRequestDispatcher("/jsps/menu.jsp")//edw tha me stilei ean den ginei to insert mazi me ena lathos
			.forward(request, response);
		}
		
	}
}
