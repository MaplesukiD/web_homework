package com.demo5.servlet;

import com.demo5.dao.FruitDB;
import com.demo5.entity.Fruit;
import com.demo5.util.StringUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name="IndexServlet",urlPatterns = "/index")
public class IndexServlet extends ViewBaseServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        request.setCharacterEncoding("utf-8");

        //若为空是直接访问，不为空是点击查询
        String oper=request.getParameter("oper");
        String keyword=null;
        if(!StringUtil.isEmpty(oper)&&oper.equals("search")){
            keyword=request.getParameter("keyword");
            if(StringUtil.isEmpty(keyword)){
                keyword="";
            }
        }

        List<Fruit> fruitList;
        if(!StringUtil.isEmpty(keyword)){
            fruitList= FruitDB.getAll(keyword);
        }else {
            fruitList=FruitDB.getAll();
        }
        session.setAttribute("fruitList",fruitList);
        super.processTemplate("index",request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
