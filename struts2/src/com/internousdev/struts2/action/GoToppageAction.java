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

/**
 * @author internousdev
 *
 */
public class GoToppageAction extends ActionSupport implements SessionAware{

	/**
	 *
	 */
	private static final long serialVersionUID = -4338515303841011415L;

	private Map<String, Object> session;

	private ArrayList<ItemDTO> itemList = new ArrayList<ItemDTO>();

	public String execute(){
		String ret = ERROR;
		LoginDAO dao = new LoginDAO();
		itemList = dao.getItemID();
		if(itemList.size()>0){
			ret = SUCCESS;
		}
		return ret;
	}

	public Map<String, Object> getSession(){
		return session;
	}
	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}
