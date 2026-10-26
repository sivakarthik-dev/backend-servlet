package sms;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update")

public class Update_Serveltapp extends HttpServlet {
	
	@Override
	
	protected void service(HttpServletRequest req,HttpServletResponse rep) throws ServletException{
		
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		long phoneno=Long.parseLong(req.getParameter("phoneno"));
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","root");
			
			PreparedStatement p=c.prepareStatement("Update student set name=?,email=?,phoneno=? where id=?" );
			
			p.setString(1, name);
			p.setString(2, email);
			p.setLong(3,phoneno);
			p.setInt(4, id);
			
			if(p.executeUpdate()>0) {
				req.getRequestDispatcher("viewall").forward(req,rep);
			}
			else {
				System.out.println("student is not updated");
			}
			
			p.close();
			c.close();			
		} catch (ClassNotFoundException | SQLException | IOException e) {
			
			e.printStackTrace();
		}
	}



}
