package cn.service;

import java.util.ArrayList;
import java.util.List;

import cn.dao.PrivilegeDao;
import cn.dao.RoleDao;
import cn.dao.UserDao;
import cn.domain.Privilege;
import cn.domain.Role;
import cn.domain.User;
import cn.util.DaoFactory;
import cn.util.WebUtil;

public class SecurityService {
	
	UserDao uDao = DaoFactory.newInstance().createDao("cn.dao.UserDao", UserDao.class);
	RoleDao rDao = DaoFactory.newInstance().createDao("cn.dao.RoleDao", RoleDao.class);
	PrivilegeDao pDao = DaoFactory.newInstance().createDao("cn.dao.PrivilegeDao", PrivilegeDao.class);
	//UserDao uDao = new UserDao();
	//RoleDao rDao = new RoleDao();
	//PrivilegeDao pDao = new PrivilegeDao();
	
	/*用户*/
	public void addUser(User u) {
		u.setId(WebUtil.uuid());
		uDao.insert(u);
	}
	public User findUser(String user_id) {
		return uDao.find(user_id);
	}
	public User findUser(String username, String password) {
		return uDao.find(username, password);
	}
	public List<User> getAllUser() {
		return uDao.getAll();
	}
	public List<Role> getUserRole(String user_id) {
		return uDao.getRoles(user_id);
	}
	public void addUserRole(String user_id, String[] role) {
		uDao.updateRole(user_id, role);
	}
	public void updateUser(User u) {
		uDao.update(u);
	}
	public void deleteUser(String id) {
		uDao.deleteRole(id);
		uDao.delete(id);
	}
	/*角色*/
	public void addRole(Role r) {
		r.setId(WebUtil.uuid());
		rDao.insert(r);
	}
	public Role findRole(String role_id) {
		return rDao.find(role_id);
	}
	public List<Role> getAllRole() {
		return rDao.getAll();
	}
	public void addRolePrivilege(String role_id, String[] privilege) {
		rDao.updatePrivilege(role_id, privilege);
	}
	public List<Privilege> getRolePrivilege(String role_id) {
		return rDao.getPrivileges(role_id);
	}
	public void updateRole(Role r) {
		rDao.update(r);
	}
	public void deleteRole(String id) {
		rDao.deleteUser(id);
		rDao.deletePrivilege(id);
		rDao.delete(id);
	}
	/*权限*/
	public void addPrivilege(Privilege p) {
		p.setId(WebUtil.uuid());
		pDao.insert(p);
	}
	public Privilege findPrivilege(String privilege_id) {
		return pDao.find(privilege_id);
	}
	public List<Privilege> getAllPrivilege() {
		return pDao.getAll();
	}
	public void updatePrivilege(Privilege p) {
		pDao.update(p);
	}
	public void deletePrivilege(String id) {
		pDao.delete(id);
	}
	/*得到用户所有的权限*/
	public List<Privilege> getUserPrivilege(String user_id) {
		List<Role> roles = uDao.getRoles(user_id);
		List<Privilege> privileges = new ArrayList<Privilege>();	
		for(Role r: roles) {
			List<Privilege> p = rDao.getPrivileges(r.getId());
			privileges.addAll(p);
		}
		return privileges;
	}
}
