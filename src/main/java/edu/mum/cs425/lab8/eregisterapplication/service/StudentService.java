package edu.mum.cs425.lab8.eregisterapplication.service;

import edu.mum.cs425.lab8.eregisterapplication.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    public List<Student> getAllStudents();
    public Student saveBook(Student student);
    public Student getStudentById(Long studentID);
    public void deleteStudentById(Long studentID);
}
