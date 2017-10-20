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


public class PaymentDAO {

	public ArrayList<PaymentDTO> select(String cardCategory, String cardHolder, String cardNumber, String month, String year,
			String security, String userID) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		PaymentDTO dto = new PaymentDTO();
		ArrayList<PaymentDTO> paymentList = new ArrayList<PaymentDTO>();
		String sql = "select * from creditcard where category=? and name=? and cardnumber=? and month=? and year=? and security=? and user_id=?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cardCategory);
			ps.setString(2, cardHolder);
			ps.setString(3, cardNumber);
			ps.setString(4, month);
			ps.setString(5, year);
			ps.setString(6, security);
			ps.setString(7, userID);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				dto.setCardCategory(rs.getString("category"));
				dto.setCardHolder(rs.getString("name"));
				dto.setCardNumber(rs.getString("cardnumber"));
				dto.setMonth(rs.getString("month"));
				dto.setYear(rs.getString("year"));
				dto.setSecurity(rs.getString("security"));
				dto.setUserID(rs.getString("user_id"));
				paymentList.add(dto);
			}
		}catch(SQLException e){
        	e.printStackTrace();
        	}finally{
        		try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
        	}
		return paymentList;
	}

	public PaymentDTO getinfo(String userID){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		PaymentDTO dto = new PaymentDTO();
		String sql="select * from creditcard where user_id=?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				dto.setCardCategory(rs.getString("category"));
				dto.setCardHolder(rs.getString("name"));
				dto.setCardNumber(rs.getString("cardnumber"));
				dto.setMonth(rs.getString("month"));
				dto.setYear(rs.getString("year"));
				dto.setSecurity(rs.getString("security"));
			}
		}catch(SQLException e){
        	e.printStackTrace();
        	}finally{
        		try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
        	}
		return dto;
	}
}
