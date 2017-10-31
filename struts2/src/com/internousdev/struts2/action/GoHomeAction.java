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
public class GoHomeAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;

	public String execute(){
		String ret = ERROR;
		if(session.containsKey("userID")){
			ret = SUCCESS;
		}
		return ret;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
