package cn.web.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class CharsetFilter
 */
@WebFilter("/CharsetFilter")
public class CharsetFilter implements Filter {

    /**
     * Default constructor. 
     */
    public CharsetFilter() {
        // TODO Auto-generated constructor stub
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
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setContentType("text/html;charset=utf-8");
		chain.doFilter(new MyRequest(request), response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}
}

class MyRequest extends HttpServletRequestWrapper {
	
	private HttpServletRequest req;
	public MyRequest(HttpServletRequest request) {
		super(request);
		this.req = request;
	}
	@Override
	public String getParameter(String name) {
		String value = this.req.getParameter(name);
		if(value==null) {
			return null;
		}
		if(this.req.getMethod().equalsIgnoreCase("get")){
			try {
				value = new String(value.getBytes(), "utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		return value;
	}
}

