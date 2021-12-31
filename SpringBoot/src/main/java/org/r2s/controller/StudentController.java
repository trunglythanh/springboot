package org.r2s.controller;

import org.r2s.dto.StudentDto;
import org.r2s.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {
	@Autowired
	private StudentService service;
	
	
	@RequestMapping(value = "/index")
	public String gotoLogin() {		
		return "index";
	}
	
	@RequestMapping(value = "/displayStudentForm")
	public ModelAndView displayStudentForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("studentForm");
		mav.addObject("studentDto", new StudentDto());
		return mav;
	}
	
	
	@RequestMapping(value = "/displayStudentInfo", method = RequestMethod.POST)
	public ModelAndView displayStudentInfo(@ModelAttribute (name = "studentDto") StudentDto studentDto) {
		service.createStudent(studentDto);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("displayStudent");
		return mav;
	}
	
	
	
}
