package org.r2s.dto;

public class StudentDto {

	private int id;
	private String name;
	private String gender;
	private String studentNumber;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	
	public StudentDto() {
	}
	public StudentDto(int id, String name, String gender, String studentNumber) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.studentNumber = studentNumber;
	}
	
	
	
	
	public StudentDto(String name, String gender, String studentNumber) {
		super();
		this.name = name;
		this.gender = gender;
		this.studentNumber = studentNumber;
	}
	@Override
	public boolean equals(Object obj) {
		StudentDto dto = (StudentDto) obj;
		return this.id == dto.id;
	}
	
}
