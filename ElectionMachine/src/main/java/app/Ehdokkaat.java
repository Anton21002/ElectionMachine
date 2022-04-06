package app;

import javax.servlet.http.HttpServlet;

public class Ehdokkaat extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String SUKUNIMI,ETUNIMI,PUOLUE,KOTIPAIKKAKUNTA,MIKSI_EDUSKUNTAAN , MITA_ASIOITA_HALUAT_EDISTAA,AMMATTI;

	private int EHDOKAS_ID , IKA;
	
	
	public int getEHDOKAS_ID() {
		return EHDOKAS_ID;
	}
	public void setEHDOKAS_ID(int eHDOKAS_ID) {
		EHDOKAS_ID = eHDOKAS_ID;
	}
	public int getIKA() {
		return IKA;
	}
	public void setIKA(int iKA) {
		IKA = iKA;
	}
	public String getSUKUNIMI() {
		return SUKUNIMI;
	}
	public void setSUKUNIMI(String sUKUNIMI) {
		SUKUNIMI = sUKUNIMI;
	}
	public String getETUNIMI() {
		return ETUNIMI;
	}
	public void setETUNIMI(String eTUNIMI) {
		ETUNIMI = eTUNIMI;
	}
	public String getPUOLUE() {
		return PUOLUE;
	}
	public void setPUOLUE(String pUOLUE) {
		PUOLUE = pUOLUE;
	}
	public String getKOTIPAIKKAKUNTA() {
		return KOTIPAIKKAKUNTA;
	}
	public void setKOTIPAIKKAKUNTA(String kOTIPAIKKAKUNTA) {
		KOTIPAIKKAKUNTA = kOTIPAIKKAKUNTA;
	}
	public String getMIKSI_EDUSKUNTAAN() {
		return MIKSI_EDUSKUNTAAN;
	}
	public void setMIKSI_EDUSKUNTAAN(String mIKSI_EDUSKUNTAAN) {
		MIKSI_EDUSKUNTAAN = mIKSI_EDUSKUNTAAN;
	}
	public String getMITA_ASIOITA_HALUAT_EDISTAA() {
		return MITA_ASIOITA_HALUAT_EDISTAA;
	}
	public void setMITA_ASIOITA_HALUAT_EDISTAA(String mITA_ASIOITA_HALUAT_EDISTAA) {
		MITA_ASIOITA_HALUAT_EDISTAA = mITA_ASIOITA_HALUAT_EDISTAA;
	}
	public String getAMMATTI() {
		return AMMATTI;
	}
	public void setAMMATTI(String aMMATTI) {
		AMMATTI = aMMATTI;
	}
	
	

}
