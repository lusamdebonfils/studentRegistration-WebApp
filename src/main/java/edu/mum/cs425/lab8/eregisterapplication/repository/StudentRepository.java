package edu.mum.cs425.lab8.eregisterapplication.repository;

import edu.mum.cs425.lab8.eregisterapplication.bean.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
