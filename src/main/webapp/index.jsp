<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/index.css">
    <title>Expense Manager</title>
</head>
<body>
<div align="center">
    <h1 >Expense Manager</h1>
    <form action="ExpenseManager" method="post">

        <table>
            <tr>
                <td>Expense Category</td>
                <td>
                    <select name = "expenseCategory" required>
                        <option value="" selected="selected">select</option>
                        <option value="Transportation" >Transportation</option>
                        <option value="Food">Food</option>
                        <option value="Fees">Fees</option>
                        <option value="Bills">Bills</option>
                        <option value="Entertainment">Entertainment</option>
                    </select>
                </td>
            </tr>

            <tr>
                <td>Date</td>
                <td><input type="date" name="date" required></td>
            </tr>


            <tr>
                <td>Expense Name</td>
                <td><input type="text" name="expenseName" required></td>
            </tr>


            <!--
            <tr>
                <td>Description</td>
                <td><input type="text" name="description" > </td>
            </tr>
            -->
            <tr>
                <td>Description</td>
                <td><textarea name="description" rows="5" cols="20" required></textarea> </td>
            </tr>

            <tr>
                <td>Amount</td>
                <td><input type="number" name="amount" required></td>
            </tr>

            <tr>
                <td></td>
                <td><input class="button" type="submit" name="Add" value="Add"></td>
            </tr>




        </table>
    </form>
</div>



</body>
</html>