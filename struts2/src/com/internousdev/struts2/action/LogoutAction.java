/**
 *
 */
package com.internousdev.struts2.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author internousdev
 *
 */
public class LogoutAction extends ActionSupport implements SessionAware{

	/**
	 *
	 */
	private static final long serialVersionUID = -6069664682443483147L;
	private Map<String, Object> session;

//loginflagを書き換えるならsession.containskey判定とかしろ
	public String execute(){
		session.clear();
		return SUCCESS;
	}

	public Map<String, Object> getSession(){
		return session;
	}
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}

