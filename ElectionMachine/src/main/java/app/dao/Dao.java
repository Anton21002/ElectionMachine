package app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import app.model.Kysymys;

public class Dao {

	private Connection conn;

	// When new instance is created, also DB-connection is created
	public Dao() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/vaalikone", "pena", "kukkuu");
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Manually close DB-connection for releasing resource
	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int saveKysymys(Kysymys kysymys) {
		Statement stmt=null;
		int count=0;
		try {
			stmt = conn.createStatement();
			count=stmt.executeUpdate("insert into kysymykset set KYSYMYS='"+kysymys.getKYSYMYS()+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	public ArrayList<Kysymys> readAllKysymys() {
		ArrayList<Kysymys> list=new ArrayList<>();
		Statement stmt=null;
		int count=0;
		try {
			stmt = conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from kysymykset");
			while (rs.next()) {
				Kysymys kysymys=new Kysymys();
				kysymys.setId(rs.getInt("KYSYMYS_ID"));
				kysymys.setKYSYMYS(rs.getString("KYSYMYS"));
				list.add(kysymys);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public int updateKysymys(Kysymys kysymys) {
		int count = 0;
		String sql = "update kysymykset set KYSYMYS = ? where KYSYMYS_ID = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, kysymys.getKYSYMYS());

			stmt.setInt(2, kysymys.getId());
			
			count = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	public int removeKysymys(Kysymys kysymys) {
		Statement stmt=null;
		int count=0;
		try {
			stmt = conn.createStatement();
			count=stmt.executeUpdate("delete from kysymykset where KYSYMYS_ID='"+kysymys.getId()+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	public Kysymys getKysymysInfo(int id) {
		Kysymys result = null;
		String sql = "select * from kysymykset where KYSYMYS_ID = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
						
			stmt.setInt(1, id);
			
			ResultSet resultset = stmt.executeQuery();
			
			if (resultset.next()) {
				result = new Kysymys();
				result.setId(resultset.getInt("KYSYMYS_ID"));
				result.setKYSYMYS(resultset.getString("KYSYMYS"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
