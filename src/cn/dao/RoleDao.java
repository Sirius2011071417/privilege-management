package cn.dao;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.domain.Privilege;
import cn.domain.Role;
import cn.domain.User;
import cn.util.JdbcUtil;

public class RoleDao {
	
	public Role find(String id) {
		try{
			QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
			return (Role) qr.query("select * from role where id=?", new BeanHandler(Role.class), id);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void insert(Role r) {
		try{
			QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
			Object[] params = new Object[]{r.getId(), r.getName(), r.getDescription()};
			qr.update("insert into role(id,name,description) values(?,?,?);", params);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Role> getAll() {
		try{
			QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
			return (List<Role>) qr.query("select * from role;", new BeanListHandler(Role.class));
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void updatePrivilege(String role_id, String[] privilege) {
		try{
			QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
			Object[][] params = new Object[privilege.length][];
			for(int i=0;i<privilege.length;i++) {
				params[i] = new Object[]{role_id, privilege[i]};
			}
			qr.batch("insert into role_privilege(role_id, privilege_id) values(?,?)", params);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Privilege> getPrivileges(String role_id) {
		try{
			QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
			return (List<Privilege>) qr.query("select r.* from role_privilege u, privilege r where u.role_id=? and r.id=u.privilege_id", new BeanListHandler(Privilege.class), role_id);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void update(Role r) {
		try{
			QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
			Object[] params = new Object[]{r.getName(), r.getDescription(), r.getId()};
			qr.update("update role set name=?,description=? where id=?;", params);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}		
	}

	public void delete(String id) {
		try{
			QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
			qr.update("delete from role where id=?", id);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void deletePrivilege(String id) {
		try{
			QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
			qr.update("delete from role_privilege where role_id=?", id);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void deleteUser(String id) {
		try{
			QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
			qr.update("delete from user_role where role_id=?", id);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}	
