package cn.tedu.controller;

import cn.tedu.dao.Teacherdao;
import cn.tedu.entity.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateServlet",urlPatterns = "/update")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        String id=request.getParameter("id");
        String name=request.getParameter("name");
        String type=request.getParameter("type");
        String sal=request.getParameter("sal");
        //调用方法,通过将获取的参数传入teacher类中，然后将参数传入teacherdao中
        Teacher teacher=new Teacher(Integer.parseInt(id),name,type,Integer.parseInt(sal));
        Teacherdao teacherdao=new Teacherdao();
        teacherdao.update(teacher);
        response.sendRedirect("findall");
    }
}
