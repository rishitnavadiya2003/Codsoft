package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/STUDENT_GRADE_CALCULATOR")
public class STUDENT_GRADE_CALCULATOR extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
   
    public STUDENT_GRADE_CALCULATOR() 
    {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        
        String studentName = request.getParameter("studentname");
        int rollNumber = Integer.parseInt(request.getParameter("rollnumber"));
        int javaMarks = Integer.parseInt(request.getParameter("java"));
        int pythonMarks = Integer.parseInt(request.getParameter("python"));
        int adbmsMarks = Integer.parseInt(request.getParameter("adbms"));
        int hciMarks = Integer.parseInt(request.getParameter("hci"));
        int totalMarks = javaMarks + pythonMarks + adbmsMarks + hciMarks;
        Float percentage = (float)(totalMarks) / 4;
        String grade;
       
        if (percentage >= 80 && percentage <= 100)
        {
        	grade = "Excellent Performance";
        } 
        else if (percentage >= 70 && percentage < 80)
        {
            grade = "Good Performance";
        }
        else if (percentage >= 55 && percentage < 70)
        {
            grade = "Satisfactory Performance";
        }
        else if (percentage >= 33 && percentage < 55)
        {
            grade = "Less Than Satisfactory Performance";
        }
        else
        {
            grade = "Fail";
        }
       
        request.setAttribute("studentname", studentName);
        request.setAttribute("rollnumber", rollNumber);
        request.setAttribute("javaMarks", javaMarks);
        request.setAttribute("pythonMarks", pythonMarks);
        request.setAttribute("adbmsMarks", adbmsMarks);
        request.setAttribute("hcimarks", hciMarks);
        request.setAttribute("totalmarks", totalMarks);
        request.setAttribute("percentage", percentage);
        request.setAttribute("grade", grade);
       
        RequestDispatcher rd = request.getRequestDispatcher("Marksheet.jsp");
        rd.forward(request, response);
       
		
	}

}
