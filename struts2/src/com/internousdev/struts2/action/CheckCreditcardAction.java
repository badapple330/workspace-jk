/**
 *
 */
package com.internousdev.struts2.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.struts2.dto.PaymentDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author internousdev
 *
 */
public class CheckCreditcardAction extends ActionSupport implements SessionAware{

	private String cardCategory;

	private String cardHolder;

	private String cardNumber;

	private String month;

	private String year;

	private String security;

	private ArrayList<PaymentDTO> paymentList = new ArrayList<PaymentDTO>();

    private Map<String, Object> session;

    public String execute(){
    	String ret = ERROR;
    	PaymentDTO dto = new PaymentDTO();
    	if(cardCategory != null){
    		dto.setCardCategory(cardCategory);
    		if(cardHolder != null){
    			dto.setCardHolder(cardHolder);
        		if(cardNumber != null){
        			dto.setCardNumber(cardNumber);
            		if(month != null){
            			dto.setMonth(month);
                		if(year != null){
                			dto.setYear(year);
                    		if(security != null){
                    			dto.setSecurity(security);
                    			ret = SUCCESS;
                    		}
                		}
            		}
        		}
    		}
    	}
        return ret;
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

	public ArrayList<PaymentDTO> getPaymentList() {
		return paymentList;
	}

	public void setPaymentList(ArrayList<PaymentDTO> paymentList) {
		this.paymentList = paymentList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
