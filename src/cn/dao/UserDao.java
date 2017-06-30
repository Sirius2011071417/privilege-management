package cn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;


import cn.domain.Privilege;
import cn.domain.Role;
import cn.domain.User;
import cn.util.DButil;
import cn.util.JdbcUtil;

public class UserDao {
	
	public User find(String user_id) {
		try{
			QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
			return (User) qr.query("select * from user where id=?", new BeanHandler(User.class), user_id);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public User find(String username, String password) {
		try{
			QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
			return (User) qr.query("select * from user where username=? and password=?", new BeanHandler(User.class), new Object[]{username, password});
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void insert(User user) {
		try{
			QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
			Object[] params = new Object[]{user.getId(), user.getUsername(), user.getPassword()};
			qr.update("insert into user(id, username, password) values(?,?,?)", params);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<User> getAll() {
		Connection conn = null;
		PreparedStatement p = null;
		ResultSet r = null;
		try{
			conn = DButil.getConnect();
			p = conn.prepareStatement("select * from user;");
			r = p.executeQuery();
			List<User> users = new ArrayList<User>();
			while(r.next()) {
				String ua = r.getString("username");
				String pw = r.getString("password");
				String id = r.getString("id");
				User u = new User();
				u.setUsername(ua);
				u.setPassword(pw);
				u.setId(id);
				users.add(u);
			}
			return users;
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public void updateRole(String user_id, String[] role) {
		try{
			QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
			Object[][] params = new Object[role.length][];
			for(int i=0;i<role.length;i++) {
				params[i] = new Object[]{user_id, role[i]};
			}
			qr.batch("insert into user_role(user_id, role_id) values(?,?)", params);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Role> getRoles(String user_id) {
		try{
			QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
			return (List<Role>) qr.query("select r.* from user_role u, role r where u.user_id=? and r.id=u.role_id", new BeanListHandler(Role.class), user_id);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void update(User u) {
		try{
			QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
			Object[] params = new Object[]{u.getUsername(), u.getPassword(), u.getId()};
			qr.update("update user set username=?,password=? where id=?;", params);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void delete(String id) {
		try{
			QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
			qr.update("delete from user where id=?", id);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public void deleteRole(String id) {
		try{
			QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
			qr.update("delete from user_role where user_id=?", id);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
