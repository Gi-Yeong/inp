package com.hb.inp.controller;

import com.hb.inp.model.MySql.*;
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
@RequestMapping("/iojson/")
public class JsonController {

    @Autowired
    private SqlSession mySqlSession;
//    mysql_one

    @Autowired
    private SqlSession mySql2Session;
//    mysql_two

    //    JM20, JM40 DB에서 데이터 가져오기
    @RequestMapping(value = "/getjmdata20")
    public void getJm20(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //    DB 선택
        System.out.println("DB_선택");
        String db_info = request.getParameter("db_infom");
//        String callback = request.getParameter("callback");
        System.out.println(db_info);
        PrintWriter out = null;

        if (db_info.equals("mysql_one")) {
//            JM20 전송 부분
            System.out.println("DBINFO1_USE_Start_JM20");
            Map<String, Object> jsonObject = new HashMap<String, Object>();
            Map<String, Object> jsonSubObject = null;
            ArrayList<Map<String, Object>> jsonList = new ArrayList<Map<String, Object>>();
            List<Jm20Vo> list = mySqlSession.getMapper(Jm20Dao.class).selectAll();
            String callBack = request.getParameter("callback");

            for (Jm20Vo dto : list) {
                jsonSubObject = new HashMap<String, Object>();
                jsonSubObject.put("jycode", dto.getJycode());
                jsonSubObject.put("jname", dto.getJname());
                jsonSubObject.put("jwxt", dto.getJwxt());
                jsonSubObject.put("jchk", dto.getJchk());
                jsonSubObject.put("jgubun", dto.getJgubun());
                jsonSubObject.put("jea", dto.getJea());
                jsonSubObject.put("jwdan1", dto.getJwdan1());
                jsonSubObject.put("jwdan2", dto.getJwdan2());
                jsonSubObject.put("jsdan2", dto.getJsdan2());
                jsonSubObject.put("jbcode1", dto.getJbcode1());
                jsonSubObject.put("jbcode2", dto.getJbcode2());
                jsonList.add(jsonSubObject);
            }
            jsonObject.put("success", true);
            jsonObject.put("total_count", list.size());
            jsonObject.put("result_list_jm20", jsonList);
            System.out.println(jsonList.toString());

            String result = null;
            ObjectMapper mapper_jm20 = new ObjectMapper();
            try {
                result = mapper_jm20.writeValueAsString(jsonObject);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            out = response.getWriter();
            System.out.println(callBack + "(" + result + ")");
            out.write(callBack + "(" + result + ")");
            out.flush();
            out.close();

        } else if (db_info.equals("mysql_two")) {
            //            JM20 전송 부분

            System.out.println("DBINFO2_USE_Start_JM20");
            Map<String, Object> jsonObject = new HashMap<String, Object>();
            Map<String, Object> jsonSubObject = null;
            ArrayList<Map<String, Object>> jsonList = new ArrayList<Map<String, Object>>();
            List<Jm20Vo> list = mySql2Session.getMapper(Jm20Dao.class).selectAll();
            String callBack = request.getParameter("callback");

            for (Jm20Vo dto : list) {
                jsonSubObject = new HashMap<String, Object>();
                jsonSubObject.put("jycode", dto.getJycode());
                jsonSubObject.put("jname", dto.getJname());
                jsonSubObject.put("jwxt", dto.getJwxt());
                jsonSubObject.put("jchk", dto.getJchk());
                jsonSubObject.put("jgubun", dto.getJgubun());
                jsonSubObject.put("jea", dto.getJea());
                jsonSubObject.put("jwdan1", dto.getJwdan1());
                jsonSubObject.put("jwdan2", dto.getJwdan2());
                jsonSubObject.put("jsdan2", dto.getJsdan2());
                jsonSubObject.put("jbcode1", dto.getJbcode1());
                jsonSubObject.put("jbcode2", dto.getJbcode2());
                jsonList.add(jsonSubObject);
            }
            jsonObject.put("success", true);
            jsonObject.put("total_count", list.size());
            jsonObject.put("result_list_jm20", jsonList);
            System.out.println(jsonList.toString());

            String result = null;
            ObjectMapper mapper = new ObjectMapper();
            try {
                result = mapper.writeValueAsString(jsonObject);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            out = response.getWriter();
            System.out.println(callBack + "(" + result + ")");
            out.write(callBack + "(" + result + ")");
            out.flush();
            out.close();
        }
    }

    @RequestMapping(value = "/getjmdata40")
    public void getJm40(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //    DB 선택
        System.out.println("DB_선택");
        String db_info = request.getParameter("db_infom");
//        String callback = request.getParameter("callback");
        System.out.println(db_info);
        PrintWriter out = null;

        if (db_info.equals("mysql_one")) {
            System.out.println("DBINFO1_USE_Start_JM40");
            Map<String, Object> jsonObject = new HashMap<String, Object>();
            Map<String, Object> jsonSubObject = null;
            ArrayList<Map<String, Object>> jsonList = new ArrayList<Map<String, Object>>();
            String callBack = request.getParameter("callback");
            String result = null;
//            JM40 전송 부분
            List<Jm40Vo> list = mySqlSession.getMapper(Jm40Dao.class).selectAll();

            for (Jm40Vo dto : list) {
                jsonSubObject = new HashMap<String, Object>();
                jsonSubObject.put("code", dto.getCode());
                jsonSubObject.put("title1", dto.getTitle1());
                jsonSubObject.put("bbigo", dto.getBbigo());
                jsonSubObject.put("tel1", dto.getTel1());
                jsonSubObject.put("address", dto.getAddress());
                jsonSubObject.put("number", dto.getNumber());
                jsonSubObject.put("name", dto.getName());
                jsonSubObject.put("gubun", dto.getGubun());
                jsonSubObject.put("lastdan", dto.getLastdan());
                jsonSubObject.put("moneyay", dto.getMoneay());
                jsonList.add(jsonSubObject);
            }
            jsonObject.put("success", true);
            jsonObject.put("total_count", list.size());
            jsonObject.put("result_list_jm40", jsonList);
            System.out.println(jsonList.toString());

            ObjectMapper mapper_jm40 = new ObjectMapper();
            try {
                result = mapper_jm40.writeValueAsString(jsonObject);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            out = response.getWriter();
            System.out.println(callBack + "(" + result + ")");
            out.write(callBack + "(" + result + ")");
            out.flush();
            out.close();

        } else if (db_info.equals("mysql_two")) {
            System.out.println("DBINFO2_USE_Start_JM20");
            Map<String, Object> jsonObject = new HashMap<String, Object>();
            Map<String, Object> jsonSubObject = null;
            ArrayList<Map<String, Object>> jsonList = new ArrayList<Map<String, Object>>();
            List<Jm40Vo> list = mySql2Session.getMapper(Jm40Dao.class).selectAll();
            String callBack = request.getParameter("callback");
            String result = null;
            //            JM40 전송 부분
            System.out.println("DBINFO2_USE_Start_JM40");
            for (Jm40Vo dto : list) {
                jsonSubObject = new HashMap<String, Object>();
                jsonSubObject.put("code", dto.getCode());
                jsonSubObject.put("title1", dto.getTitle1());
                jsonSubObject.put("bbigo", dto.getBbigo());
                jsonSubObject.put("tel1", dto.getTel1());
                jsonSubObject.put("address", dto.getAddress());
                jsonSubObject.put("number", dto.getNumber());
                jsonSubObject.put("name", dto.getName());
                jsonSubObject.put("gubun", dto.getGubun());
                jsonSubObject.put("lastdan", dto.getLastdan());
                jsonSubObject.put("moneyay", dto.getMoneay());
                jsonList.add(jsonSubObject);
            }
            jsonObject.put("success", true);
            jsonObject.put("total_count", list.size());
            jsonObject.put("result_list_jm40", jsonList);
            System.out.println(jsonList.toString());

            ObjectMapper mapper_jm40 = new ObjectMapper();
            try {
                result = mapper_jm40.writeValueAsString(jsonObject);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            out = response.getWriter();
            System.out.println(callBack + "(" + result + ")");
            out.write(callBack + "(" + result + ")");
            out.flush();
            out.close();
        }
    }


    //    VM71, VM70 저장
    @RequestMapping(value = "/putvmdata70")
    public void putVm70(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        System.out.println("DB_선택");
        String db_info = request.getParameter("db_infom");
//        String callback = request.getParameter("callback");
        System.out.println(db_info);
        PrintWriter out = null;
//
        if (db_info.equals("mysql_one")) {
//            VM70 전송 부분
            System.out.println("DBINFO1_USE_Start_VM70");
            ObjectMapper mapper = new ObjectMapper();
            System.out.println(request.getParameter("arrayVm70"));
            String jsonArrayVm70 = request.getParameter("arrayVm70");
            System.out.println(request.getParameter("arrayVm71"));
            String stringInfo70 = " { \"param1\" : " + jsonArrayVm70 + " } ";
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject70 = (JSONObject) jsonParser.parse(stringInfo70);

            JSONArray paramInfoArray70 = (JSONArray) jsonObject70.get("param1");
            for (int i = 0; i < paramInfoArray70.size(); i++) {
                Vm70Vo dto = null;
                JSONObject paramObj = (JSONObject) paramInfoArray70.get(i);
                dto.setJ_number((String) paramObj.get("j_number"));
                dto.setJ_code((String) paramObj.get("j_code"));
                dto.setJ_title((String) paramObj.get("j_title"));
                dto.setJ_schk((String) paramObj.get("j_schk"));
                dto.setJ_date((String) paramObj.get("j_date"));
                dto.setJ_time((String) paramObj.get("j_time"));
                dto.setJ_memo1((String) paramObj.get("j_momo1"));
                dto.setJ_no((Integer) paramObj.get("j_no"));
                dto.setJ_gubun((Integer) paramObj.get("j_gubun"));
                dto.setJ_money1((Integer) paramObj.get("j_money1"));
                dto.setJ_money2((Integer) paramObj.get("j_money2"));
                dto.setJ_money3((Integer) paramObj.get("j_money3"));
                dto.setJ_money4((Integer) paramObj.get("j_money4"));
                dto.setJ_money5((Integer) paramObj.get("j_money5"));
                dto.setJ_money6((Integer) paramObj.get("j_money6"));
                mySqlSession.getMapper(Vm70Dao.class).insertVm70(dto);
                System.out.println("DBINFO1_USE_Start_VM70 _ NO:" + i);
            }

        } else if (db_info.equals("mysql_two")) {
//            VM70 전송 부분
            System.out.println("DBINFO2_USE_Start_VM70");
            ObjectMapper mapper = new ObjectMapper();
            System.out.println(request.getParameter("arrayVm70"));
            String jsonArrayVm70 = request.getParameter("arrayVm70");
            System.out.println(request.getParameter("arrayVm71"));
            String stringInfo70 = " { \"param1\" : " + jsonArrayVm70 + " } ";
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject70 = (JSONObject) jsonParser.parse(stringInfo70);

            JSONArray paramInfoArray70 = (JSONArray) jsonObject70.get("param1");
            for (int i = 0; i < paramInfoArray70.size(); i++) {
                Vm70Vo dto = null;
                JSONObject paramObj = (JSONObject) paramInfoArray70.get(i);
                dto.setJ_number((String) paramObj.get("j_number"));
                dto.setJ_code((String) paramObj.get("j_code"));
                dto.setJ_title((String) paramObj.get("j_title"));
                dto.setJ_schk((String) paramObj.get("j_schk"));
                dto.setJ_date((String) paramObj.get("j_date"));
                dto.setJ_time((String) paramObj.get("j_time"));
                dto.setJ_memo1((String) paramObj.get("j_momo1"));
                dto.setJ_no((Integer) paramObj.get("j_no"));
                dto.setJ_gubun((Integer) paramObj.get("j_gubun"));
                dto.setJ_money1((Integer) paramObj.get("j_money1"));
                dto.setJ_money2((Integer) paramObj.get("j_money2"));
                dto.setJ_money3((Integer) paramObj.get("j_money3"));
                dto.setJ_money4((Integer) paramObj.get("j_money4"));
                dto.setJ_money5((Integer) paramObj.get("j_money5"));
                dto.setJ_money6((Integer) paramObj.get("j_money6"));
                mySql2Session.getMapper(Vm70Dao.class).insertVm70(dto);
                System.out.println("DBINFO2_USE_Start_VM70 _ NO:" + i);
            }
        }
    }

    @RequestMapping(value = "/putvmdata71")
    public void putVm71(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        System.out.println("DB_선택");
        String db_info = request.getParameter("db_infom");
//        String callback = request.getParameter("callback");
        System.out.println(db_info);
        PrintWriter out = null;
//
        if (db_info.equals("mysql_one")) {
            ObjectMapper mapper = new ObjectMapper();
            System.out.println(request.getParameter("arrayVm70"));
            System.out.println(request.getParameter("arrayVm71"));
            String jsonArrayVm71 = request.getParameter("arrayVm71");
            String stringInfo71 = " { \"param2\" : " + jsonArrayVm71 + " } ";
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject71 = (JSONObject) jsonParser.parse(stringInfo71);

            JSONArray paramInfoArray71 = (JSONArray) jsonObject71.get("param2");
//            VM71 전송 부분
            System.out.println("DBINFO1_USE_Start_VM71");
            for (int i = 0; i < paramInfoArray71.size(); i++) {
                Vm71Vo dto = null;
                JSONObject paramObj = (JSONObject) paramInfoArray71.get(i);
                dto.setS_number((String) paramObj.get("s_number"));
                dto.setS_jno((Integer) paramObj.get("s_jno"));
                dto.setS_jcode((String) paramObj.get("s_jcode"));
                dto.setS_jname((String) paramObj.get("s_jname"));
                dto.setS_jwxt((String) paramObj.get("s_jwxt"));
                dto.setS_jea((Integer) paramObj.get("s_jea"));
                dto.setS_jchk((String) paramObj.get("s_jchk"));
                dto.setS_jsur1((Integer) paramObj.get("s_jsur1"));
                dto.setS_box((Integer) paramObj.get("s_box"));
                dto.setS_ea((Integer) paramObj.get("s_ea"));
                dto.setS_jdan1((Integer) paramObj.get("s_jdan1"));
                dto.setS_jdan2((Integer) paramObj.get("s_jdan2"));
                dto.setS_money1((Integer) paramObj.get("s_money1"));
                dto.setS_money2((Integer) paramObj.get("s_money2"));
                dto.setS_money3((Integer) paramObj.get("s_money3"));
                dto.setS_jbcode1((String) paramObj.get("s_jbcode1"));
                mySqlSession.getMapper(Vm71Dao.class).insertVm71(dto);
                System.out.println("DBINFO1_USE_Start_VM71 _ NO:" + i);
            }
            String callBack = request.getParameter("callback");

            out = response.getWriter();
            out.write(callBack + "({\"ok\" : \"oksuccess\"})");
            out.flush();
            out.close();
        } else if (db_info.equals("mysql_two")) {
            ObjectMapper mapper = new ObjectMapper();
            System.out.println(request.getParameter("arrayVm70"));
            System.out.println(request.getParameter("arrayVm71"));
            String jsonArrayVm71 = request.getParameter("arrayVm71");
            String stringInfo71 = " { \"param2\" : " + jsonArrayVm71 + " } ";
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject71 = (JSONObject) jsonParser.parse(stringInfo71);

            JSONArray paramInfoArray71 = (JSONArray) jsonObject71.get("param2");
//            VM71 전송 부분
            System.out.println("DBINFO2_USE_Start_VM71");
            for (int i = 0; i < paramInfoArray71.size(); i++) {
                Vm71Vo dto = null;
                JSONObject paramObj = (JSONObject) paramInfoArray71.get(i);
                dto.setS_number((String) paramObj.get("s_number"));
                dto.setS_jno((Integer) paramObj.get("s_jno"));
                dto.setS_jcode((String) paramObj.get("s_jcode"));
                dto.setS_jname((String) paramObj.get("s_jname"));
                dto.setS_jwxt((String) paramObj.get("s_jwxt"));
                dto.setS_jea((Integer) paramObj.get("s_jea"));
                dto.setS_jchk((String) paramObj.get("s_jchk"));
                dto.setS_jsur1((Integer) paramObj.get("s_jsur1"));
                dto.setS_box((Integer) paramObj.get("s_box"));
                dto.setS_ea((Integer) paramObj.get("s_ea"));
                dto.setS_jdan1((Integer) paramObj.get("s_jdan1"));
                dto.setS_jdan2((Integer) paramObj.get("s_jdan2"));
                dto.setS_money1((Integer) paramObj.get("s_money1"));
                dto.setS_money2((Integer) paramObj.get("s_money2"));
                dto.setS_money3((Integer) paramObj.get("s_money3"));
                dto.setS_jbcode1((String) paramObj.get("s_jbcode1"));
                mySql2Session.getMapper(Vm71Dao.class).insertVm71(dto);
                System.out.println("DBINFO2_USE_Start_VM71 _ NO:" + i);
            }
            String callBack = request.getParameter("callback");

            out = response.getWriter();
            out.write(callBack + "({\"ok\" : \"oksuccess\"})");
            out.flush();
            out.close();
        }
    }
}
