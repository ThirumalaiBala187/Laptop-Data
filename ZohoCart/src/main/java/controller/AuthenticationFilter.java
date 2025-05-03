package controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
@WebFilter("/*")
public class AuthenticationFilter extends HttpFilter implements Filter {
       
    private static final long serialVersionUID = 1L;

	/**
     * @see HttpFilter#HttpFilter()
     */
    public AuthenticationFilter() {
        super();
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		// pass the request along the filter chain
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		String uri=req.getRequestURI();
		
		String[] allowedPaths = {".css", ".js", ".png", ".jpg", ".jpeg", "/index.html", "/login.html", "/signup.html", "/ZohoCart/", "/LoginServlet", "/SignupServlet"};
		
		for(String path:allowedPaths) {
			if(uri.endsWith(path)) {
				chain.doFilter(request, response);
				return;
			}
		}
		
		Cookie[] cookies=req.getCookies();
		boolean isUserLogged=false;
		if(cookies != null) {
			for( Cookie cookie :cookies) {
				if(cookie.getName().equals("auth_token")) {
					isUserLogged=true;
					break;
				}
			}
		}
		
		if(isUserLogged) {
			chain.doFilter(request, response);
		}
		else {
			res.sendRedirect("login.html");
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
