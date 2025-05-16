package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import dao.UserDAO;
import model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 入力情報の取得
        String employeeNumber = request.getParameter("employeeNumber");
        String password = request.getParameter("password");

        // ログイン認証処理
        UserDAO userDAO = new UserDAO();
        boolean isValid = userDAO.validateLogin(employeeNumber, password);

        if (isValid) {
            // 認証成功時：Userオブジェクトを取得し、セッションに保存
            User user = userDAO.getUserByEmployeeNumber(employeeNumber);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);  // ← 修正ポイント

            response.sendRedirect("attendance.jsp");
        } else {
            // 認証失敗時：エラーメッセージを設定してログイン画面に戻す
            request.setAttribute("error", "社員番号またはパスワードが間違っています");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
