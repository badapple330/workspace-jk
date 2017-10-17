/**
 *
 */
package com.internousdev.struts2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.struts2.util.DBConnector;

public class CreateCreditCardDAO {

	public int insert(String userID, String cardCategory,  String cardHolder, String cardNumber, String month, String year, String security){
		int ret=0;
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "insert into creditcard(user_id, category, name, cardNumber, month, year, security)"
				+ "	+ value(?,?,?,?,?,?,?)";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userID);
			ps.setString(2, cardCategory);
			ps.setString(3, cardHolder);
			ps.setString(4, cardNumber);
			ps.setString(5, month);
			ps.setString(6, year);
			ps.setString(7, security);
			ret = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ret;
	}

}
