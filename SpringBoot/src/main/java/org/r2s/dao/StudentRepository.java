package org.r2s.dao;

import org.r2s.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

	@Query("select student from Student student where student.studentNumber = :studentNum")
	Student findByStudentNumber(@Param("studentNum") String studentNumber);

}
