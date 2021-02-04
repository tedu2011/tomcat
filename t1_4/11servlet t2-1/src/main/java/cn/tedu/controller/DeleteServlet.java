package cn.tedu.controller;

import cn.tedu.dao.Teacherdao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteServlet",urlPatterns = "/delete")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数 id，通过id进行删除 然后进行重定向findall
        int id=Integer.parseInt(request.getParameter("id"));
//        System.out.println("删除的id:"+id);
        //调用deleteById
        Teacherdao teacherdao=new Teacherdao();
        teacherdao.deleteById(id);
        response.sendRedirect("findall");
    }
}
