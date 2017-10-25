package com.internousdev.struts2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.struts2.util.DBConnector;

public class CartUpdateDAO {

	public int update(String userID, String[] itemIdAry, int[] quantity){
		//多分cartをselectで全体を検索→
		int ret=0;
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "update cart set quantity=? where user_id=? and item_id=?";
		try{
			for(int i=0;i<itemIdAry.length;i++){
				 PreparedStatement ps = con.prepareStatement(sql);
				 ps.setInt(1, quantity[i]);
				 ps.setString(2, userID);
				 ps.setString(3, itemIdAry[i]);
				 ret = ret + ps.executeUpdate();
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
		return ret;
	}

}
