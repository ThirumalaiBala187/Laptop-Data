package controller;

import model.DAO.DatabaseUtil;
import model.Reply;
import model.User;

import org.json.JSONObject;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;

public class AddReplyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String userEmail = getCookieValue(request, "user");
        if (userEmail == null) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "User not logged in");
            return;
        }

        String json = request.getReader().lines().reduce("", String::concat);
        JSONObject jsonObject = new JSONObject(json);
        Reply reply = new Reply();
        reply.setContent(jsonObject.getString("content"));
        reply.setForumId(jsonObject.getInt("forumId"));
        reply.setRepliedAt(new Timestamp(System.currentTimeMillis()));

        try {
            User user = DatabaseUtil.getUserByEmail(userEmail);
            reply.setRepliedBy(user.getUserId());
            reply.setRepliedByName(user.getName());
            DatabaseUtil.addReply(reply);
            ForumWebSocket.broadcast(reply);
            response.setStatus(HttpServletResponse.SC_OK);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error: " + e.getMessage());
        }
    }

    private String getCookieValue(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (name.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}