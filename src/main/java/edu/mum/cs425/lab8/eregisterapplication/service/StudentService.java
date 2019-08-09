package edu.mum.cs425.lab8.eregisterapplication.service;

import edu.mum.cs425.lab8.eregisterapplication.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface StudentService {
    public List<Student> getAllStudents();
    public abstract Page<Student> getAllStudentsPaged(int pageNo);
    public Student saveStudent(Student student);
    public Student getStudentById(Long studentID);
    public void deleteStudentById(Long studentID);
    public Page<Student> searchStudents(String str);
}
