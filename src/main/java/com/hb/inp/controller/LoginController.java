package com.hb.inp.controller;

import com.hb.inp.model.Login.LoginDao;
import org.apache.ibatis.session.SqlSession;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/login/")
public class LoginController {

    @Autowired
    private SqlSession oracleSqlSession;

    @RequestMapping(value = "/memberlogin")
    public void guestLogin(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("start");
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");

        System.out.println("id: " + id + "&" + "pw: " + pw);

        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String db_info = oracleSqlSession.getMapper(LoginDao.class).logincheck(id, pw);

        System.out.println("JSON OBJECT MAKE");
        Map<String, Object> jsonObject = new HashMap<String, Object>();
        Map<String, Object> jsonSubObject = null;
        ArrayList<Map<String, Object>> jsonList = new ArrayList<Map<String, Object>>();
        String callBack = request.getParameter("callback");

        jsonSubObject = new HashMap<String, Object>();
        jsonSubObject.put("db_key_from_Oracle", db_info);
        jsonList.add(jsonSubObject);
        jsonObject.put("success", true);
        jsonObject.put("total_count", 1);
        jsonObject.put("result_list", jsonList);
        System.out.println(jsonList.toString());

        String result = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            result = mapper.writeValueAsString(jsonObject);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(callBack + "(" + result + ")");
        assert out != null;
        out.write(callBack + "(" + result + ")");
        out.flush();
        out.close();
        System.out.println("login success");
    }
}
