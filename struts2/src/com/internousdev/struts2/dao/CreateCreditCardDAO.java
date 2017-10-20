/**
 *
 */
package com.internousdev.struts2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.struts2.dto.PaymentDTO;
import com.internousdev.struts2.util.DBConnector;

public class CreateCreditCardDAO {

	public int insert(String userID, String cardCategory,  String cardHolder, String cardNumber, String month, String year, String security){
//		ArrayList<PaymentDTO> cardInfo = new ArrayList<PaymentDTO>();
		int ret = 0;
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "insert into creditcard(user_id, category, name, cardNumber, month, year, security)"
				+ "values(?,?,?,?,?,?,?)";
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

	public ArrayList<PaymentDTO> select(String userID, String cardCategory,  String cardHolder, String cardNumber, String month, String year, String security){
		ArrayList<PaymentDTO> cardInfo = new ArrayList<PaymentDTO>();
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "select * from creditcard where user_id=? and category=? and name=? and cardNumber=? and month=? and year=? and security=?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userID);
			ps.setString(2, cardCategory);
			ps.setString(3, cardHolder);
			ps.setString(4, cardNumber);
			ps.setString(5, month);
			ps.setString(6, year);
			ps.setString(7, security);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				PaymentDTO dto = new PaymentDTO();
				dto.setCardCategory(rs.getString("category"));
				dto.setCardHolder(rs.getString("name"));
				dto.setCardNumber(rs.getString("cardNumber"));
				dto.setMonth(rs.getString("month"));
				dto.setYear(rs.getString("year"));
				dto.setSecurity(rs.getString("security"));
				dto.setUserID(rs.getString("user_id"));
				cardInfo.add(dto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cardInfo;
	}
}
