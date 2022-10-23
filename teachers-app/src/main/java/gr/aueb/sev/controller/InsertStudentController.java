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
import gr.aueb.sev.dto.TeacherDTO;
import gr.aueb.sev.service.IStudentService;

import gr.aueb.sev.service.StudentServiceImple;



@WebServlet("/insert-student")
public class InsertStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	IStudentDAO studentDAO = new StudentDAOImple();
	
	
	IStudentService studentServ = new StudentServiceImple(studentDAO);
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		response.setContentType("text/html, charset=UTF-8");
		
		
		String firstname = request.getParameter("student-firstname").trim();//atribute name adistixei sto name ths formas
		String lastname = request.getParameter("student-lastname").trim();//atribute name adistixei sto name ths formas
		
		
		
		StudentDTO studentDTO= new StudentDTO();
		studentDTO.setFirstname(firstname);
		studentDTO.setLastname(lastname);
		
		try 
		{	
			//pernaw ta data apo to dto pou pira apo thn forma
			studentServ.insertStudent(studentDTO);
			
			// edw epistrefw ta dedomena apo to dto pisw ston client gia tu diksw ti ekane insert 
			request.setAttribute("insertedStudent", studentDTO);
			
			request.getRequestDispatcher("/jsps/studentinserted.jsp")
			.forward(request, response);//edw tha me stilei ean ginei to insert mazi me ta dedomena pou ekana insert kai ta diavazei
		}
		catch(SQLException e)
		{
			//se periptosh lathous ftiaxnw ena atribute me error
			// h selid tha perimenei na parei kapio error apo eki me atribute name "sqlError"
			//to pernaw me dispatcher sthn selida /jsps/teachersmenu
			request.setAttribute("sqlErrorStudent", true);
			request.getRequestDispatcher("/jsps/menu.jsp")//edw tha me stilei ean den ginei to insert mazi me ena lathos
			.forward(request, response);
		}
	}

}
