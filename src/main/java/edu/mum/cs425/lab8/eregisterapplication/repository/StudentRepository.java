package edu.mum.cs425.lab8.eregisterapplication.repository;

import edu.mum.cs425.lab8.eregisterapplication.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    public Page<Student> findStudentByFirstNameContainsOrLastNameContainsOrMiddleNameContains(String firstName, String lastName, String middleName);
}
