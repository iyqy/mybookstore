package com.yqy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yqy.dao.Userdao;
import com.yqy.domain.Survey;

public class Serveyservlet extends HttpServlet {

	public Serveyservlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Survey survey = new Survey();
		Userdao dao = new Userdao();
		survey.setA(request.getParameter("a"));
		survey.setB(request.getParameter("b"));
		survey.setC(request.getParameter("c"));
		survey.setD(request.getParameter("d"));
		survey.setE(request.getParameter("e"));
		survey.setF(request.getParameter("f"));
		survey.setG(request.getParameter("g"));
		survey.setH(request.getParameter("h"));
		survey.setI(request.getParameter("i"));
		survey.setJ(request.getParameter("j"));
		boolean b = dao.insert(survey);
		if(b){
			response.sendRedirect("/survey/suc.jsp");
		}else{
			response.sendRedirect("/survey/ero.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
