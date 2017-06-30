package cn.web.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.domain.Privilege;
import cn.domain.User;
import cn.service.SecurityService;

/**
 * Servlet Filter implementation class PrivilegeFilter
 */
@WebFilter("/PrivilegeFilter")
public class PrivilegeFilter implements Filter {
	
	private Map<String, Privilege> map = new HashMap<String, Privilege>();
    public PrivilegeFilter() {
       map.put("/pri/manager/AddCustomer", new Privilege("添加用户"));
       map.put("/pri/manager/UpdateCustomer", new Privilege("修改用户"));
       map.put("/pri/manager/DeleteCustomer", new Privilege("删除用户"));
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String uri = req.getRequestURI();
		Privilege p = map.get(uri);
		if(p==null) {
			chain.doFilter(request, response);
			return;
		}
		User user = (User) req.getSession(false).getAttribute("user");
		if(user==null){
			request.setAttribute("message", "请先登录后再试！");
			request.getRequestDispatcher("/message.jsp").forward(req, res);
			return;
		}
		SecurityService sevice = new SecurityService();
		List<Privilege> privileges = sevice.getUserPrivilege(user.getId());
		if(!privileges.contains(p)) {
			request.setAttribute("message", "您没有权限，请联系管理员");
			request.getRequestDispatcher("/message.jsp").forward(req, res);
			return;
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
