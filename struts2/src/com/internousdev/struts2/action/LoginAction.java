/**
 *
 */
package com.internousdev.struts2.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.struts2.dao.LoginDAO;
import com.internousdev.struts2.dto.ItemDTO;
import com.internousdev.struts2.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author internousdev
 *
 */
public class LoginAction extends ActionSupport implements SessionAware{


	/**
	 *
	 */
	private static final long serialVersionUID = -3068950895491830095L;
	private String name;
	private String password;
	private Map<String, Object> session;
	private ArrayList<ItemDTO> itemList = new ArrayList<ItemDTO>();

	private String itemID;

	public String execute(){
		String ret = ERROR;
		LoginDAO dao = new LoginDAO();
		LoginDTO dto = new LoginDTO();

		dto = dao.select(name, password);
		if(name.equals(dto.getName())){
			if(password.equals(dto.getPassword())){
			ret = SUCCESS;
			session.put("name", dto.getName());
			}
		}
		if(ret.equals("SUCCESS")){
			itemList = dao.getitemID();
		}
		return ret;
	}

	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}

	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}

	public Map<String, Object> getSession(){
		return session;
	}
	public void setSession(Map<String, Object> session){
		this.session = session;
	}

	/**
	 * itemID取得メソッド
	 * @auther jk
	 * @return itemID
	 */
	public String getItemID() {
		return itemID;
	}

	/**
	 *  itemID格納メソッド
	 * @auther jk
	 * @param itemID
	 */
	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	/**
	 * itemList取得メソッド
	 * @auther jk
	 * @return itemList
	 */
	public ArrayList<ItemDTO> getItemList() {
		return itemList;
	}

	/**
	 *  itemList格納メソッド
	 * @auther jk
	 * @param itemList
	 */
	public void setItemList(ArrayList<ItemDTO> itemList) {
		this.itemList = itemList;
	}


}
