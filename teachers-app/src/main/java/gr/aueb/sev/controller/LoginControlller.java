package gr.aueb.sev.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginControlller extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
   
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		//kanw set thn kodikopiish se UTF-8
		response.setContentType("text/html, charset=UTF-8");
		
		String eMail = request.getParameter("eMail").trim();

		String passWord = request.getParameter("password").trim();
		
		//Assume we call a log in service.
		
		if(eMail.equals("mere.p.w_@hotmail.com") && (passWord.equals("admin"))) 
		{
			//einai ena log in page pou an einai swsto to log in tha ton paei sto teachers menu
			request.getRequestDispatcher("/jsps/menu.jsp").forward(request, response);
		}
		else //ean den dosei ta swsta kridential paramanei sthn selida tou log in kai tu dixnei ena lathos apo to "error"== true
		{
			request.setAttribute("error", true);
			request.getRequestDispatcher("/jsps/login.jsp").forward(request, response);
		}
		
		
	}

}
