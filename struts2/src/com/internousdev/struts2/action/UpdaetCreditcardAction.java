/**
 *
 */
package com.internousdev.struts2.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.struts2.dao.UpdaetCreditcardDAO;
import com.internousdev.struts2.dto.ItemDTO;
import com.internousdev.struts2.dto.PaymentDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author internousdev
 *
 */
public class UpdaetCreditcardAction extends ActionSupport implements SessionAware{

	/**
	 *
	 */
	private static final long serialVersionUID = 5679775953195747945L;

	private String userID;

	private String cardCategory;

	private String cardHolder;

	private String cardNumber;

	private String month;

	private String year;

	private String security;

	private ArrayList<ItemDTO> cartInfoList = new ArrayList<ItemDTO>();

    private Map<String, Object> session;

    public String execute(){
    	String ret = ERROR;
    	UpdaetCreditcardDAO dao = new UpdaetCreditcardDAO();
    	PaymentDTO dto = new PaymentDTO();
    	if((dto = dao.update(cardCategory,cardHolder,cardNumber,month,year,security,userID))!=null){
    		ret = SUCCESS;
			cardCategory = dto.getCardCategory();
			cardHolder = dto.getCardHolder();
			cardNumber = dto.getCardNumber();
			month = dto.getMonth();
			year = dto.getYear();
			security = dto.getSecurity();
    	}
    	return ret;
    }

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getCardCategory() {
		return cardCategory;
	}

	public void setCardCategory(String cardCategory) {
		this.cardCategory = cardCategory;
	}

	public String getCardHolder() {
		return cardHolder;
	}

	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getSecurity() {
		return security;
	}

	public void setSecurity(String security) {
		this.security = security;
	}

	public ArrayList<ItemDTO> getCartInfoList() {
		return cartInfoList;
	}

	public void setCartInfoList(ArrayList<ItemDTO> cartInfoList) {
		this.cartInfoList = cartInfoList;
	}
}
