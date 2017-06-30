package cn.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.domain.Privilege;
import cn.domain.Role;
import cn.service.SecurityService;

/**
 * Servlet implementation class AddRolePrivilegeUIServlet
 */
@WebServlet("/AddRolePrivilegeUIServlet")
public class AddRolePrivilegeUIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRolePrivilegeUIServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String role_id = request.getParameter("role_id");
		SecurityService service = new SecurityService();
		Role role = service.findRole(role_id);
		List<Privilege> role_privilege = service.getRolePrivilege(role_id);
		List<Privilege> privileges = service.getAllPrivilege();
		request.setAttribute("role", role);
		request.setAttribute("role_privilege", role_privilege);
		request.setAttribute("privileges", privileges);
		request.getRequestDispatcher("/WEB-INF/jsp/addRolePrivilege.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
