package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	//Since we dont have a dependency added to convert a jsp to servlet
	//We need to add it in our pom.xml   ----> tomcat jasper
	@RequestMapping("home")
	//To recieve any value as the request parameter
	public String home(HttpServletRequest req) {
		//HttpServletRequest Object will have the Request URl as a whole
		//Which will contain all the fields and other stuff, then whatever we want to fetch
		//We can get from this object
		
		String name = req.getParameter("name");
		String remoteHost = req.getRemoteHost();
		
		HttpSession session = req.getSession();
		System.out.println("Hi "+"name = "+ name + " Remote Host " + remoteHost);
		session.setAttribute("name", name);
		return "home";
	}
	
	//Getting HttpSessionObj via dependency injection from the Spring Container
	//Getting the name directly which is mapped from the request URL
	
	//@RequestParam("string_from_request_url") Object alias
	//It is used to give an alias for the request parameter that is coming from the request URL
	@RequestMapping("springHome")
	public String valueFromSpring(@RequestParam("name")String myName, HttpSession session) {
		System.out.println("Hi "+ myName);
		session.setAttribute("springName", myName);
		return "homeUsingSpring";
	}
	
	@RequestMapping("springHomeMVC")
	public ModelAndView valueFromSpringMVC(@RequestParam("name")String myNameMV) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("myNameMV", myNameMV);
		mv.setViewName("homeUsingSpringMVC");;
		return mv;
	}
}
