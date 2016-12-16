package com.hb.inp.controller;

import com.hb.inp.model.Login.LoginDao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("/login/")
public class LoginController {

    @Autowired
    private SqlSession oracleSqlSession;

    @RequestMapping(value = "/memberlogin", method = RequestMethod.POST)
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

        System.out.println("got db_key");
        assert out != null;
        out.print(db_info);
        out.flush();
        out.close();
        System.out.println("login success");
    }
}
