package com.webapp.project.db;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;


@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String user="springstudent";
		String pw="springstudent";
		
		String URL="jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
		String driver="com.mysql.cj.jdbc.Driver";
		
		try
		{
			PrintWriter out=response.getWriter();
			out.println(URL);	
			Class.forName(driver);
			Connection myconnection=DriverManager.getConnection(URL,user,pw);
			out.println("connection successful");
			myconnection.close();			
		}
		catch(Exception exc)
		{
			exc.printStackTrace();
		}
		
	}

}
