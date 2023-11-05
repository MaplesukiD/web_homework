package com.demo5.servlet;

import com.demo5.dao.FruitDB;
import com.demo5.entity.Fruit;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name="DeleteServlet",urlPatterns = "/delete")
public class DeleteServlet extends ViewBaseServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session=request.getSession();

        Integer id=Integer.parseInt(request.getParameter("id"));
        FruitDB.delete(id);
        List<Fruit> fruitList=FruitDB.getAll();
        session.setAttribute("fruitList",fruitList);
        super.processTemplate("index",request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
