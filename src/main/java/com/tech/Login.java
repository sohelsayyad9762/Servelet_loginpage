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

public class Login extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("service method");

		String a1 = req.getParameter("uname");
		String a2 = req.getParameter("pass");

		System.out.println(a1 + " ------ " + a2);
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hp", "root", "root");

			PreparedStatement ps = con.prepareStatement("select * from info where name=? and pass=?");

			ps.setString(1, a1);
			ps.setString(2, a2);

			ResultSet rs = ps.executeQuery();
			
			
//			System.out.println(rs.getString(1));
//			System.out.println(rs.getString(3));

			if (rs.next()) {
				System.out.println("Here we Go");

				System.out.println("Login sucecssfully");
				RequestDispatcher rd = req.getRequestDispatcher("login_suc.jsp");
				rd.forward(req, resp);

			} else {
				System.out.println("Log in fail");
				RequestDispatcher rd = req.getRequestDispatcher("Login_fail.jsp");
				rd.forward(req, resp);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
