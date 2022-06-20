package dao;

import model.Expense;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class ExpenseManagerDao {
    static final String DB_URL = "jdbc:mysql://localhost:3306/ExpenseManager";
    // Database credentials
    static final String USER = "root";
    static final String PASS = "";
    static final String dbDriver = "com.mysql.jdbc.Driver";

    static {
        // STEP 2: Register JDBC driver
        try { // For oracle: "oracle.jdbc.driver.OracleDriver"
            Class.forName("jdbc:mysql://localhost:3306/ExpenseManager");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void loadDriver(String dbDriver) {
        try {
            Class.forName(dbDriver);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Connection getDatabaseConnection() {
        loadDriver(dbDriver);
        Connection conn = null;
        try {
            System.out.println("Connecting to the  database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected!");
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        }
        return conn;
    }
    public void createExpenseTable() {
        Connection con = getDatabaseConnection();
        System.out.println("creating table....");
        String sql = "";
//		sql = "drop table exam";
//		execUpdateSQL(sql);
        sql = "CREATE TABLE IF NOT EXISTS expense (" + " expenseCategory VARCHAR(255), "
                + " date VARCHAR(255), " + " expenseName VARCHAR(255), " + " description VARCHAR(255), "
                + "amount DOUBLE "+")";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.print(e.getMessage());
            e.printStackTrace();
        }

    }

    public String insert(Expense expense) {

        Connection con = getDatabaseConnection();
        String sql = "insert into expense values(?,?,?,?,?)";
        String result = "Data entered successfully";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,expense.getExpenseCategory());
            ps.setString(2,expense.getDate());
            ps.setString(3,expense.getExpenseName());
            ps.setString(4,expense.getDescription());
            ps.setDouble(5,expense.getAmount());
            ps.executeUpdate();
        }
        catch(SQLException e){
            result = "Data entering failed";
            e.printStackTrace();

        }
        System.out.println(result);
        return result;

    }

    public ResultSet getExpense() {
        Connection con = getDatabaseConnection();
        String sql = "";
        sql = "SELECT expenseCategory,date,expenseName,description,amount FROM expense ORDER BY date DESC";
        ResultSet result=null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            result=ps.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            result=null;
            e.printStackTrace();
        }
        return result;
    }

    public ResultSet showFilter(String date) {
        Connection con = getDatabaseConnection();
        String sql = "";
        sql = "SELECT expenseCategory,date,expenseName,description,amount FROM expense WHERE date='" +date+ "'";
        ResultSet result=null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            result=ps.executeQuery();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            result=null;
            e.printStackTrace();
        }
        return result;
    }


}