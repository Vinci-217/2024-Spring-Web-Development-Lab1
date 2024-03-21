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





