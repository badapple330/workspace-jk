/**
 *
 */
package com.internousdev.struts2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.struts2.util.DBConnector;

public class UserCreateDAO {

	public int insert(String userID, String password){
		int ret=0;
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
//		ArrayList<LoginDTO> loginList = new ArrayList<LoginDTO>();
		String sql = "insert into user(user_id, password)"
				+ "values(?,?)";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userID);
			ps.setString(2,password);
			ret = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ret;
	}

}
