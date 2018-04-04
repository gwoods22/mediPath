package data_mangement;

import java.io.IOException;
import java.util.List;

//Right Click on Project > Build Path > Add Jar > select javax.servlet
import javax.servlet.*;
import javax.servlet.http.*;
// then add these lines ^^

@SuppressWarnings("serial")
public class IO extends HttpServlet {
	@SuppressWarnings("rawtypes")
	public void doPost(HttpServletRequest request,
					   HttpServletResponse response
					   ) throws IOException, ServletException {
		Processor be = new Processor();
		String surgery = request.getParameter("surgery");
		String address = request.getParameter("address");
		String zipcode = request.getParameter("zipcode");
		List result = be.getBrands(surgery, address, zipcode);
		request.setAttribute("styles", result);
		RequestDispatcher view = request.getRequestDispatcher("result.jsp");
		view.forward(request, response);
	} 
}