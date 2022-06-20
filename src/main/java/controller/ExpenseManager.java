package controller;

import dao.ExpenseManagerDao;
import model.Expense;

import java.io.IOException;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ExpenseManager", value = "/ExpenseManager")
public class ExpenseManager extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExpenseManager() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String showFilterDate = request.getParameter("date");
//        ExpenseManagerDao dao = new ExpenseManagerDao();
////        dao.showFilter(date);
//        ResultSet test = dao.showFilter(showFilterDate);
////            System.out.println(test);
//        request.setAttribute("showFilterDate",dao.showFilter(showFilterDate));
//        request.getRequestDispatcher("showfilter.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String expenseCategory = request.getParameter("expenseCategory");
//        String date = request.getParameter("date");
//        String expenseName = request.getParameter("expenseName");
//        String description = request.getParameter("description");
//        double amount =Double.parseDouble(request.getParameter("amount"));
//        Expense expense = new Expense(expenseCategory,date,expenseName,description,amount);
//        ExpenseManagerDao dao = new ExpenseManagerDao();
//        dao.createExpenseTable();
//        String result = dao.insert(expense);
////			response.getWriter().println(result);
//        response.sendRedirect(request.getContextPath() + "/ShowExpense.jsp");
        if(request.getParameter("Add")!=null) {
            String expenseCategory = request.getParameter("expenseCategory");
            String date = request.getParameter("date");
            String expenseName = request.getParameter("expenseName");
            String description = request.getParameter("description");
            double amount =Double.parseDouble(request.getParameter("amount"));
            Expense expense = new Expense(expenseCategory,date,expenseName,description,amount);
            ExpenseManagerDao dao = new ExpenseManagerDao();
            dao.createExpenseTable();
            String result = dao.insert(expense);
//			response.getWriter().println(result);
            response.sendRedirect(request.getContextPath() + "/ShowExpense.jsp");
        }
        else if(request.getParameter("showFilter")!=null) {
////
            String showFilterDate = request.getParameter("date");
            ExpenseManagerDao dao = new ExpenseManagerDao();
//        dao.showFilter(date);
            ResultSet test = dao.showFilter(showFilterDate);
//            System.out.println(test);
            request.setAttribute("showFilterDate",dao.showFilter(showFilterDate));
            request.getRequestDispatcher("showfilter.jsp").forward(request,response);

        }
//        response.sendRedirect(request.getContextPath() + "/ShowExpense.jsp");
    }
}