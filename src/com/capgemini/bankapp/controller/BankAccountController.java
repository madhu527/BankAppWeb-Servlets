package com.capgemini.bankapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.bankapp.exception.LowBalanceException;
import com.capgemini.bankapp.model.BankAccount;
import com.capgemini.bankapp.service.BankAccountNotFoundException;
import com.capgemini.bankapp.service.BankAccountService;
import com.capgemini.bankapp.service.impl.BankAccountServiceImpl;

@WebServlet(urlPatterns = { "*.do" }, loadOnStartup = 1)
public class BankAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BankAccountService service;

	public BankAccountController() {
		service = new BankAccountServiceImpl();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String path = request.getServletPath();
		if (path.contentEquals("/DisplayAllAccountDetails.do")) {
			java.util.List<BankAccount> bankAccounts = service.findAllBankAccounts();
			RequestDispatcher dispather = request.getRequestDispatcher("displayAllBankAccounts.jsp");
			request.setAttribute("Accounts", bankAccounts);
			dispather.forward(request, response);

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String path = request.getServletPath();

		System.out.println(path);
		PrintWriter out = response.getWriter();

		if (path.equals("/addNewBankAccount.do")) {
			String accountHolderName = request.getParameter("customer_name");
			String accounType = request.getParameter("account_type");
			double balance = Double.parseDouble(request.getParameter("accountbalance"));

			BankAccount account = new BankAccount(accountHolderName, accounType, balance);

			if (service.addNewBankAccount(account)) {
				out.println("<h2> bankaccount created successfully");
				out.close();

			}
		}

		// BankAccountService bankService;
		if (path.equals("/withdrawals.do")) {
			long accountNumber = Long.parseLong(request.getParameter("number"));
			Double amount = Double.parseDouble(request.getParameter("amount"));
			try {
				double result = service.withdraw(accountNumber, amount);
				out.println("<h2>withdraw is successfull</h2>");
				out.print("balance remaining is " + result);
			} catch (LowBalanceException e) {
				e.printStackTrace();

			} catch (BankAccountNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (path.equals("/searchAccount.do")) {
			long accountNumber = Long.parseLong(request.getParameter("number"));

			BankAccount bankAccount;
			try {
				bankAccount = service.searchBankAccount(accountNumber);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("SearchBankAccount.jsp");
				request.setAttribute("search", bankAccount);
				dispatcher.forward(request, response);

			} catch (BankAccountNotFoundException e) {

				e.printStackTrace();
			}
		}

		if (path.equals("/deposits.do"))

		{
			long accountNumber = Long.parseLong(request.getParameter("number"));
			Double amount = Double.parseDouble(request.getParameter("amount"));
			try {
				double result = service.deposit(accountNumber, amount);
				out.println("<h2>deposit is successfull</h2>");
				out.println("balance remaining is " + result);
			} catch (BankAccountNotFoundException e) {

				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		if (path.equals("/funds.do")) {
			long accountNumber = Long.parseLong(request.getParameter("number1"));
			long accountNumber2 = Long.parseLong(request.getParameter("number2"));
			Double amount = Double.parseDouble(request.getParameter("amount"));
			try {
				double result = service.fundTransfer(accountNumber, accountNumber2, amount);
				out.println("<h2>transaction is successfull</h2>");
				out.println("balance remaining is " + result);
			} catch (LowBalanceException e) {
				e.printStackTrace();
			} catch (BankAccountNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (path.equals("/checkbalance.do")) {
			long accountNumber = Long.parseLong(request.getParameter("number"));
			double result = 0;
			try {
				result = service.checkBalance(accountNumber);
			} catch (BankAccountNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			out.println("balance remaining is " + result);
		}

		if (path.equals("/updateBankDetails.do")) {

		}
		if (path.equals("/deleteaccount.do")) {
			long accountNumber = Long.parseLong(request.getParameter("number"));
			try {
				boolean result = service.deleteBankAccount(accountNumber);

				out.println("your account is deleted successfully" + result);
			} catch (BankAccountNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
