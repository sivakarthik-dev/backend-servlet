package sms;

import java.io.IOException;

import java.lang.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/save")
public class SaveServeltApp extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException {
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String phone=req.getParameter("phoneno");
		
		System.out.println(id);
		System.out.println(name);
		System.out.println(email);
		System.out.println(phone);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","root");
			
			PreparedStatement p = c.prepareStatement("insert into student values (?,?,?,?)");
			
			p.setInt(1,Integer.parseInt(id));
			p.setString(2, name);
			p.setString(3, email);
			p.setLong(4,Long.parseLong(phone));
			
			
			
			System.out.println(p.executeUpdate()==1?"row is inserted":"row is not inserted");
			p.close();
			c.close();	
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
