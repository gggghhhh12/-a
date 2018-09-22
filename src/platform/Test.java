package platform;
import java.sql.ResultSet;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    //platform是我自己建的数据库
    //root 我自己数据库的用户名
    //password=123456789 我自己的数据库的密码
    public static void main(String[] args){
        ArrayList<String> newname=new ArrayList<>();
        System.out.println("请输入帖子内容");
        String l="";
        String s="";
        Scanner sc=new Scanner(System.in);//设置一个标志位，判断是论坛哪个栏目
        l=sc.next();
        Scanner sc1=new Scanner(System.in);
        s=sc1.next();
        System.out.println(s);
        String sql="update mes set nei='"+s+"',columid="+l+"";
        System.out.println(sql);
        try {
            Class.forName("com.mysql.jdbc.Driver");  //加载MYSQL JDBC驱动程序
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/platform?useSSL=false","root","123456789");//输入数据库的用户密码
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);
            Statement stmt2 = con.createStatement();
            ResultSet rs = stmt2.executeQuery("select username from user where userlike ='"+ l+"'");

            while(rs.next())
            {
                newname.add(rs.getString(1));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        platfom server = new platfom();
        for(int j=0;j<newname.size();j++){
            Observer user= new User(newname.get(j));
            server.registerObserver(user);
        }
        server.setInfomation(s);


    }


}
