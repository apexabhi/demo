package com.nagarro.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.dto.Tshirt;
import com.nagarro.service.OutputPreference;
import com.nagarro.service.TshirtService;

@Controller
public class TshirtController {
	@Autowired
	private TshirtService ts;
	@Autowired
	private OutputPreference op;
	@PostConstruct
	public void init() {
	    ts.startCsvPollingThread();
	}
	@RequestMapping("/SearchProduct")
	public ModelAndView searchProduct(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		String color = request.getParameter("color");
		String size = request.getParameter("size");
		String gender = request.getParameter("gender");
		String preference = request.getParameter("pref");
		List<Tshirt>t=ts.checkProduct(color, size,gender,preference);
//		for(Tshirt x:t) {
//			System.out.println(x.getName());
//		}
		op.sortProducts(t,preference);
		mv.addObject("productlist",t);
		mv.setViewName("products");
		return mv;
	}
}
