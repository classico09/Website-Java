package com.servlet.mainpage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/register")
public class Register extends HttpServlet {
	
	//create the query 
	private static final String INSERT_QUERY = "INSERT INTO USER(userName, email, password, mobile) VALUES(?, ?, ?, ?)";
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw = resp.getWriter();
		//set content type
		resp.setContentType("text/html");
		//read the form values
		String name = req.getParameter("full_name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String mobile = req.getParameter("phone_number");
	
//		System.out.println("Full name: "+name );
//		System.out.println("Email: "+email);
//		System.out.println("Pw : "+password);
//		System.out.println("Phone number: "+ mobile);
		
		//Load the jdbc driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//create the connection
		try(Connection con = DriverManager.getConnection("jdbc:mysql://vteam8.cbr4uubmqr4e.ap-northeast-2.rds.amazonaws.com:3306/YouthDataHibernate","admin","HHzOAYbHqbL8q5M");
			PreparedStatement ps = con.prepareStatement(INSERT_QUERY)) {
			//set the values
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, password);
			ps.setString(4, mobile);
			
			//execute the query
			int count = ps.executeUpdate();
			if(count == 0) {
				pw.println("Registration failed /n Please, try again!");
			}else {
				pw.println("Success!");
			}
			
		} catch (SQLException se) {
			pw.println(se.getMessage());
			se.printStackTrace();
		}catch(Exception e){
			pw.println(e.getMessage());
			e.printStackTrace();
		}
		
		//close the stream
		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
		
}
