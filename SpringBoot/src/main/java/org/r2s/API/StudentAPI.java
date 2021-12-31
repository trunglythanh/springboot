package org.r2s.API;

import java.util.List;

import org.r2s.dto.StudentDto;
import org.r2s.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
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
	public void createStudent (@RequestBody StudentDto student) {
		service.createStudent(student);
	}
	
	@RequestMapping(value = "/students", method = RequestMethod.PUT)
	public void updateStudent (@RequestBody StudentDto student) {
		service.updateStudent(student);
	}
	@RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(name = "id")int id) {
		service.deleteStudent(id);
	}
	
	@RequestMapping("/students/findByStudentNumber/{studentNumber}")
	public StudentDto findByStudentNumber(@PathVariable(name = "studentNumber") String studentNumber) {
		return service.findByStudenNumber(studentNumber);		
	}

}
