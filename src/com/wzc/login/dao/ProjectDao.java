package com.wzc.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.wzc.login.common.utils.DBUtil;
import com.wzc.login.domain.Project;

public class ProjectDao {

	public boolean insert(Project project) {
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt =null;
		String sql = "INSERT INTO project(user,name,model) VALUES(?,?,?)";
		boolean res = false;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,project.getUser());
			pstmt.setString(2,project.getName());
			pstmt.setString(3,project.getModel());

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
	 * 根据用户id删除用户信息
	 * @param userid 用户id
	 * @return 删除是否成功
	 */
	public boolean delete(Integer userid) {
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt =null;
		String sql = "delete from project where id= ?";
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
//
	/**
	 * 更新用户信息
	 * @param user 修改后的用户信息
	 * @return 更新是否成功
	 */
	public boolean update(Project user) {
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt =null;
		String sql = "update project set user=?,name=?,model=? where id=?";
		boolean res = false;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,user.getUser());
			pstmt.setString(2,user.getName());
			pstmt.setString(3,user.getModel());
			pstmt.setInt(4,user.getid());
			res = (pstmt.executeUpdate()==1);
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			DBUtil.close(con,pstmt);
		}
		return res;

	}
//
//	/**
//	 * 根据用户名查找用户密码
//	 * @param username 用户名
//	 * @return 用户信息
//	 */
//	public Project selectByUsername(String username){
//        Connection con = DBUtil.getConnection();
//		List<Project> list = new ArrayList<>();
//		String sql = "select * from user where username=?";
//		PreparedStatement pstmt =null;
//		ResultSet rs;
//		try {
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, username);
//			rs = pstmt.executeQuery();
//			list=resultSetToBean(rs);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//            DBUtil.close(con,pstmt);
//        }
//		return list.isEmpty()?null:list.get(0);
//	}
//
//	/**
//	 * 根据用户id查询用户信息
//	 * @param userid 用户id
//	 * @return 用户信息
//	 */
	public Project selectByUserId(Integer userid) {
        Connection con =DBUtil.getConnection();
		List<Project> list = new ArrayList<>();
		String sql = "select * from project where id= ?";
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
	 * 根据传入的参数查询用户
	 * @param paramMap 参数Map
	 * @return 用户列表
	 */
	public List<Project> selectByMap(Map<String,Object> paramMap) {
        Connection con = DBUtil.getConnection();
	    List<Project> list = new ArrayList<>();
		StringBuilder sql =new StringBuilder("select * from project where 1=1");
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
	 * 将查询结果转换位对象
	 * @param rs 查询结果
	 * @return 用户列表
	 * @throws SQLException
	 */
	private static List<Project> resultSetToBean(ResultSet rs) throws SQLException {
		List<Project> list = new ArrayList<>();
		while (rs.next()){
			Project user = new Project();
			user.setid(rs.getInt("id"));
			user.setUser(rs.getString("user"));
			user.setName(rs.getString("name"));
			user.setModel(rs.getString("model"));
			
			list.add(user);
		}
		return list;
	}
}
