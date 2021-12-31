package org.r2s.controller;

import javax.annotation.PostConstruct;

import org.r2s.dto.StudentDto;
import org.r2s.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {
	@Autowired
	private StudentService service;
	
	
	@RequestMapping(value = "/index")
	public String gotoLogin() {		
		return "index";
	}
	
	@RequestMapping(value = "//allAboutStudent")
	public String gotoAllAboutStudent() {		
		return "allAboutStudent";
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
	
	@PostConstruct
	public void initData() {
		System.out.println("__________Reset and init data________________");
		service.deleteAll();
		for (int i = 0; i < 100; i++) {
			service.createStudent(new StudentDto("Name" + i, "MALE", "R2S00"));
		}
	}
	
	
	@RequestMapping("/displayStudentList")
	  public ModelAndView listCustomer(
	      @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
	      @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
	      @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort) {
		ModelAndView mav = new ModelAndView();
		Sort sortable = null;
	    if (sort.equals("ASC")) {
	      sortable = Sort.by("id").ascending();
	    }
	    if (sort.equals("DESC")) {
	      sortable = Sort.by("id").descending();
	    }
	    Pageable pageable = PageRequest.of(page, size, sortable);
	    
	    mav.addObject("listStudentDto", service.findStudents(pageable));
	    mav.setViewName("studentList");
	    return mav;
	  }
	
}
