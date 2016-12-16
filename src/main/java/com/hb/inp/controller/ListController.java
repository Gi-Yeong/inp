package com.hb.inp.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hb.inp.model.CityDao;
import com.hb.inp.model.CityVo;
import com.hb.inp.model.GuestDao;
import com.hb.inp.model.GuestVo;

@Controller
public class ListController {

	/*@Autowired
	private GuestDao guestDao; */

    @Autowired
    private SqlSession oracleSqlSession;

    @Autowired
    private SqlSession mySqlSession;

    @RequestMapping("/")
    public String guestListAll(Model model) {
        System.out.println("guestListAll");
        //model.addAttribute("alist", guestDao.selectAll());
        model.addAttribute("alist", oracleSqlSession.getMapper(GuestDao.class).selectAll());
        return "guest/list";
    }

    @RequestMapping("/orcjson")
    public String viewOraJson() {
        return "guest/OracleTest";
    }

    @RequestMapping("/myjson")
    public String viewMyJson() {
        return "guest/mySqlTest";
    }

    @RequestMapping(value = "/getorcJsonp")
    public void getOrcJsonByMap(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, Object> jsonObject = new HashMap<String, Object>();
        Map<String, Object> jsonSubObject = null;
        ArrayList<Map<String, Object>> jsonList = new ArrayList<Map<String, Object>>();
        List<GuestVo> list = oracleSqlSession.getMapper(GuestDao.class).selectAll();//guestDao.selectAll();
        String callBack = request.getParameter("callback");

        for (GuestVo dto : list) {
            jsonSubObject = new HashMap<String, Object>();
            jsonSubObject.put("sabun", dto.getSabun());
            jsonSubObject.put("name", dto.getName());
            jsonSubObject.put("nalja", dto.getNalja());
            jsonSubObject.put("pay", dto.getPay());
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


    @RequestMapping(value = "/getmyJsonp")
    public void getMyJsonByMap(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, Object> jsonObject = new HashMap<String, Object>();
        Map<String, Object> jsonSubObject = null;
        ArrayList<Map<String, Object>> jsonList = new ArrayList<Map<String, Object>>();
        List<CityVo> list = mySqlSession.getMapper(CityDao.class).selectAll();//guestDao.selectAll();
        String callBack = request.getParameter("callback");

        for (CityVo dto : list) {
            jsonSubObject = new HashMap<String, Object>();
            jsonSubObject.put("ID", dto.getID());
            jsonSubObject.put("Name", dto.getName());
            jsonSubObject.put("CountryCode", dto.getCountryCode());
            jsonSubObject.put("District", dto.getDistrict());
            jsonSubObject.put("Population", dto.getPopulation());
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
}
