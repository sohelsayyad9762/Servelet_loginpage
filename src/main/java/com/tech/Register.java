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

public class Register extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	      
		System.out.println("service method");
		
		String s1= req.getParameter("name");
		String s2= req.getParameter("email");
		String s3= req.getParameter("pass");
		String s4= req.getParameter("contact");
		
		System.out.println(s1+"--"+s2+"--"+s3+"--"+s4);
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hp", "root", "root");
			
			PreparedStatement ps= con.prepareStatement("insert into info values(?,?,?,?)");
			
			ps.setString(1,s1);
			ps.setString(2,s2);
			ps.setString(3,s3);
			ps.setString(4,s4);
			
			int count=ps.executeUpdate();
			System.out.println(count);
			
			if (count>0) 
			{   
				System.out.println("successful");
				
				RequestDispatcher rd= req.getRequestDispatcher("Reg_suc.jsp");
				rd.forward(req, resp);
				
			}else {
				
				 
		}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
