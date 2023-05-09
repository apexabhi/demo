package com.nagarro.controllers;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.service.TshirtService;
import com.nagarro.service.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService us;
//	@Autowired
//	private TshirtService ts;
//	
	@RequestMapping("/LogIn")
	public ModelAndView logIn(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		String uname = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		if(us.checkUser(uname, pwd)) {
			System.out.println("login successfull");
//			ts.readCSV();
			mv.addObject("uname",uname);
			mv.setViewName("products");
			return mv;
		}
		
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("/SignUp")
	public ModelAndView signUp(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		us.saveUser(username, pwd);
		mv.setViewName("index");
		return mv;
	}
	@RequestMapping("/Logout")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("uname", null);
		mv.setViewName("index");
		return mv;
	}
}
