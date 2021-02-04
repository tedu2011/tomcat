package cn.tedu.dao;

import cn.tedu.entity.Teacher;
import cn.tedu.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Teacherdao {
    public void add(Teacher teacher) {
        try( Connection conn= DBUtils.getConn()) {
             String sql="insert into teacher values(null,?,?,?)";
             PreparedStatement ps=conn.prepareStatement(sql);
             ps.setString(1,teacher.getName());
             ps.setString(2,teacher.getType());
             ps.setInt(3,teacher.getSal());
             ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Teacher> findall() {
        ArrayList list=new ArrayList();
        //创建连接
        try(Connection conn=DBUtils.getConn()) {
            String sql="select id,name,type,sal from teacher";
            Statement s=conn.createStatement();
            ResultSet rs=s.executeQuery(sql);
            while(rs.next()){
                int id=rs.getInt(1);
                String name=rs.getString(2);
                String type=rs.getString(3);
                int sal=rs.getInt(4);
                //获取到后往teacher中添加，再添加到list中
                //因为list中存放的是每一个教师，每个教师都要带有这些数据
                list.add(new Teacher(id,name,type,sal));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public void deleteById(int id) {
        //获取连接
        try(Connection conn=DBUtils.getConn()) {
            String sql="delete from teacher where id=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Teacher teacher) {
        try(Connection conn=DBUtils.getConn()) {
            String sql="update teacher set name=?,type=?,sal=? where id=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,teacher.getName());
            ps.setString(2,teacher.getType());
            ps.setInt(3,teacher.getSal());
            ps.setInt(4,teacher.getId());
            ps.executeUpdate();
            System.out.println("修改完成");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
