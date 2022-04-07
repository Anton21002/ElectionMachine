package app;


import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
    name = "ADDEHDOKKAAT",
    urlPatterns = {"/ADDEHDOKKAAT"}
)
public class ADDEHDOKKAAT extends HttpServlet {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
		      throws IOException, ServletException {
          ;    


    Connection conn;
    response.setContentType("text/html");
    response.setCharacterEncoding("UTF-8");
    PrintWriter out;    
    out=response.getWriter();    


    String SUKUNIMI=request.getParameter("SUKUNIMI");    
    String ETUNIMI=request.getParameter("ETUNIMI");    
    String PUOLUE=request.getParameter("PUOLUE");    
    String KOTIPAIKKAKUNTA=request.getParameter("KOTIPAIKKAKUNTA");    
    String IKA=request.getParameter("IKA"); 
    String MIKSI_EDUSKUNTAAN=request.getParameter("MIKSI_EDUSKUNTAAN");    
    String MITA_ASIOITA_HALUAT_EDISTAA=request.getParameter("MITA_ASIOITA_HALUAT_EDISTAA");    
    String AMMATTI=request.getParameter("AMMATTI");    


	try {

	
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		
		conn=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:6033/vaalikone", "root", "password");
		
		String query="INSERT INTO EHDOKKAAT (SUKUNIMI,ETUNIMI,PUOLUE,KOTIPAIKKAKUNTA,IKA,MIKSI_EDUSKUNTAAN,MITA_ASIOITA_HALUAT_EDISTAA,AMMATTI) values(?,?,?,?,?,?,?,?);";
		 PreparedStatement pstmt=conn.prepareStatement(query);    
         pstmt.setString(1, SUKUNIMI);    
         pstmt.setString(2,ETUNIMI);    
         pstmt.setString(3, PUOLUE);    
         pstmt.setString(4, KOTIPAIKKAKUNTA);    
         pstmt.setString(5,IKA); 
         pstmt.setString(6,MIKSI_EDUSKUNTAAN); 
         pstmt.setString(7,MITA_ASIOITA_HALUAT_EDISTAA); 
         pstmt.setString(8,AMMATTI); 
         
         int x=pstmt.executeUpdate();    
         
         if(x==1)    
         {    
   out.println("candidate Inserted Successfully");  
   out.println("<a href='index.html' style=' color:black ;font-size:18px;' >Home</a><br>");

         } 

	} 
	catch 
	(InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
    out.close();    

  }

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}