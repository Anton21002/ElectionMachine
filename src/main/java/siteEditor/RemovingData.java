package siteEditor;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class RemovingData {
	
 private Connection conn;


public int RemoveCandidate (Candidates candidate) {
int countRemcand = 0;
String sql="DELETE FROM ehdokkaat WHERE EHDOKAS_ID=?";
try {
	PreparedStatement stmt = conn.prepareStatement(sql);
	stmt.setInt(1,candidate.getEhdokasid);
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}


return countRemcand;
}
public int RemoveQuestion (Questions question) {
int countRemques = 0;
String sql="DELETE FROM kysymykset WHERE KYSYMYS_ID=?";
try {
	PreparedStatement stmt = conn.prepareStatement(sql);
	stmt.setInt(1,question.getKYSYMYSID);
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
}
