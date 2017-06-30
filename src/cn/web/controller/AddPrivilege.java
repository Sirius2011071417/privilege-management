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
 * Servlet implementation class AddPrivilege
 */
@WebServlet("/AddPrivilege")
public class AddPrivilege extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPrivilege() {
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
			Privilege p = new Privilege();
			p.setName(name);
			p.setDescription(description);
			service.addPrivilege(p);
			request.setAttribute("message", "添加成功！！！");
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "添加失败！！！");
		}
		request.getRequestDispatcher("message.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
