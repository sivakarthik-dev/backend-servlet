package sms;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/viewall")
public class Viewallservletapp extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req,HttpServletResponse resp) throws ServletException{
		
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","root");
		
		PreparedStatement p=c.prepareStatement("select*from student");
		
		ResultSet r=p.executeQuery();
		
		req.setAttribute("rs", r);
		
		req.getRequestDispatcher("ViewallStudent.jsp").forward(req, resp);
		
		r.close();
		p.close();
		c.close();
	} catch (ClassNotFoundException | SQLException | IOException e) {
		
		e.printStackTrace();
	}
	
	
	}


	

}
