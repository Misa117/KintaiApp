package controller;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String employeeId = request.getParameter("username");
        String password = request.getParameter("password");

        ServletContext context = getServletContext();
        Map<String, User> userMap = (Map<String, User>) context.getAttribute("userMap");

        if (userMap == null) {
            userMap = new java.util.HashMap<>();
            context.setAttribute("userMap", userMap);
        }

        User user = userMap.get(employeeId);

        if (user != null && user.checkPassword(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect(request.getContextPath() + "/jsp/attendance.jsp");
        } else {
            request.setAttribute("error", "ログインに失敗しました。");
            request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
        }
    }
}

