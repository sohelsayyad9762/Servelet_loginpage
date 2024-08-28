package com.tech;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Update  extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("service Update class");
		
		String s1= req.getParameter("name");
		String s2= req.getParameter("email");
		String s3= req.getParameter("pass");
		String s4= req.getParameter("contact");
		
		System.out.println(s1+"--"+s2+"--"+s3+"--"+s4);
		
		
		try {
			
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hp", "root", "root");
			
			PreparedStatement ps= con.prepareStatement("update info set name=?,email=?,pass=?  where contact =?");
			
			ps.setString(1, s1);
			ps.setString(2, s2);
			ps.setString(3, s3);
			ps.setString(4, s4);
			
			int rs=ps.executeUpdate();
			System.out.println(rs);
			
			RequestDispatcher rd= req.getRequestDispatcher("Update_suc.jsp");
			rd.forward(req, resp);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
