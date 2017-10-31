/**
 *
 */
package com.internousdev.struts2.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.struts2.dao.UserCreateDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateAction extends ActionSupport implements SessionAware {

	private String userID;

	private String password;

	private Map<String, Object> session;

	public String execute(){
		String ret = ERROR;
		UserCreateDAO dao = new UserCreateDAO();
		if(dao.insert(userID, password)>0){
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * sessionを取得します。
	 * @return session
	 */
	public Map<String, Object> getSession() {
		return session;
	}

	/**
	 * sessionを設定します。
	 * @param session session
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


}
