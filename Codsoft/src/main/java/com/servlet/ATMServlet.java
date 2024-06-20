package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ATMServlet")
public class ATMServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
    	HttpSession session = request.getSession();
        BankAccount account = (BankAccount) session.getAttribute("account");
        if (account == null) {
            account = new BankAccount(1000); // Initial balance of INR 1000
            session.setAttribute("account", account);
        }

        String option = request.getParameter("option");
        String message = "";
        switch (option) {
            case "checkBalance":
                request.getRequestDispatcher("balance.jsp").forward(request, response);
                return;
            case "deposit":
                double depositAmount = Double.parseDouble(request.getParameter("amount"));
                if (account.deposit(depositAmount)) {
                    message = "Deposited INR " + depositAmount + " successfully.";
                } else {
                    message = "Invalid amount. Deposit failed.";
                }
                break;
            case "withdraw":
                double withdrawAmount = Double.parseDouble(request.getParameter("amount"));
                if (account.withdraw(withdrawAmount)) {
                    message = "Withdrew INR " + withdrawAmount + " successfully.";
                } else {
                    message = "Invalid amount or insufficient funds. Withdrawal failed.";
                }
                break;
            default:
                message = "Invalid choice. Please try again.";
        }

        request.setAttribute("message", message);
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}
