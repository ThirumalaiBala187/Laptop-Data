package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.Key;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import model.DAO.SecretKeyUtil;
import model.DAO.UserDAO;
import model.DTO.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger logger = LogManager.getLogger(LoginServlet.class); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
        Key secretKey = SecretKeyUtil.getSecretKey();
        StringBuilder sb= new StringBuilder();
		try(BufferedReader reader=new BufferedReader(new InputStreamReader(request.getInputStream()))) {
			String line;
			while ((line=reader.readLine()) != null) {
				sb.append(line);
			}
			JSONObject jsonRequest = new JSONObject(sb.toString());
			String type=jsonRequest.getString("type");
			String userName=jsonRequest.getString("userName");
			User user=null;
			if(type.equals("manual")) {
				String password=jsonRequest.getString("password");
				user=UserDAO.getUser(userName, password);
			}
			else {
				user=UserDAO.getUser(userName);
			}
			JSONObject jsonResponse=new JSONObject();
			if(user != null) {
				String jwt=Jwts.builder()
						.setSubject(String.valueOf(user.getUserId()))
						.claim("username", user.getUserName())
						.claim("role", user.getRole())
						.setIssuedAt(new Date())
						.setExpiration(new Date(System.currentTimeMillis() + (60*60*24*3*1000)))
						.signWith(secretKey, SignatureAlgorithm.HS256)
						.compact();
				logger.info("User : " + userName + " has been Logined Successfully.");
				Cookie userCookie=new Cookie("auth_token", jwt);
				userCookie.setMaxAge(60*60*72);
				userCookie.setPath("/");
				response.addCookie(userCookie);
				jsonResponse.put("status", "success");
				jsonResponse.put("message", "User login successful.");
				jsonResponse.put("redirect", "userHome.html");
			}
			else {
				logger.error("Failed to login user with username : " + userName + ".");
				jsonResponse.put("status", "failed");
				jsonResponse.put("message", "Failed to login");
			}
			System.out.println(jsonResponse.toString());
			response.getWriter().write(jsonResponse.toString());
			response.getWriter().flush();
			response.getWriter().close();
		} catch (Exception e) {
			JSONObject jsonResponse= new JSONObject();
			jsonResponse.put("status", "failed");
			jsonResponse.put("message", "Failed to login with username");
			System.out.println(jsonResponse.toString());
			System.out.println(e.getMessage());
			response.getWriter().write(jsonResponse.toString());
			response.getWriter().flush();
			response.getWriter().close();
		}
	}

}
