/**
 *
 */
package com.internousdev.struts2.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.struts2.dao.GoCartDAO;
import com.internousdev.struts2.dao.PaymentDAO;
import com.internousdev.struts2.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class PaymentAction extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = 4136432995188495958L;

	private String paySelect;

	private String userID;

	private String cardCategory;

	private String cardHolder;

	private String cardNumber;

	private String month;

	private String year;

	private String security;

	private ArrayList<ItemDTO> cartInfoList = new ArrayList<ItemDTO>();

    private Map<String, Object> session;

    private int total;

    public String execute(){
    	String ret = ERROR;
    	PaymentDAO dao = new PaymentDAO();
    	if (session.containsKey("userID")) {
    		userID = (String) session.get("userID");
    		//現金かクレカか
    		if(paySelect.equals("1")){ //クレカの場合
    			session.put("paySelect", 1);
    			if(dao.select(cardCategory, cardHolder, cardNumber, month, year, security, userID)>0){
    				GoCartDAO dao2 = new GoCartDAO();
    				cartInfoList = dao2.select(userID);
    				for(int i=0;i<cartInfoList.size();i++){
    					total = total + (cartInfoList.get(i).getSubtotal());
    				}
    				ret = SUCCESS;
    			}else{
    				System.out.println("入力ミスが存在します");
    				ret = ERROR;
    			}
    		}else{ //現金の場合
    			ret = SUCCESS;
    			GoCartDAO dao2 = new GoCartDAO();
				cartInfoList = dao2.select(userID);
				for(int i=0;i<cartInfoList.size();i++){
					total = total + (cartInfoList.get(i).getSubtotal());
				}
    		}
    	}
    	return ret;
    }

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
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

    /**
     * セッション情報を取得するメソッド
     * @return session　セッション情報
     */
    public Map<String, Object> getSession() {
        return session;
    }

    /**
     * セッションを格納するメソッド
     * @param session セットする session
     */
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }


}
