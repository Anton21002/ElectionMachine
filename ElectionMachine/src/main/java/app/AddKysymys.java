package app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.dao.Dao;
import app.model.Kysymys;

/*
 * The name of the servlet is AddGame
 * and the servlet's URI (url-pattern) is 'addgame'
 */
@WebServlet(
		name = "AddKysymys",
		urlPatterns = {"/addkysymys"}
		)
public class AddKysymys extends HttpServlet {
	/*
	 * If the request type is POST, the request is transferred to the method doGet
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		doGet(request, response);
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		/*
		 * With a RequestDispatcher object is the htmlstart.html file included to this servlet
		 */
		RequestDispatcher rd=request.getRequestDispatcher("staticpages/htmlstart.html");
		rd.include(request,  response);;
		
		// Read parameters to Model
		Kysymys kysymys=readKysymys(request);
	
		// Create connection
		Dao dao=new Dao();
		
		// Save value and query total list
		dao.saveKysymys(kysymys);
		ArrayList<Kysymys> list=dao.readAllKysymys();
		
		// print output and close connection
		printKysymysList(out, list);
		dao.close();
		
		
		out.println("<br><a href='./form.html'>Back to form</a>");

		/*
		 * With a RequestDispatcher object is the htmlend.html file included to this servlet
		 */
		rd=request.getRequestDispatcher("staticpages/htmlend.html");
		rd.include(request,  response);;
	}


	private Kysymys readKysymys(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Kysymys kysymys=new Kysymys();
		kysymys.setKYSYMYS(request.getParameter("breed"));
		return kysymys;
	}
	
	private void printKysymysList(PrintWriter out, ArrayList<Kysymys> list) {
		out.println("<ul>");
		for (Kysymys g:list) {
			out.println("<li>"+g);
		}
		out.println("</ul>");
	}

}