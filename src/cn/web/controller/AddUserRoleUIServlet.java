package cn.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.domain.Role;
import cn.domain.User;
import cn.service.SecurityService;

/**
 * Servlet implementation class addUserRoleUIServlet
 */
@WebServlet("/AddUserRoleUIServlet")
public class AddUserRoleUIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserRoleUIServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_id = request.getParameter("user_id");
		SecurityService service = new SecurityService();
		User user = service.findUser(user_id);
		List<Role> user_role = service.getUserRole(user_id);
		List<Role> roles = service.getAllRole();
		request.setAttribute("user", user);
		request.setAttribute("user_role", user_role);
		request.setAttribute("roles", roles);
		request.getRequestDispatcher("/WEB-INF/jsp/addUserRole.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
