package org.r2s.API;

import java.util.List;

import org.r2s.dto.StudentDto;
import org.r2s.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentAPI {
	@Autowired
	private StudentService service;
	
	@RequestMapping("/students")
	public List<StudentDto> getStudents( ) {
		return service.getStudents();
	}
	
	@RequestMapping("/students/{id}")
	public StudentDto findById(@PathVariable(name = "id") int id) {
		return service.findById(id);
	}
	
	@RequestMapping(value = "/students", method = RequestMethod.POST)
	public HttpStatus createStudent (@RequestBody StudentDto student) {
		service.createStudent(student);
		return HttpStatus.CREATED;
	}
	
	@RequestMapping(value = "/students", method = RequestMethod.PUT)
	public HttpStatus updateStudent (@RequestBody StudentDto student) {
		service.updateStudent(student);
		return HttpStatus.OK;
	}
	@RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)
	public HttpStatus delete(@PathVariable(name = "id")int id) {
		service.deleteStudent(id);
		return HttpStatus.OK;
	}
	
	@RequestMapping("/students/findByStudentNumber/{studentNumber}")
	public StudentDto findByStudentNumber(@PathVariable(name = "studentNumber") String studentNumber) {
		return service.findByStudenNumber(studentNumber);		
	}

}
