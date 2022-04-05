package siteEditor;

import java.sql.SQLException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


import dao.Dao;
import model.Kysymys;


public class RemovingData {
	
 private Connection conn;
 


public void RemoveCandidate (HttpServletRequest request, HttpServletResponse response,Ehdokkaat ehdokas) 
	      throws IOException, ServletException {
	conn=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:6033/vaalikone", "root", "password");
int countRemcand = 0;
String sql="DELETE FROM ehdokkaat WHERE EHDOKAS_ID=?";
try {
	
	PreparedStatement stmt = conn.prepareStatement(sql);
	stmt.setInt(1,ehdokas.getEHDOKAS_ID);
	
	countRemcand=stmt.executeUpdate();
} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
if(countRemcand==1)
{
System.out.println("Candidate Successfully Removed");	
}


conn.close();
}
public void RemoveQuestion (HttpServletRequest request, HttpServletResponse response,Kysymuset kysymus) 
	      throws IOException, ServletException {
	conn=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:6033/vaalikone", "root", "password");
int Remquesexec = 0;
String sql="DELETE FROM kysymykset WHERE KYSYMYS_ID=?";
try {
	PreparedStatement stmt = conn.prepareStatement(sql);
	stmt.setInt(1,kysymus.getKYSYMYSID);
	Remquesexec=stmt.executeUpdate() ;
} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
if(Remquesexec==1) {
System.out.println("Question Successfully Removed");	
}
conn.close();
}
}
public class RemoveKysymys extends HttpServlet {
	
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
				
				RequestDispatcher rd = request.getRequestDispatcher("jsp/removekysymys.jsp");
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
		
		dao.removeKysymys(kysymys);
		
		dao.close();
		
		// Back to list after actions
		//RequestDispatcher rd = request.getRequestDispatcher("/showdata");
		//rd.forward(request, response);
		response.sendRedirect("/showkysymys");
	}
	
	private Kysymys readKysymys(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Kysymys kysymys=new Kysymys();
		kysymys.setKYSYMYS(request.getParameter("breed"));
		kysymys.setId(Integer.parseInt(request.getParameter("KYSYMYS_ID")));
		return kysymys;
	}
}
