package com.auth;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Verify the user credentials and fetch their role
        String role = userService.loginUser(username, password);

        if (role != null) {
            // Login success! Create a web session tracker
            HttpSession session = request.getSession();
            session.setAttribute("user", username);
            session.setAttribute("role", role);

            // Redirect them out dynamically based on their role type
            if (role.equalsIgnoreCase("STUDENT")) {
                response.sendRedirect("studentDashboard.jsp");
            } else if (role.equalsIgnoreCase("ADMIN")) {
                response.sendRedirect("adminDashboard.jsp");
            } else {
                response.sendRedirect("index.jsp");
            }
        } else {
            // Back to login page with a wrong credentials flag
            response.sendRedirect("login.jsp?error=invalid");
        }
    }
}