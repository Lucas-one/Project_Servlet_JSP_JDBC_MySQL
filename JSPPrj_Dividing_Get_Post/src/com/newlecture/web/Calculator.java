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
		//getMethod�� ��  GET,POST �빮�ڷ� ����Կ� ����!
		if(req.getMethod().equals("GET")) {
			System.out.println("GET ��û�� �Դ�.");
		}
		else if(req.getMethod().equals("POST")) {
			System.out.println("POST ��û�� �Դ�.");
		}
		super.service(req, resp);
	}
	
	//������ �ִ°� Override�� ���̱� ������ �տ� �� �ʿ䰡 ����.
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPOST �޼ҵ尡 ȣ��Ǿ����ϴ�.");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet �޼ҵ尡 ȣ��Ǿ����ϴ�.");
	}
	
}
