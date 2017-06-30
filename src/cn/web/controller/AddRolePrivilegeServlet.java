package cn.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.service.SecurityService;

/**
 * Servlet implementation class AddRolePrivilegeServlet
 */
@WebServlet("/AddRolePrivilegeServlet")
public class AddRolePrivilegeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRolePrivilegeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String role_id = request.getParameter("role_id");
			String[] privilege = request.getParameterValues("privilege");
			SecurityService service = new SecurityService();
			service.addRolePrivilege(role_id, privilege);
			request.setAttribute("message", "授权成功！！！");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("message", "授权失败！！！");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
