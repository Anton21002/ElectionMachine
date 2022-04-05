package app.model;

import java.io.Serializable;

public class Kysymys implements Serializable{
	private int KYSYMYS_ID;
	private String KYSYMYS;


	public int getId() {
		return KYSYMYS_ID;
	}
	public void setId(int id) {
		this.KYSYMYS_ID = id;
	}
	public String getKYSYMYS() {
		return KYSYMYS;
	}
	public void setKYSYMYS(String kysymys) {
		this.KYSYMYS = kysymys;
	}
	public String toString() {
		return KYSYMYS_ID+" "+KYSYMYS;
	}
}
