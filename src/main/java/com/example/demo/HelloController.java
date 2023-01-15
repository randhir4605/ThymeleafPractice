package com.example.demo;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@GetMapping("/")
	public ModelAndView welcome() {
		String message = "Welcome to Thymeleaf tutorial !";
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/index");
		mv.addObject("message", message);
		mv.addObject("today",new Date());
		return mv;
	}

	@GetMapping("/user/{id}")
	public ModelAndView getUserById(@PathVariable Integer id) {
		User user = new User();
		user.setId(id);
		user.setName("Randhir");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/user-info");
		mv.addObject("user", user);
		return mv;
	}
}
