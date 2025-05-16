package controller;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.User;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String name = request.getParameter("name");
        String employeeId = request.getParameter("employeeId");
        String password = request.getParameter("password");

        ServletContext context = getServletContext();
        Map<String, User> userMap = (Map<String, User>) context.getAttribute("userMap");

        if (userMap == null) {
            userMap = new java.util.HashMap<>();
            context.setAttribute("userMap", userMap);
        }

        if (userMap.containsKey(employeeId)) {
            request.setAttribute("error", "この社員番号は既に登録されています。");
            request.getRequestDispatcher("/jsp/register.jsp").forward(request, response);
        } else {
            User newUser = new User(employeeId, password, name);
            userMap.put(employeeId, newUser);
            response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
        }
    }
}
