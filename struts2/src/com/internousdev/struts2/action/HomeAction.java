/**
 *
 */
package com.internousdev.struts2.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.struts2.dao.LoginDAO;
import com.internousdev.struts2.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware{

	private String userID;

	private Map<String, Object> session;

	private ArrayList<ItemDTO> itemList = new ArrayList<ItemDTO>();

	private String itemID;

	private String itemName;

	public String execute(){
		String ret = ERROR;
		LoginDAO dao = new LoginDAO();
		if(session.containsKey("userID")){
			itemList = dao.getItemID();
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

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ArrayList<ItemDTO> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<ItemDTO> itemList) {
		this.itemList = itemList;
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
}
