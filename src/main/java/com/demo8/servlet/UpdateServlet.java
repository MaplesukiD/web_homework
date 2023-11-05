package com.demo5.servlet;

import com.demo5.dao.FruitDB;
import com.demo5.entity.Fruit;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name="UpdateServlet",urlPatterns = "/update")
public class UpdateServlet extends ViewBaseServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session=request.getSession();

        Integer id=Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        Float price=Float.parseFloat(request.getParameter("price"));
        Integer count=Integer.parseInt(request.getParameter("count"));
        String remark=request.getParameter("id");
        Fruit fruit=new Fruit(id,name,price,count,remark);

        FruitDB.update(fruit);

        List<Fruit> fruitList=FruitDB.getAll();
        session.setAttribute("fruitList",fruitList);

        super.processTemplate("index",request,response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Integer id=Integer.parseInt(request.getParameter("id"));
        Fruit fruit=FruitDB.getById(id);
        request.setAttribute("fruit",fruit);
        super.processTemplate("update",request,response);
    }


}
