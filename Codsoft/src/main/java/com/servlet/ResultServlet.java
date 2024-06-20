package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/result")
public class ResultServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
    
    public ResultServlet() 
    {
        super();
       
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Quiz quiz = (Quiz) session.getAttribute("quiz");
        if (quiz != null) {
            request.setAttribute("score", quiz.getScore());
            request.setAttribute("questions", quiz.getQuestions());
        }
        request.getRequestDispatcher("quizresult.jsp").forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

}
