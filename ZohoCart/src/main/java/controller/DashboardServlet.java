package controller;

import java.io.IOException;
import java.security.Key;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import model.DAO.JDBCConnector;
import model.DAO.SecretKeyUtil;

/**
 * Servlet implementation class DashboardServlet
 */
@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashboardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
		JSONObject jsonResponse=new JSONObject();
		String token=getCookies(request);
		if(token != null) {
			Map<String, String> userData=getUserData(token);
			if(userData != null) {
				jsonResponse.put("status", "success");
				jsonResponse.put("message", "User name retrieved Successfully.");
				jsonResponse.put("name", userData.get("name"));
				jsonResponse.put("role", userData.get("role"));
			}
			else {
				jsonResponse.put("status", "failed");
				jsonResponse.put("message", "Failed to get user name.");
			}
		}
		else {
			jsonResponse.put("status", "failed");
			jsonResponse.put("message", "No values found in Cookie.");	
		}
		response.getWriter().write(jsonResponse.toString());
	}
	
	private String getCookies(HttpServletRequest request) {
		Cookie[] cookies=request.getCookies();
		if(cookies != null) {
			for(Cookie cookie:cookies) {
				if(cookie.getName().equals("auth_token")) {
					return cookie.getValue();
				}
			}
		}
		return null;
	}
	
	private Map<String, String> getUserData(String token) {
		try(Connection connection=JDBCConnector.getConnection()) {
			Key secretKey=SecretKeyUtil.getSecretKey();		
			Jws<Claims> claim=Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token);
			System.out.println("JWT Claims : " + claim);
			String userName=claim.getBody().get("username", String.class);
			String query="Select u.Name, u.Role_Id, r.Role_Name from Users u join Roles r  on u.Role_Id = r.Role_Id where u.User_Name = ?";				
			PreparedStatement stmt=connection.prepareStatement(query);
			stmt.setString(1, userName);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()) {
				Map<String, String> userData=new HashMap<String, String>();
				userData.put("name", rs.getString("Name"));
				userData.put("role", rs.getString("Role_Name"));
				return userData;
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
