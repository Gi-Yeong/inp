package com.hb.inp.controller;

import com.hb.inp.model.MySql.Test_Dao;
import com.hb.inp.model.MySql.Test_Vo;
import org.apache.ibatis.session.SqlSession;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/getjson/")
public class GetJSON {

    @Autowired
    private SqlSession oracleSqlSession;

    @Autowired
    private SqlSession mySqlSession;
//    mysql_one

    @Autowired
    private SqlSession mySql2Session;
//    mysql_two

    @RequestMapping(value = "/getmyJsonp")
    public void getJsonTest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, Object> jsonObject = new HashMap<String, Object>();
        Map<String, Object> jsonSubObject = null;
        ArrayList<Map<String, Object>> jsonList = new ArrayList<Map<String, Object>>();
        List<Test_Vo> list = mySqlSession.getMapper(Test_Dao.class).selectAll();
        String callBack = request.getParameter("callback");

        for (Test_Vo dto : list) {
            jsonSubObject = new HashMap<String, Object>();
            jsonSubObject.put("db_info", dto.getTest());
            jsonSubObject.put("id", dto.getId());
            jsonSubObject.put("name", dto.getName());
            jsonList.add(jsonSubObject);
        }
        jsonObject.put("success", true);
        jsonObject.put("total_count", list.size());
        jsonObject.put("result_list", jsonList);
        System.out.println(jsonList.toString());

        String result = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            result = mapper.writeValueAsString(jsonObject);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        PrintWriter out = response.getWriter();
        System.out.println(callBack + "(" + result + ")");
        out.write(callBack + "(" + result + ")");
        out.flush();
        out.close();
    }

    @RequestMapping(value = "/sendmyJsonArray")
    public void sendJson(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        System.out.println(" var jobj = new Object();");
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(request.getParameter("arrayJson"));
        String jsonArray = request.getParameter("arrayJson");
        String stringInfo = " { \"param\" : " + jsonArray + " } ";
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(stringInfo);

        JSONArray paramInfoArray = (JSONArray) jsonObject.get("param");
        for (int i = 0; i < paramInfoArray.size(); i++) {
            JSONObject paramObj = (JSONObject) paramInfoArray.get(i);
            System.out.println(paramObj.toString());
            System.out.println(paramObj.get("id"));
            System.out.print(":");
            System.out.println(paramObj.get("name"));
            System.out.print(":");
            System.out.println(paramObj.get("db_info"));
            System.out.print("/");
        }
        // jsonObject.put("success", false);
        String callBack = request.getParameter("callback");

        PrintWriter out = response.getWriter();
        out.write(callBack + "({\"ok\" : \"oksuccess\"})");
        out.flush();
        out.close();

    }
}
