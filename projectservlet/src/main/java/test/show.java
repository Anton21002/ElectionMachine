package test;

import javax.servlet.http.HttpServlet;




import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(
	    name = "show",
	    urlPatterns = {"/show"}
	)
public class show extends HttpServlet {

	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
	    response.setContentType("text/html");
        out.println(" <br><br><a href='' >Add New Candidate</a><br><br>");
	    out.println("<br><br>");

        out.println("<h1>Candidates List</h1>");  
		List <Ehdokkaat>  Ehdokass =Ehdokkaatsql.getEhdokkaitta();


    
        out.println("<table border='2' width='100%'");
        out.println("<tr><th>EhdokasId</th><th>Sukunimi</th>"+"<th>Etunimi</th><th>Puolue</th>"+"<th>KOTIPAIKKAKUNTA</th><th>IKA</th>"+"<th>miksi_eduskuntaan</th><th>Mita_haluat_edistaa</th><th>Ammatti</th></tr>");
        for(Ehdokkaat ehdokas:Ehdokass) {
        	out.print("<tr><td>"+ehdokas.getEHDOKAS_ID()+"</td><td>"+ehdokas.getSUKUNIMI()+"</td><td>"+ehdokas.getETUNIMI()+"</td><td>"+ehdokas.getPUOLUE()+"</td><td>"+ehdokas.getKOTIPAIKKAKUNTA()+"</td><td>"+ehdokas.getIKA()+"</td><td>"+ehdokas.getMIKSI_EDUSKUNTAAN()+"</td><td>"+ehdokas.getMITA_ASIOITA_HALUAT_EDISTAA()+"</td><td>"+ehdokas.getAMMATTI()+"</td><td><a href='="+ehdokas.getEHDOKAS_ID()+"'>edit</a></td><td><a href='="+ehdokas.getEHDOKAS_ID()+"'>delete</a></td></tr>");

        }
        
        out.print("</table>");
        out.print("</body>");


        out.close();

	    
	    
		
		
		
	}
	

}
