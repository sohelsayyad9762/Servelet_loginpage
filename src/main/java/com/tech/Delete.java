package com.tech;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Delete extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Service method Delete class");
		
		
		String s1= req.getParameter("uname");
		
		System.out.println(s1);
		
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hp", "root", "root");
			
			PreparedStatement ps= con.prepareStatement("delete from info where name=?");
			
			ps.setString(1, s1);
		     
			int rs=ps.executeUpdate();
			
			if (rs>0) {
				
				System.out.println("Delete Sucsecfully...");
				req.setAttribute("NAME", s1);
				RequestDispatcher rd =req.getRequestDispatcher("delete_suc.jsp");
				rd.forward(req, resp);
				
				
			}else {
				
				System.out.println("delete fail");
				RequestDispatcher rd= req.getRequestDispatcher("fail_suc.jsp");
				
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
