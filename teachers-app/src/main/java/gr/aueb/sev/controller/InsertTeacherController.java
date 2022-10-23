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



//orizw to root path
@WebServlet("/insert-teacher")
public class InsertTeacherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//ilopiw to service
	//ftiaxnw dao
	ITeacherDAO teacherDAO = new TeacherDAOImple();
	
	//ftiaxnw to service kai tou pernaw mesa me wiring h alios IOC ena etimo DAO.
	//auto einai to wiring
	ITeacherService teacherServ = new TeacherServiceImple(teacherDAO);
	
	
	
	
	
	
	
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		//kanw set thn kodikopiish se UTF-8
		response.setContentType("text/html, charset=UTF-8");
		
		//diavazw auta pou mas stelnei to request
		String firstname = request.getParameter("teacher-firstname").trim();//atribute name adistixei sto name ths formas
		String lastname = request.getParameter("teacher-lastname").trim();//atribute name adistixei sto name ths formas
		
		
		//data binding metaferw ta data apo thn forma sto DTO Object
		TeacherDTO teacherDTO= new TeacherDTO();
		teacherDTO.setFirstname(firstname);
		teacherDTO.setLastname(lastname);
		
		
		
		//prepi na emfanisw ston client
		// mesa sto try ilopiw to service layer
		try 
		{	
			//pernaw ta data apo to dto pou pira apo thn forma
			teacherServ.insertTeacher(teacherDTO);
			
			// edw epistrefw ta dedomena apo to dto pisw ston client gia tu diksw ti ekane insert 
			request.setAttribute("insertedTeacher", teacherDTO);
			
			request.getRequestDispatcher("/jsps/teacherinserted.jsp")
			.forward(request, response);//edw tha me stilei ean ginei to insert mazi me ta dedomena pou ekana insert kai ta diavazei
		}
		catch(SQLException e)
		{
			//se periptosh lathous ftiaxnw ena atribute me error
			// h selid tha perimenei na parei kapio error apo eki me atribute name "sqlError"
			//to pernaw me dispatcher sthn selida /jsps/teachersmenu
			request.setAttribute("sqlError", true);
			request.getRequestDispatcher("/jsps/menu.jsp")//edw tha me stilei ean den ginei to insert mazi me ena lathos
			.forward(request, response);
		}
		
		
	}

}
