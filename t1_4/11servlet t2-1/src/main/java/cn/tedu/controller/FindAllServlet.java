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
import java.util.List;

@WebServlet(name = "FindAllServlet",urlPatterns = "/findall")
public class FindAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //查询的话就是把hero里面的所有数据存储到list集合中，才能查到所有数据
        //创建执行sql语句的对象，然后调用findall方法
        Teacherdao teacherdao=new Teacherdao();
        List<Teacher> list=teacherdao.findall();
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw=response.getWriter();
        pw.print("<table border=1>");
        pw.print("<caption>教师表</caption>");
        pw.print("<tr><th>id</th><th>姓名</th><th>类型</th><th>工资</th><th>操作</th></tr>");
        //遍历输出测试一下
        for(Teacher t:list){
            //每一个教师都是单独一行
            pw.print("<tr>");
            pw.print("<td>"+t.getId()+"</td>");
            pw.print("<td>"+t.getName()+"</td>");
            pw.print("<td>"+t.getType()+"</td>");
            pw.print("<td>"+t.getSal()+"</td>");
            pw.print("<td><a href='delete?id="+t.getId()+"'>删除</a></td>");
            pw.print("</tr>");
        }
        pw.print("</table>");
        pw.close();
        //控制台测试成功就要输出在网页上
    }
}
