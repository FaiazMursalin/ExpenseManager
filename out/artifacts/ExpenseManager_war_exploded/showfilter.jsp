<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="dao.ExpenseManagerDao"%>
<%
    dao.ExpenseManagerDao dao = new dao.ExpenseManagerDao();

    ResultSet resultSet = (ResultSet)request.getAttribute("showFilterDate");
    if(resultSet==null){
        resultSet = dao.getExpense();
    }
//    System.out.println(resultSet);

%>
<html>
<head>
    <title>Show Filter</title>
</head>
<body>
<div align="center">
    <h1>Show Expense</h1>

    <form action="ExpenseManager" method="post">
    <table>
        <tr>
            <td>Filter Date</td>
            <td><input type="date" name="date" value="<%= request.getParameter("date")%>" required></td>
            <td><input class="button" type="submit" name="showFilter" value="showFilter"></td>
        </tr>




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
    </form>
</div>

</body>
</html>
