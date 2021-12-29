package com.atguigu.jdbc.controller;

import com.atguigu.jdbc.entity.Student;
import com.atguigu.jdbc.util.jdbcUtil;
import com.atguigu.jdbc.util.redisUtil;
import redis.clients.jedis.Jedis;

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

@WebServlet("/select/student")
public class SelectServletStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        Connection jdbcConnection = jdbcUtil.getJdbcConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Jedis jedis = redisUtil.getConnection();
        String sql = "select * from student ";
        PrintWriter writer = resp.getWriter();
        System.out.println(jedis);
            try {
                String id = req.getParameter("id");
                if (id != null){
                    int id1 = Integer.parseInt(id);
                    sql+=" where studentId=?";
                    preparedStatement = jdbcConnection.prepareStatement(sql);
                    preparedStatement.setInt(1, id1);
                }else{
                    preparedStatement = jdbcConnection.prepareStatement(sql);
                }

                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int studentId = resultSet.getInt("studentId");
                    String studentName = resultSet.getString("studentName");
                    String studentAge = resultSet.getString("studentAge");
                    int studentPhone = resultSet.getInt("studentPhone");
                    Student student =new Student(studentId,studentName,studentAge,studentPhone);
                    writer.println(student);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                jdbcUtil.release(jdbcConnection, preparedStatement, resultSet);
            }
        }
}