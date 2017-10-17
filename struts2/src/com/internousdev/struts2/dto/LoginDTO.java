/**
 *
 */
package com.internousdev.struts2.dto;


public class LoginDTO {

	private int id;

	private String userID;

	private String password;

	private int adminflg;


	/**
	 * id取得メソッド
	 * @auther
	 * @return id
	 */
	public int getId() {
		return id;
	}
	/**
	 *  id格納メソッド
	 * @auther
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * password取得メソッド
	 * @auther
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 *  password格納メソッド
	 * @auther
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}

	public int getAdminflg() {
		return adminflg;
	}
	public void setAdminflg(int adminflg) {
		this.adminflg = adminflg;
	}

}
