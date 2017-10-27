/**
 *
 */
package com.internousdev.struts2.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.struts2.dao.MypageDAO;
import com.internousdev.struts2.dao.PaymentDAO;
import com.internousdev.struts2.dto.ItemDTO;
import com.internousdev.struts2.dto.LoginDTO;
import com.internousdev.struts2.dto.PaymentDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author internousdev
 *
 */
public class MypageAction extends ActionSupport implements SessionAware{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private String userID;

	private String oldID;

	private String password;

	private Map<String, Object> session;

	private String itemID;

	private String itemName;

	private int price;

	private int quantityl;

	private ArrayList<ItemDTO> itemList = new ArrayList<ItemDTO>();

	//payment
	private String cardCategory;

	private String cardHolder;

	private String cardNumber;

	private String month;

	private String year;

	private String security;
	
	//date
	private String date;

	public String execute(){
		String ret = ERROR;
		MypageDAO dao = new MypageDAO();
		LoginDTO dto = new LoginDTO();
		PaymentDAO dao2 = new PaymentDAO();
		PaymentDTO dto2 = new PaymentDTO();
		oldID = (String) session.get("userID");	//変更の場合古いセッションを呼び出す。

		if((dao.update(oldID, userID, password))>0){
			if((dto = dao.select(userID))!=null){
				ret = SUCCESS;
				userID = dto.getUserID();
				password = dto.getPassword();
				session.put("userID", userID);
				itemList = dao.selecthistory(userID);
				if((dto2 = dao2.getinfo(userID))!=null){
					cardCategory = dto2.getCardCategory();
					cardHolder = dto2.getCardHolder();
					cardNumber = dto2.getCardNumber();
					month = dto2.getMonth();
					year = dto2.getYear();
					security = dto2.getSecurity();
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Map<String, Object> getSession(){
		return session;
	}
	public void setSession(Map<String, Object> session){
		this.session = session;
	}

	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantityl() {
		return quantityl;
	}

	public void setQuantityl(int quantityl) {
		this.quantityl = quantityl;
	}

	public ArrayList<ItemDTO> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<ItemDTO> itemList) {
		this.itemList = itemList;
	}

	public String getOldID() {
		return oldID;
	}

	public void setOldID(String oldID) {
		this.oldID = oldID;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
