package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping("alienHome")
	//If we pass the parameter with same name from the request URL it will be automatically assigned
	//to the alien object else not
	public ModelAndView getTheData(Alien alien) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("obj", alien);
		mv.setViewName("home");
		return mv;
	}

}
