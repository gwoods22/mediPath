package data_mangement;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * IO class that handles the input from the website
 * and passing the result to the Java Server Page
 * @author Graeme Woods
 */
@SuppressWarnings("serial")
public class IO extends HttpServlet {
	@SuppressWarnings("rawtypes")
	/**
	 * doPost
	 * Reads form data from HTML to pass that into the Processor
	 * class to call the Graph and database. It then passes the 
	 * result from the backend on to the Java Server Page to be
	 * displayed for the user on a web page.
	 * 
	 * @param request - request from HTTP server
	 * @param response - response from said server
	 * @return Returns the list of hospitals
	 */
	public void doPost(HttpServletRequest request,
					   HttpServletResponse response
					   ) throws IOException, ServletException {
		Processor be = new Processor();
		String surgery = request.getParameter("surgery");
		String address = request.getParameter("address");
		String zipcode = request.getParameter("zipcode");
		List result = be.process(surgery, address, zipcode);
		request.setAttribute("styles", result);
		RequestDispatcher view = request.getRequestDispatcher("result.jsp");
		view.forward(request, response);
	} 
}