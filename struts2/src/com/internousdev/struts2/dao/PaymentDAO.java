/**
 *
 */
package com.internousdev.struts2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.struts2.util.DBConnector;

/**
 * @author internousdev
 *
 */
public class PaymentDAO {

	public int select(String cardCategory, String cardHolder, String cardNumber, String month, String year,
			String security, String userID) {
//		ArrayList<PaymentDTO> paymentList = new ArrayList<PaymentDTO>;
		int ret=0;
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "select * from creditcard where category=? and name=? and cardnumber=? and month=? and year=? and security=? and userid=?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cardCategory);
			ps.setString(2, cardHolder);
			ps.setString(3, cardNumber);
			ps.setString(4, month);
			ps.setString(5, year);
			ps.setString(6, security);
			ps.setString(7, userID);
			ret = ps.executeUpdate();
		}catch(SQLException e){
        	e.printStackTrace();
        	}finally{
        		try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
        	}
		return ret;
	}

}
