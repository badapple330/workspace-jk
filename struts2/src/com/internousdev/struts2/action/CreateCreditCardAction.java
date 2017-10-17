/**
 *
 */
package com.internousdev.struts2.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.struts2.dao.CreateCreditCardDAO;
import com.opensymphony.xwork2.ActionSupport;

public class CreateCreditCardAction extends ActionSupport implements SessionAware{

	/**
	 *
	 */
	private static final long serialVersionUID = -3362563855717247613L;

	private String userID;

	private String cardCategory;

	private String cardHolder;

	private String cardNumber;

	private String month;

	private String year;

	private String security;

	private Map<String, Object> session;

	public String execute(){
		String ret = ERROR;
		userID = (String) session.get("userID");
		CreateCreditCardDAO dao = new CreateCreditCardDAO();
		if(dao.insert(userID,cardCategory,cardHolder,cardNumber,month,year,security)>0){
			ret = SUCCESS;
		}
		return ret;
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


	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
