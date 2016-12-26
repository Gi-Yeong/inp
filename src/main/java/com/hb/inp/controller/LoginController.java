package com.hb.inp.controller;

import com.hb.inp.model.Login.LoginDao;
import com.hb.inp.model.MySql.Test_Dao;
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

    @Autowired
    private SqlSession mySqlSession;
//    mysql_one

    @Autowired
    private SqlSession mySql2Session;
//    mysql_two

    @RequestMapping(value = "/dbtest")
    public void mysql_test(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("DB_TEST");
        String db_info = request.getParameter("db_infom");
        String callback = request.getParameter("callback");
        System.out.println(db_info);
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }


        if (db_info.equals("mysql_one")) {
            mySqlSession.getMapper(Test_Dao.class).mysql(db_info);

            System.out.println("JSON OBJECT MAKE_DBINFO1");
            mySqlSession.getMapper(Test_Dao.class).mysql(db_info);
            out.write(callback + "({\"db_name\" : \"result_one\"})");
            out.flush();
            out.close();
        } else if (db_info.equals("mysql_two")) {
            mySql2Session.getMapper(Test_Dao.class).mysql(db_info);
            System.out.println("JSON OBJECT MAKE_DBINFO2");
            out.write(callback + "({\"db_name\" : \"result_two\"})");
            out.flush();
            out.close();
        }
    }

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

    @RequestMapping("/jsontest")
    public void JsonTest(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("start");
        String count = request.getParameter("count");
        String msg = request.getParameter("msg");

        System.out.println(count);
        System.out.println();
        System.out.println(msg);

    }
}
