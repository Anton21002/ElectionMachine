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
import javax.servlet.http.HttpSession;

import app.dao.Dao;
import app.model.Kysymys;

@WebServlet(
		name = "EditKysymys",
		urlPatterns = {"/editkysymys"}
		)
public class EditKysymys extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		
		// if sessions does not exist, create new one
		HttpSession session = request.getSession();
		
		String idValue = request.getParameter("id");
		
		if ( idValue != null ) {
			try {
				int id = Integer.parseInt(idValue);
				
				Dao dao = new Dao();
				Kysymys kysymys = dao.getKysymysInfo(id);
				
				session.setAttribute("kysymys", kysymys);
				
				RequestDispatcher rd = request.getRequestDispatcher("jsp/editkysymys.jsp");
				rd.forward(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			// Back to list
			response.sendRedirect("/showkysymys");
			
		}
	
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
	
		
		// Create connection
		Dao dao=new Dao();
		Kysymys kysymys = readKysymys(request);
		
		dao.updateKysymys(kysymys);
		
		dao.close();
		
		// Back to list after actions
		//RequestDispatcher rd = request.getRequestDispatcher("/showkysymys");
		//rd.forward(request, response);
		response.sendRedirect("/showkysymys");
	}
	
	private Kysymys readKysymys(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Kysymys kysymys=new Kysymys();
		kysymys.setId(Integer.parseInt(request.getParameter("id")));
		kysymys.setKYSYMYS(request.getParameter("KYSYMYS"));
		return kysymys;
	}
}
