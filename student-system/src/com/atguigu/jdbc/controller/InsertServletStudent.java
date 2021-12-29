package com.atguigu.jdbc.controller;



import com.atguigu.jdbc.util.jdbcUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/insert/student")
public class InsertServletStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection jdbcConnection = jdbcUtil.getJdbcConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        PrintWriter writer = resp.getWriter();
        String sql="insert into student values(default,?,?,?)";
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        int phone = Integer.parseInt(req.getParameter("phone"));
        try {
            preparedStatement = jdbcConnection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,age);
            preparedStatement.setInt(3,phone);
            boolean execute = preparedStatement.execute();
            if (execute){
                writer.println("This is Insert Student NotSuccessfully");
            }else {
                writer.println("This is Insert Student Successfully");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbcUtil.release(jdbcConnection,preparedStatement,resultSet);
        }

    }

}
