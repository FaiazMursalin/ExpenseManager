<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="dao.ExpenseManagerDao"%>
<%
    dao.ExpenseManagerDao dao = new dao.ExpenseManagerDao();
    ResultSet resultSet = dao.getExpense();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/expense.css">
    <title>Show Expense</title>
</head>
<body>
<div align="center">
    <h1>Show Expense</h1>

    <table>

        <tr>
            <th><b>Expense Category</b></th>
            <th><b>Date</b></th>
            <th><b>Expense Name</b></th>
            <th><b>Description</b></th>
            <th><b>Amount</b></th>
        </tr>
        <%

            while (resultSet.next()) {
        %>
        <tr>
            <td><%=resultSet.getString("expenseCategory")%></td>
            <td><%=resultSet.getString("date")%></td>
            <td><%=resultSet.getString("expenseName")%></td>
            <td><%=resultSet.getString("description")%></td>
            <td><%=resultSet.getString("amount")%></td>
        </tr>
        <%
            }
        %>
    </table>
</div>
<a href="showfilter.jsp">Filter data</a>


</body>

</html>