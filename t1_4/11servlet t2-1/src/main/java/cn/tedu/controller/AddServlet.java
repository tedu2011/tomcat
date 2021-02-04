package cn.tedu.controller;

import cn.tedu.dao.Teacherdao;
import cn.tedu.entity.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddServlet",urlPatterns = "/add")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //数据库在dao里面进行执行，我们要执行教师的数据库，所有叫teacherdao,然后
        // 就是每个教师都信息都存储在一个类中
        //获取参数
        String name=request.getParameter("name");
        String type=request.getParameter("type");
        String sal=request.getParameter("sal");
        System.out.println(name+":"+type+":"+sal);
        //创建teach对象
        Teacher teacher=new Teacher(0,name,type,Integer.parseInt(sal));
        //创建teachdao
        Teacherdao teacherdao=new Teacherdao();
        teacherdao.add(teacher);
        //响应
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw=response.getWriter();
        pw.print("添加完成");
        pw.close();
    }
}
