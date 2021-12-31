package org.r2s.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.r2s.dao.StudentRepository;
import org.r2s.dto.StudentDto;
import org.r2s.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	@Autowired	
	private StudentRepository repo;	

	public List<StudentDto> getStudents() {
		List<Student> students = repo.findAll();
		List<StudentDto> dtos = new ArrayList<StudentDto>();
		students.forEach(student -> dtos.add(convertToDto(student)));
		return dtos;
	}

	private StudentDto convertToDto(Student student) {
		StudentDto dto = new StudentDto();
		dto.setId(student.getId());
		dto.setGender(student.getGender());
		dto.setName(student.getName());
		dto.setStudentNumber(student.getStudentNumber());
		return dto;
	}

	public StudentDto findById(int id) {
		Optional<Student> optionalStudent = repo.findById(id);
		if (optionalStudent.isPresent()) {
			return convertToDto(optionalStudent.get());
		} else {
			return null;
		}
		
		 
	}

	public void createStudent(StudentDto studentDto) {
		Student student = convertToEntity(studentDto);
		repo.save(student);
	}

	private Student convertToEntity(StudentDto studentDto) {
		Student student = new Student();
		student.setGender(studentDto.getGender());
		student.setName(studentDto.getName());
		student.setStudentNumber(studentDto.getStudentNumber());
		return student;
	}

	public void updateStudent(StudentDto studentDto) {
		Optional<Student> optionalStudent = repo.findById(studentDto.getId());
		if (optionalStudent.isPresent()) {
			Student student = optionalStudent.get();
			student.setGender(studentDto.getGender());
			student.setName(studentDto.getName());
			student.setStudentNumber(studentDto.getStudentNumber());
			repo.saveAndFlush(student);
		} 		
	}

	public void deleteStudent(int id) {
		repo.deleteById(id);
		 
	}

	public StudentDto findByStudenNumber(String studentNumber) {
		Student student = repo.findByStudentNumber(studentNumber);
		if (student != null)
			return convertToDto(student);
		else
			return null;
	}

	public void deleteAll() {
		repo.deleteAll();
	}

	public List<StudentDto> findStudents(Pageable pageable) {
		List<Student> students = repo.findStudents(pageable);		
		List<StudentDto> dtos = new ArrayList<StudentDto>();
		students.forEach(student -> dtos.add(convertToDto(student)));
		return dtos;
	}

}
