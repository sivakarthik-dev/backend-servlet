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

@WebServlet("/delete")

public class DeleteServeltApp extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req,HttpServletResponse resp) throws ServletException{
		
		int id=Integer.parseInt(req.getParameter("id"));
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","root");
			
			PreparedStatement p=c.prepareStatement("delete from  student where id=? ");
			
			p.setInt(1, id);
			
			if(p.executeUpdate()>0) {
				req.getRequestDispatcher("viewall").forward(req, resp);
			}else {
				System.out.println("not deleted");
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			
			e.printStackTrace();
		}
	}



}
