package com.FirstServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        description = "Login servlet testing",
        urlPatterns = {"/loginServlet"},
        initParams = {
                @WebInitParam(name = "user", value = "Prasad"),
                @WebInitParam(name = "password", value = "Prasad97&P")
        }
)
public class LoginServlet extends HttpServlet {
    UserValidator userValidator = new UserValidator();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("pwd");
        if (userValidator.validateUserName(username) && userValidator.validatePassword(password)) {
            request.setAttribute("user", username);
            request.setAttribute("password", password);
            request.getRequestDispatcher("LoginSuccess.jsp").forward(request, response);
        } else {
            PrintWriter out = response.getWriter();
            out.println("<font color=red>Either username or password doesn't matches the rules ........</font>");
            getServletContext().getRequestDispatcher("/login.html").include(request, response);
        }
    }
}
