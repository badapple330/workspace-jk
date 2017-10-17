/**
 *
 */
package com.internousdev.struts2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.struts2.util.DBConnector;

public class CartDeleteDAO {

	public int delete(String userID, ArrayList<String> itemIdList){
		int ret = 0;
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "delete from cart where user_id=? and item_id =?";
		try{
			for(int i=0;i<itemIdList.size();i++){
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, userID);
				ps.setString(2, itemIdList.get(i));
				if(ret==0){
					ret = ps.executeUpdate();
				}else{
					ret = ret + ps.executeUpdate();
				}
			}
		}catch (SQLException e) {
				e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		return ret;
	}



}
