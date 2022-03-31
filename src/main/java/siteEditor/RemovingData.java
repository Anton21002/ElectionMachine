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
public void RemoveQuestion (HttpServletRequest request, HttpServletResponse response,Questions question) 
	      throws IOException, ServletException {
	conn=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:6033/vaalikone", "root", "password");
int Remquesexec = 0;
String sql="DELETE FROM kysymykset WHERE KYSYMYS_ID=?";
try {
	PreparedStatement stmt = conn.prepareStatement(sql);
	stmt.setInt(1,question.getKYSYMYSID);
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
