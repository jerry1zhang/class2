package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import entity.computer;
import util.DBhelper_mysql;

public class daoimpl implements dao {
	DBhelper_mysql db = new DBhelper_mysql();
	@Override
	public List<computer> allComputer() {
		String sql = "select c_id,type,pic,c_desc,price,num from cart_computer";
		List<computer> list = new ArrayList<computer>();
		computer computer = new computer();
		try {
			Connection conn = db.getConnection();
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				computer = new computer();
				computer.setC_id(rs.getInt("c_id"));
				computer.setType(rs.getString("type"));
				computer.setPic(rs.getString("pic"));
				computer.setc_desc(rs.getString("c_desc"));
				computer.setPrice(rs.getString("price"));
				computer.setNum(rs.getInt("num"));
				list.add(computer);
			}
			db.closeConnection(rs, s, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public computer findById(int id) {
		String sql = "select c_id,type,pic,c_desc,price,num from cart_computer where c_id=?";
		computer computer = new computer();
		try {
			Connection conn = db.getConnection();
			PreparedStatement s = conn.prepareStatement(sql);
			s.setInt(1, id);
			ResultSet rs = s.executeQuery();
			if (rs.next()) {
				computer.setC_id(rs.getInt("c_id"));
				computer.setType(rs.getString("type"));
				computer.setPic(rs.getString("pic"));
				computer.setc_desc(rs.getString("c_desc"));
				computer.setPrice(rs.getString("price"));
				computer.setNum(rs.getInt("num"));
			}
			db.closeConnection(rs, s, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return computer;
	}

}
