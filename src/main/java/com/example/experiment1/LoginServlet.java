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

<<<<<<< HEAD
        // 添加CORS响应头
        resp.setHeader("Access-Control-Allow-Origin", "*"); // 允许所有域名访问
        resp.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE"); // 允许的HTTP方法
        resp.setHeader("Access-Control-Max-Age", "3600"); // 预检请求的缓存时间
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, X-Requested-With"); // 允许的头信息

        String username = req.getParameter("username");
        String password = req.getParameter("password");
=======
        // 从请求体读取完整的JSON字符串
        StringBuilder sb = new StringBuilder();
        String line;
        try (BufferedReader reader = req.getReader()) {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        }
        String jsonStr = sb.toString();

        // 解析JSON数据
        JsonObject json = JsonParser.parseString(jsonStr).getAsJsonObject();
        String username = json.get("username").getAsString();
        String password = json.get("password").getAsString();
>>>>>>> 4d70b70d520d41a083e3b2e4d810e247b9ec12b8

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





