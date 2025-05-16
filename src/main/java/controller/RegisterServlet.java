package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model.User;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String employeeNumber = request.getParameter("employeeNumber");  // 修正
        String password = request.getParameter("password");

        User user = new User();
        user.setName(name);
        user.setEmployeeNumber(employeeNumber);  // 修正
        user.setPassword(password);

        boolean success = UserDAO.registerUser(user);  // もしregisterUserに統一済みなら

        if(success) {
            response.sendRedirect("login.jsp");
        } else {
            request.setAttribute("errorMsg", "登録に失敗しました。");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}
