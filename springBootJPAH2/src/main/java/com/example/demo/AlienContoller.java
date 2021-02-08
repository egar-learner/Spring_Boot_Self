package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

//IF WE JUST WANT TO DO CRUD OPERATION WE CAN DO IT WITHOUT A CONTROLLER USING
//SPRING DATA REST,
//IT HAS ALL THE CRUD OPERATIONS ALREADY AVAILABLE


//We can mention here "RestController" instead of "Controller"
//This will enable all the methods to send some body , and we can omit the @ResponseBody annotation
//Otherwise, with @Controller annotation the methods will first try to search for a page name that is
//returned by the method if we dont specify the @ResponseBody annotation
@RestController
public class AlienContoller {
	
	@Autowired
	AlienRepo alienRepo;
	
	@RequestMapping("/")
	public String getData() {
		return "home.jsp";
	}
	
	@RequestMapping("/addAlien")
	public String addAlien(Alien alien) {
		alienRepo.save(alien);
		return "home.jsp";
	}
	
	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int aid) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("showData.jsp");
		Alien alien = alienRepo.findById(aid).orElse(null);
		System.out.println(null != alien ? alien.getAname():"EmptyResult");
		mv.addObject(alien);
		return mv;
	}
	
	@RequestMapping("updateAlien")
	public ModelAndView updateAlien(Alien alien) {
		ModelAndView mv = new ModelAndView("home.jsp");
		alienRepo.save(alien);
		return mv;
	}
	
	
	//Content Negotiation : The way we can negotiate or specify the kind of data we want to send or 
	//receive 
	
	//By default produces both "application/json" and "application/xml"
	
	@RequestMapping(path="/aliens", produces={"application/json"})
	@ResponseBody
	//@ResponseBody is the annotation that is used to specify that the return type even if it is
	//a string it is not a web page, it is the body , So dispatcher servlet will not search 
	//it in the pages and rather send it as a whole.
	public List<Alien> getAllAliens() {
		return alienRepo.findAll();
	}
	
	
	//IF WE GIVE ONLY ONE PARAMETER THAT IS PATH BY DEFAULT
	
	//By changing to JPA Repository from Crud Repository we get the data 
	//response in json format by default
	//The Conversion of JAVA OBJECT -> JSON FORMAT is done by JACKSON-CORE JAR present in the dependenciess
	@GetMapping("alien/{aid}")
	public Optional<Alien> getAlienById(@PathVariable("aid") int aid) {
		return alienRepo.findById(aid);
	}
	
	@PostMapping("/alien")
	public Alien addAlienFromRestCall(Alien alien) {
		alienRepo.save(alien);
		return alien;
	}
	
	@DeleteMapping("/alien/aid")
	public String deleteAlien(@PathVariable("aid") int aid) {
		Alien a = alienRepo.getOne(aid);
		
		alienRepo.delete(a);
		
		return "deleted";
		
	}
	
	@PutMapping("/alien")
	public Alien updateOrCreate(Alien alien) {
		return alienRepo.save(alien);
	}

}
