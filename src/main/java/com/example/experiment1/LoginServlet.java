package com.example.experiment1;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        // 添加CORS响应头
        resp.setHeader("Access-Control-Allow-Origin", "*"); // 允许所有域名访问
        resp.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE"); // 允许的HTTP方法
        resp.setHeader("Access-Control-Max-Age", "3600"); // 预检请求的缓存时间
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, X-Requested-With"); // 允许的头信息

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        PrintWriter out = resp.getWriter();
        String jsonResp;

        if ("admin".equals(username) && "123".equals(password))
            jsonResp = "{\"status\":\"success\",\"message\":\"登录成功\"}";
        else
            jsonResp = "{\"status\":\"error\",\"message\":\"用户名或密码错误\"}";
        out.print(jsonResp);
        out.flush();
    }
}





