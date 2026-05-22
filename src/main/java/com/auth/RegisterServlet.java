package com.auth;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Extract parameters from the register.jsp form
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        // Send data to our service layer to insert into MySQL
        boolean success = userService.registerUser(username, password, email, role);

        if (success) {
            // Send them directly to login with a success flag
            response.sendRedirect("login.jsp?success=true");
        } else {
            // Stay on registration page with an error flag
            response.sendRedirect("register.jsp?error=failed");
        }
    }
}