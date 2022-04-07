package app;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(
	    name = "EditEhdokkaat",
	    urlPatterns = {"/EditEhdokkaat"}
	    )
	    public class EditEhdokkaat extends HttpServlet {
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


	       String Snimi =request.getParameter("SUKUNIMI");    
	       String Enimi =request.getParameter("ETUNIMI");    
	       String Puolue =request.getParameter("PUOLUE");    
	       String Koti =request.getParameter("KOTIPAIKKAKUNTA");   
	       int Ika=Integer.parseInt(request.getParameter("IKA")); 
	       String kys1 =request.getParameter("MIKSI_EDUSKUNTAAN");    
	       String kys2 =request.getParameter("MITA_ASIOITA_HALUAT_EDISTAA");    
	       String Ammatti =request.getParameter("AMMATTI");    
	       int EhdID =Integer.parseInt(request.getParameter("EHDOKAS_ID"));

	   	try {

	   	
	   		Class.forName("com.mysql.jdbc.Driver").newInstance();
	   		
	   		
	   		conn=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/vaalikone", "pena", "kukkuu");	   		
	   		String query="UPDATE EHDOKKAAT SET SUKUNIMI=?,ETUNIMI=?,PUOLUE=?,KOTIPAIKKAKUNTA=?,IKA=?,MIKSI_EDUSKUNTAAN=?,MITA_ASIOITA_HALUAT_EDISTAA=?,AMMATTI=? WHERE EHDOKAS_ID=? ;";
	   		 PreparedStatement pstmt=conn.prepareStatement(query);    
	            pstmt.setString(1, Snimi);    
	            pstmt.setString(2,Enimi);    
	            pstmt.setString(3, Puolue);    
	            pstmt.setString(4, Koti);    
	            pstmt.setInt(5,Ika); 
	            pstmt.setString(6,kys1); 
	            pstmt.setString(7,kys2); 
	            pstmt.setString(8,Ammatti); 
	            pstmt.setInt(9,EhdID);
	            
	            int x=pstmt.executeUpdate();    
	            
	            if(x==1)    
	            {    
	      out.println("Candidate Edited Successfully");  
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
	   	/*public void doGet(HttpServletRequest request, HttpServletResponse response) 
	   		      throws IOException, ServletException {

		       Connection conn;
		       response.setContentType("text/html");
		       response.setCharacterEncoding("UTF-8");
		       PrintWriter out;    
		       out=response.getWriter(); 
		   
		       int EhdID=request.getIntHeader("Ehdokas_id") ;
		       
	   	try {
Class.forName("com.mysql.jdbc.Driver").newInstance();
	   		
	   		
	   		conn=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:6033/vaalikone", "root", "password");
	   		String query="SELECT COUNT(1) FROM EHDOKKAAT WHERE EHDOKAS_ID=? ";
	   		PreparedStatement pstmget=conn.prepareStatement(query);
	   		pstmget.setInt(1, EhdID);
	   		ResultSet result=pstmget.executeQuery(query) ;
		    while(result.next()) {
		    	
		    	Ehdokkaat ehdokas =new Ehdokkaat();

		    	ehdokas.setEHDOKAS_ID(result.getInt(1));

		    	ehdokas.setSUKUNIMI(result.getString(2));
		    	ehdokas.setETUNIMI(result.getString(3));
		    	ehdokas.setPUOLUE(result.getString(4));
		    	ehdokas.setKOTIPAIKKAKUNTA(result.getString(5));
		    	ehdokas.setIKA(result.getInt(6));
		    	ehdokas.setMIKSI_EDUSKUNTAAN(result.getString(7));
		    	ehdokas.setMITA_ASIOITA_HALUAT_EDISTAA(result.getString(8));
		    	ehdokas.setAMMATTI(result.getString(9));
	   	}}
	   	catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
		   		e.printStackTrace();
	   		}
	   		
	   	
	   	out.close();
	   	}*/}
	   