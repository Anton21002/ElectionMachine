package app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import app.model.Question;

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

	public int saveQuestion(Question question) {
		Statement stmt=null;
		int count=0;
		try {
			stmt = conn.createStatement();
			count=stmt.executeUpdate("insert into KYSYMYS(KYSYMYS) values('"+question.getQuestion()+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	public ArrayList<Question> readAllQuestions() {
		ArrayList<Question> list=new ArrayList<>();
		Statement stmt=null;
		int count=0;
		try {
			stmt = conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from KYSYMYS");
			while (rs.next()) {
				Question question=new Question();
				question.setId(rs.getInt("KYSYMYS_ID"));
				question.setQuestion(rs.getString("KYSYMYS"));
				list.add(question);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public int updateQuestion(Question question) {
		int count = 0;
		String sql = "update KYSYMYS set KYSYMYS = ? where KYSYMYS_ID = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, question.getQuestion());
			
			stmt.setInt(3, question.getId());
			
			count = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	public int removeQuestion(Question question) {
		Statement stmt=null;
		int count=0;
		try {
			stmt = conn.createStatement();
			count=stmt.executeUpdate("delete from KYSYMYS where KYSYMYS_ID='"+question.getId()+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	public Question getQuestionInfo(int id) {
		Question result = null;
		String sql = "select * from Kysymys where KYSYMYS_ID = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
						
			stmt.setInt(1, id);
			
			ResultSet resultset = stmt.executeQuery();
			
			if (resultset.next()) {
				result = new Question();
				result.setId(resultset.getInt("KYSYMYS_ID"));
				result.setQuestion(resultset.getString("KYSYMYS"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
