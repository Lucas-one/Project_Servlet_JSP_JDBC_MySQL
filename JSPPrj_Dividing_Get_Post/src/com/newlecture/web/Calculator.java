package com.newlecture.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculator")
public class Calculator extends HttpServlet{
	
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//getMethod할 때  GET,POST 대문자로 써야함에 주의!
		if(req.getMethod().equals("GET")) {
			System.out.println("GET 요청이 왔다.");
		}
		else if(req.getMethod().equals("POST")) {
			System.out.println("POST 요청이 왔다.");
		}
		super.service(req, resp);
	}
	
	//기존에 있는거 Override한 것이기 때문에 앞에 쓸 필요가 없다.
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPOST 메소드가 호출되었습니다.");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet 메소드가 호출되었습니다.");
	}
	
}
