package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.Key;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import io.jsonwebtoken.Jwts;
import model.DAO.JDBCConnector;
import model.DAO.SecretKeyUtil;
import model.DAO.UserDAO;
import model.DTO.User;
import model.DTO.User.Gender;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
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
		
		StringBuilder sb = new StringBuilder();
		Key secretKey=SecretKeyUtil.getSecretKey();
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream())); Connection connection=JDBCConnector.getConnection()) {
			String line;
			while ((line=reader.readLine()) != null) {
				sb.append(line);
			}
			
			JSONObject jsonRequest = new JSONObject(sb.toString());
			String name=jsonRequest.getString("name");
			String username=jsonRequest.getString("username");
			String password=jsonRequest.getString("password");
			String mobile=jsonRequest.getString("mobile");
			Date date= null;
			String authtype=jsonRequest.getString("auth_type");
			if(jsonRequest.has("dob") && !jsonRequest.getString("dob").isEmpty()) {
				try {
					date=Date.valueOf(jsonRequest.getString("dob"));
				}
				catch(IllegalArgumentException e) {
					date=null;
				}
			}
			Gender gender=Gender.valueOf(jsonRequest.getString("gender"));
			
			String query="Select * from Users where User_Name = ?";
			JSONObject jsonResponse = new JSONObject();
			PreparedStatement stmt=connection.prepareStatement(query);
			stmt.setString(1, username);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()) {
				jsonResponse.put("status", "failed");
				jsonResponse.put("message", "User already exists.");
			}
			else {
				User user=UserDAO.addUser(name, username, password, mobile, date, gender, authtype);
				if(user != null) {
					String jwt=Jwts.builder()
							.setSubject(String.valueOf(user.getUserId()))
							.claim("userName", user.getUserName())
							.claim("role", user.getRole())
							.setIssuedAt(new java.util.Date())
							.setExpiration(new Date(System.currentTimeMillis() + (1000*60*60*24*3)))
							.signWith(secretKey,io.jsonwebtoken.SignatureAlgorithm.HS256)
							.compact();
							
					Cookie userCookie= new Cookie("auth_token", jwt);
					userCookie.setMaxAge(60*60*72);
					userCookie.setPath("/");
					userCookie.setHttpOnly(true);
					response.addCookie(userCookie);
					jsonResponse.put("status", "success");
					jsonResponse.put("message", "User login successful.");
					jsonResponse.put("redirect", "userHome.html");
				}
				else {
					jsonResponse.put("status", "failed");
					jsonResponse.put("message", "Failed to add new User");
				}
			}
			response.getWriter().write(jsonResponse.toString());
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JSONObject errorResponse = new JSONObject();
		    errorResponse.put("status", "error");
		    errorResponse.put("message", "Internal server error: " + e.getMessage());
		    response.getWriter().write(errorResponse.toString());
		}
	}

}
