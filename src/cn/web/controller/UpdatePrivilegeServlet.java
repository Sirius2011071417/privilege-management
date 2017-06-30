package cn.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.domain.Privilege;
import cn.service.SecurityService;

/**
 * Servlet implementation class UpdatePrivilegeServlet
 */
@WebServlet("/UpdatePrivilegeServlet")
public class UpdatePrivilegeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePrivilegeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			Privilege p = new Privilege();
			p.setId(id);
			p.setName(name);
			p.setDescription(description);
			SecurityService service = new SecurityService();
			service.updatePrivilege(p);
			request.setAttribute("message", "修改成功！！！");
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "修改失败！！！");
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
