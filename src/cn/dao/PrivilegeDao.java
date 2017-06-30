package cn.dao;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.domain.Privilege;
import cn.domain.User;
import cn.util.JdbcUtil;

public class PrivilegeDao {
	
	public Privilege find(String id) {
		try{
			QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
			return (Privilege) qr.query("select * from privilege where id=?", new BeanHandler(Privilege.class), id);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void insert(Privilege p) {
		try{
			QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
			Object[] params = new Object[]{p.getId(), p.getName(), p.getDescription()};
			qr.update("insert into privilege(id,name,description) values(?,?,?);", params);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Privilege> getAll() {
		try{
			QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
			return (List<Privilege>) qr.query("select * from privilege;", new BeanListHandler(Privilege.class));
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void update(Privilege p) {
		try{
			QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
			Object[] params = new Object[]{p.getName(), p.getDescription(), p.getId()};
			qr.update("update privilege set name=?,description=? where id=?;", params);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void delete(String id) {
		try{
			QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
			qr.update("delete from privilege where id=?", id);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
