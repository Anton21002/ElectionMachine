package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Ehdokkaatsql {

		
	public static Connection getConnection()  {
	    Connection conn = null;  
	    
	    
	    try {

			Class.forName("com.mysql.jdbc.Driver");
			
			
			conn=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/vaalikone", "pena", "kukkuu");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}  
	    return conn;
	    
		
		
		
	}
	
	public static List<Ehdokkaat> getEhdokkaitta() {
	    List<Ehdokkaat> list= new ArrayList<Ehdokkaat>();

		String query="SELECT * FROM EHDOKKAAT ";
		Connection conn=Ehdokkaatsql.getConnection();

		PreparedStatement statement;
		try {

			statement = conn.prepareStatement(query);
		    ResultSet result;
			result=statement.executeQuery(query);



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

		        list.add(ehdokas);

		    }

			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	  

	    
	    

			return list;
	}
	
	public static int Delete(int ehdokasId) {
		String sql ="DELETE FROM EHDOKKAAT WHERE EHDOKAS_ID=?";
		Connection conn=Ehdokkaatsql.getConnection();

	    try {
	    	PreparedStatement statement=  conn.prepareStatement(sql);
	    	statement.setInt(1,ehdokasId);
	        statement.execute();
	        statement.executeUpdate();
	        conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ehdokasId;
		
	}

	

}
