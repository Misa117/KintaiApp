package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import dao.AttendanceDAO;
import model.User;

public class AttendanceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");  // "in" または "out"
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user != null) {
            int userId = user.getId();  // Userクラスにidのgetterが必要です
            LocalDate today = LocalDate.now();
            LocalTime now = LocalTime.now();

            if ("in".equals(action)) {
            	AttendanceDAO.markStartTime(userId);
                session.setAttribute("record", "出勤を打刻しました: " + now.toString());
            } else if ("out".equals(action)) {
            	AttendanceDAO.markEndTime(userId);
                session.setAttribute("record", "退勤を打刻しました: " + now.toString());
            }
        } else {
            session.setAttribute("record", "ログインしてください");
        }

        response.sendRedirect("attendance.jsp");
    }
}
