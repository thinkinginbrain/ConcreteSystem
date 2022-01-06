package com.wzc.login.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wzc.login.common.utils.DBUtil;
import com.wzc.login.domain.APmessage;

public class APDao {



		/**
		 * 新增节点
		 * @param apmessage 节点信息
		 * @return 新增是否成功
		 */
		public boolean insert(APmessage ap) {
			Connection con = DBUtil.getConnection();
			PreparedStatement pstmt =null;
			String sql = "INSERT INTO apmessage(name,address,model,ip,groupmessage,state) VALUES(?,?,?,?,?,?)";
			boolean res = false;
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, ap.getname());
				pstmt.setString(2, ap.getAddress());
				pstmt.setString(3, ap.getModel());
				pstmt.setString(4, ap.getIp());
				pstmt.setString(5, ap.getGroupmessage());
				pstmt.setString(6, ap.getState());
				res = (pstmt.executeUpdate()==1);
			}catch (SQLException e) {
				if(!e.getMessage().contains("PRIMARY")){
					e.printStackTrace();
				}else {
					System.out.println("该节点已存在");
					return false;
				}
			}finally {
	            DBUtil.close(con,pstmt);
			}
			return res;

		}
//
//		/**
//		 * 根据用户id删除用户信息
//		 * @param userid 用户id
//		 * @return 删除是否成功
//		 */
		public boolean delete(Integer userid) {
			Connection con = DBUtil.getConnection();
			PreparedStatement pstmt =null;
			String sql = "delete from apmessage where id= ?";
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

//		/**
//		 * 更新用户信息
//		 * @param user 修改后的用户信息
//		 * @return 更新是否成功
//		 */
		public boolean update(APmessage user) {
			Connection con = DBUtil.getConnection();
			PreparedStatement pstmt =null;
			String sql = "update apmessage set name=?,address=?,model=?,ip=?,groupmessage=?,state=? where id= ?";
			boolean res = false;
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,user.getname());
				pstmt.setString(2,user.getAddress());
				pstmt.setString(3,user.getModel());
				pstmt.setString(4,user.getIp());
				pstmt.setString(5,user.getGroupmessage());
				pstmt.setString(6,user.getState());
				pstmt.setInt(7,user.getid());
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
		 * 根据用户名查找节点
		 * @param name 
		 * @return 节点信息
		 */
		public APmessage selectByName(String username){
	        Connection con = DBUtil.getConnection();
			List<APmessage> list = new ArrayList<>();
			String sql = "select * from apmessage where name=?";
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
		 * 根据id查询信息
		 * @param  id
		 * @return 信息
		 */
		public APmessage selectByUserId(Integer userid) {
	        Connection con =DBUtil.getConnection();
			List<APmessage> list = new ArrayList<>();
			String sql = "select * from apmessage where id= ?";
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
		 * 根据传入的参数查询ap
		 * @param paramMap 参数Map
		 * @return ap列表
		 */
		public List<APmessage> selectByMap(Map<String,Object> paramMap) {
	        Connection con = DBUtil.getConnection();
		    List<APmessage> list = new ArrayList<>();
			StringBuilder sql =new StringBuilder("select * from apmessage where 1=1");
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
		private static List<APmessage> resultSetToBean(ResultSet rs) throws SQLException {
			List<APmessage> list = new ArrayList<>();
			while (rs.next()){
				APmessage user = new APmessage();
				user.setid(rs.getInt("id"));
				user.setname(rs.getString("name"));
				user.setAddress(rs.getString("address"));
				user.setModel(rs.getString("model"));
				user.setIp(rs.getString("ip"));
				user.setGroupmessage(rs.getString("groupmessage"));
				user.setState(rs.getString("state"));
				list.add(user);
			}
			return list;
		}

}
