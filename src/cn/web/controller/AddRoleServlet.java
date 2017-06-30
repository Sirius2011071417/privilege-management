package cn.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.domain.Privilege;
import cn.domain.Role;
import cn.service.SecurityService;

/**
 * Servlet implementation class AddRoleServlet
 */
@WebServlet("/AddRoleServlet")
public class AddRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRoleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			SecurityService service = new SecurityService();
			String name = request.getParameter("name");
			String description  = request.getParameter("description");
			Role r = new Role();
			r.setName(name);
			r.setDescription(description);
			service.addRole(r);
			request.setAttribute("message", "添加成功！！！");
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "添加失败！！！");
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
