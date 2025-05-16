package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.Attendance;
import model.User;

@WebServlet("/attendance")
public class AttendanceServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
            return;
        }

        String action = request.getParameter("action");

        Attendance attendance = (Attendance) session.getAttribute("attendance");
        if (attendance == null) {
            attendance = new Attendance(user.getName());
            session.setAttribute("attendance", attendance);
        }

        if ("in".equals(action)) {
            attendance.punchIn();
        } else if ("out".equals(action)) {
            attendance.punchOut();
        }

        session.setAttribute("record", attendance.getSummary());
        response.sendRedirect(request.getContextPath() + "/jsp/attendance.jsp");
    }
}
