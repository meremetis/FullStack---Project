package gr.aueb.sev.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.aueb.sev.dao.ITeacherDAO;
import gr.aueb.sev.dao.TeacherDAOImple;
import gr.aueb.sev.dto.TeacherDTO;
import gr.aueb.sev.service.ITeacherService;
import gr.aueb.sev.service.TeacherServiceImple;
import gr.aueb.sev.service.exceptions.TeacherNotFoundException;

@WebServlet("/delete-teacher")
public class DeleteTeacherControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	ITeacherDAO teacherDAO = new TeacherDAOImple();
	ITeacherService teacherServ = new TeacherServiceImple(teacherDAO);
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		//kanw set thn kodikopiish se UTF-8
		response.setContentType("text/html, charset=UTF-8");
		
		//pernw to id gia to delete apo string se int
		int id = Integer.parseInt(request.getParameter("id").trim());
		String firstname = request.getParameter("firstname").trim();
		String lastname = request.getParameter("lastname").trim();
		//diavazw apo to url ta data
		
		//mas lipei mia fash to Validation
		
		
		
		//data binding metaferw ta data apo thn forma/url sto DTO Object
		TeacherDTO teacherDTO = new TeacherDTO();
		teacherDTO.setId(id);
		teacherDTO.setFirstname(firstname);
		teacherDTO.setLastname(lastname);
		
		
		
		try 
		{	
			
			teacherServ.deleteTeacher(teacherDTO);
			// edw epistrefw ta dedomena apo to dto pisw ston client gia tu diksw ti ekane insert 
			request.setAttribute("teacher", teacherDTO);
			
			request.getRequestDispatcher("/jsps/teacherdeleted.jsp")
			.forward(request, response);//edw tha me stilei ean ginei to insert mazi me ta dedomena pou ekana insert kai ta diavazei
		}
		catch(SQLException e)
		{
			request.setAttribute("deleteAPIerror", true);
			request.getRequestDispatcher("/jsps/teachers.jsp")//edw tha me stilei ean den ginei to insert mazi me ena lathos
			.forward(request, response);
		}
		catch(TeacherNotFoundException e) 
		{
			request.setAttribute("teacherNotFound", true);
			request.getRequestDispatcher("/jsps/teachers.jsp")//edw tha me stilei ean den ginei to insert mazi me ena lathos
			.forward(request, response);
		}
	}

	
	

}
