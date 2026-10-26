package sms;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update_page")
public class Update_page extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req,HttpServletResponse resp) throws ServletException{
		
		int id=Integer.parseInt(req.getParameter("id"));
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","root");
			
			PreparedStatement p=c.prepareStatement("select * from student where id=?");
			
			p.setInt(1, id);
			
			ResultSet r=p.executeQuery();
			
			r.next();//moving cursor to record
			
			req.setAttribute("res", r);
			
			req.getRequestDispatcher("update.jsp").forward(req, resp);
			
			r.close();
			p.close();
			c.close();
		} catch (ClassNotFoundException | SQLException | IOException e) {
			
			e.printStackTrace();
		}
	}

	

}
