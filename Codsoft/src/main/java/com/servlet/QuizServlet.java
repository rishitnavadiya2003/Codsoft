package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/quiz")
public class QuizServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Quiz quiz = (Quiz) session.getAttribute("quiz");
        if (quiz == null) {
            quiz = new Quiz();
            session.setAttribute("quiz", quiz);
        }

        if (quiz.hasMoreQuestions()) {
            Question question = quiz.getCurrentQuestion();
            request.setAttribute("question", question);
            request.getRequestDispatcher("quiz.jsp").forward(request, response);
        } else {
            response.sendRedirect("result");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Quiz quiz = (Quiz) session.getAttribute("quiz");
        if (quiz != null) {
            String answerIndexStr = request.getParameter("answer");
            if (answerIndexStr != null) {
                int answerIndex = Integer.parseInt(answerIndexStr);
                quiz.submitAnswer(answerIndex);
            }
        }
        response.sendRedirect("quiz");
    }
}
