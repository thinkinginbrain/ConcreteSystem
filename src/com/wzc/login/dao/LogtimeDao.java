package com.wzc.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.wzc.login.common.utils.DBUtil;
import com.wzc.login.domain.Logintime;
import com.wzc.login.domain.User;

public class LogtimeDao {

	public boolean insert(Logintime user) {
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt =null;
		String sql = "INSERT INTO Logtime(username,login_time,logout_time) VALUES(?,?,?)";
		boolean res = false;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,user.getUsername());
			pstmt.setString(2,user.getLoginTime());
			pstmt.setString(3,user.getLogoutTime());
			res = (pstmt.executeUpdate()==1);
		}catch (SQLException e) {
			if(!e.getMessage().contains("PRIMARY")){
				e.printStackTrace();
			}else {
				System.out.println("该用户名已存在");
				return false;
			}
		}finally {
            DBUtil.close(con,pstmt);
		}
		return res;

	}

	/**
	 * 
	 * 
	 * 
	 */
	public boolean delete(Integer userid) {
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt =null;
		String sql = "delete from logtime where id= ?";
		boolean res = false;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,userid);
			res = (pstmt.executeUpdate()==1);
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
            DBUtil.close(con,pstmt);
        }
		return res;
	}

	/**
	 * 
	 * 
	 *
	 */
	
	/**
	 * 
	 * 
	 * 
	 */
	public Logintime selectByUsername(String username){
        Connection con = DBUtil.getConnection();
		List<Logintime> list = new ArrayList<>();
		String sql = "select * from logtime where username=?";
		PreparedStatement pstmt =null;
		ResultSet rs;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			list=resultSetToBean(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
            DBUtil.close(con,pstmt);
        }
		return list.isEmpty()?null:list.get(0);
	}

	/**
	 * 
	 * 
	 * 
	 */
	public Logintime selectByUserId(Integer userid) {
        Connection con =DBUtil.getConnection();
		List<Logintime> list = new ArrayList<>();
		String sql = "select * from logtime where id= ?";
		PreparedStatement pstmt =null;
		ResultSet rs;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,userid);
			rs = pstmt.executeQuery();
			list=resultSetToBean(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
            DBUtil.close(con,pstmt);
        }
		return list.isEmpty()?null:list.get(0);
	}

	/**
	 * 
	 * 
	 * 
	 */
	public List<Logintime> selectByMap(Map<String,Object> paramMap) {
        Connection con = DBUtil.getConnection();
	    List<Logintime> list = new ArrayList<>();
		StringBuilder sql =new StringBuilder("select * from logtime where 1=1");
		List<Object> paramList = new ArrayList<>();
		for(String key:paramMap.keySet()){
			sql.append(" and ").append(key).append(" = ?");
			paramList.add(paramMap.get(key));
		}
		PreparedStatement pstmt =null;
		try {
			pstmt = con.prepareStatement(sql.toString());
			for(int i=0;i<paramList.size();i++){
				pstmt.setObject(i,paramList.get(i));
			}
			list=resultSetToBean(pstmt.executeQuery());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
            DBUtil.close(con,pstmt);
        }
		return list;
	}

	/**
	 * 
	 * 
	 * 
	 *
	 */
	private static List<Logintime> resultSetToBean(ResultSet rs) throws SQLException {
		List<Logintime> list = new ArrayList<>();
		while (rs.next()){
			Logintime user = new Logintime();
			user.setUserid(rs.getInt("id"));
			user.setUsername(rs.getString("username"));
			user.setLoginTime(rs.getString("login_time"));
			user.setLogoutTime(rs.getString("logout_time"));
			list.add(user);
		}
		return list;
	}
	
	
	public boolean updateMaxId(String logout_time) {
        Connection con =DBUtil.getConnection();
	//	List<Logintime> list = new ArrayList<>();
		String sql = "update logtime set logout_time=? where id= (select max(id) from logtime)";
		PreparedStatement pstmt =null;
		boolean res = false;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,logout_time);
		//	rs = pstmt.executeQuery();
		//	list=resultSetToBean(rs);
			res = (pstmt.executeUpdate()==1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
            DBUtil.close(con,pstmt);
        }
		return true;
	}

}
