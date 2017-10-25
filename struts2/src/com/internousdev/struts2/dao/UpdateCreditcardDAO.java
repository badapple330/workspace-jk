/**
 *
 */
package com.internousdev.struts2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.struts2.dto.PaymentDTO;
import com.internousdev.struts2.util.DBConnector;

/**
 * @author internousdev
 *
 */
public class UpdateCreditcardDAO {

	public int update(String cardCategory, String cardHolder, String cardNumber, String month, String year,
			String security, String userID){
		int ret=0;
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		PaymentDTO dto = new PaymentDTO();
		String sql ="update creditcard set category=?, name=?, cardnumber=?, month=?, year=?, security=? where user_id=?";
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
//			 if(rs.next()){
//				 dto.setCardCategory(rs.getString("category"));
//				 dto.setCardHolder(rs.getString("name"));
//				 dto.setCardNumber(rs.getString("cardnumber"));
//				 dto.setMonth(rs.getString("month"));
//				 dto.setYear(rs.getString("year"));
//				 dto.setSecurity(rs.getString("security"));
//			 }
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
