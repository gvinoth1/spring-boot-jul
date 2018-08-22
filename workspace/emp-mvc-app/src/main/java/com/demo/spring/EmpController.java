package com.demo.spring;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.spring.entity.Emp;

@Controller
public class EmpController {

	@Autowired
	EmpRepository repo;
	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public String getPage() {
		return "registerEmp";
	}

	@RequestMapping(path = "/store", method = RequestMethod.POST)
	public ModelAndView storeEmp(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("city") String city, @RequestParam("salary") double salary) {

		ModelAndView mv = new ModelAndView();
		
		Optional<Emp> o=repo.findById(id);
		//Emp e1=o.get();
		if (!o.isPresent()) {
			Emp e=repo.save(new Emp(id, name, city, salary));
			mv.addObject("emp", e);
			mv.setViewName("success");
		} else {
			mv.addObject("error", "Employee Could Not be Stored");
			mv.setViewName("failure");
		}
			return mv;
	}
}
