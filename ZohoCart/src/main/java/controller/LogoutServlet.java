package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

/**
 * Servlet implementation class LogOutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		Cookie[] cookies=request.getCookies();
		JSONObject jsonResponse=new JSONObject();
		for(Cookie cookie:cookies) {
			if(cookie.getName().equals("auth_token")) {
				cookie.setValue("");
				cookie.setMaxAge(0);
				cookie.setPath("/");
				response.addCookie(cookie);
				jsonResponse.append("status", "success");
				jsonResponse.append("message", "User logged out Successfully");
				jsonResponse.append("redirect", "login.html");
				response.getWriter().write(jsonResponse.toString());
				return;
			}
		}
		jsonResponse.append("status", "failed");
		jsonResponse.append("message", "Failed to log out user");
		response.getWriter().write(jsonResponse.toString());		
	}

}
