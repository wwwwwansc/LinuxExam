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
import java.util.HashMap;

@WebServlet("/delete/student")
public class DeleteServletStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sql="delete from student where studentId=?";
        Connection jdbcConnection = jdbcUtil.getJdbcConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        Integer id = Integer.parseInt(req.getParameter("id"));
        PrintWriter writer = resp.getWriter();
        try {
            preparedStatement = jdbcConnection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            boolean execute = preparedStatement.execute();
            if (execute){
                writer.println("This is Delete Student NotSuccessfully");
            }else {
                writer.println("This is Delete Student Successfully");
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }finally {
            jdbcUtil.release(jdbcConnection,preparedStatement,resultSet);
        }
    }



}