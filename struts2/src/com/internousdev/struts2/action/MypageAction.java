/**
 *
 */
package com.internousdev.struts2.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.struts2.dao.MypageDAO;
import com.internousdev.struts2.dto.ItemDTO;
import com.internousdev.struts2.dto.LoginDTO;
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

	public String execute(){
		String ret = ERROR;
		MypageDAO dao = new MypageDAO();
		LoginDTO dto = new LoginDTO();
		oldID = (String) session.get("userID");	//変更の場合古いセッションを呼び出す。

		if((dto = dao.update(oldID, userID, password))!=null){
			ret = SUCCESS;
			userID = dto.getUserID();
			password = dto.getPassword();
			session.put("userID", userID);
			setItemList(dao.selecthistory(userID));
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
}
