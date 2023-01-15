package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.NumberUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeRepository repository;

	@GetMapping("/emp/all")
	public ModelAndView getEmployee(ModelAndView mv) {
		List<Employee> employees=repository.findAll();
		mv.addObject("employees", employees);
		mv.setViewName("employee_list");
		return mv;
	}

	@GetMapping("/emp")
	public ModelAndView getEmployee(@RequestParam("empId") Integer empId){
		Optional<Employee> emp=repository.findById(empId);
		Employee employee=emp.get();
		ModelAndView mv=new ModelAndView();
		mv.setViewName("employee_edit");
		mv.addObject(employee);
		return mv;
	}

	@PutMapping("/emp/update")
	public String updateEmployee(@ModelAttribute("employee") Employee emp){
		repository.save(emp);
		return "redirect:/emp/all";
	}

	@DeleteMapping("emp/delete")
	@ResponseBody
	public String deleteEmployee(@RequestParam("empId") Integer empId){
		repository.deleteById(empId);
		return "redirect:/emp/all";
	}

	@GetMapping("emp/create")
	public ModelAndView renderCreateForm(){
		ModelAndView mv=new ModelAndView();
		Employee employee=new Employee();
		mv.addObject(employee);
		mv.setViewName("employee_create");
		return mv;
	}

	@PostMapping("emp/create")
	public String createEmployee(@ModelAttribute("employee") Employee emp){
		repository.save(emp);
		return "redirect:/emp/all";
	}
}
