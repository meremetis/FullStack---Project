package gr.aueb.sev.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;


//edw orizw oti se ola ta urls meta to slash tha exoun auto to filter
//opia dieuthinsh kai na zitisei o xrisths pada tha trexei auto to filter
@WebFilter("/*")
public class GRFilter extends HttpFilter implements Filter {
       
   
	private static final long serrialVersionUID = 1L;
	
	

	/**
	 * filter gia otan o klient stelnei elinika se emas.
	 * giati emis boroume na orisume sto response ti tha stelnoume
	 * ala gia to ti tha mas erxete prepi na exoume filter
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		((HttpServletRequest)request).setCharacterEncoding("UTF-8");
		//request.setCharacterEncoding("UTF-8"); THA BOROUSE KAI ETSI ALA EINAI PIO GENIKO
		chain.doFilter(request, response);// TO PROOTHEI STO EPOMENO FILTER GIATI BOREI NA EXW POLLA FILTER
		//EAN EXW PANW APO ENA FILTER THA PREPI NA PAW STO WEBxML KAI NA ORISW THN SEIRA POU KALOUNTE TA FILTERS
	}

	
	

}
