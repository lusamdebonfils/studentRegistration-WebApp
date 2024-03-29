package edu.mum.cs425.lab8.eregisterapplication.service.implementation;

import edu.mum.cs425.lab8.eregisterapplication.model.Student;
import edu.mum.cs425.lab8.eregisterapplication.repository.StudentRepository;
import edu.mum.cs425.lab8.eregisterapplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImplementation implements StudentService {

    @Autowired
    public StudentRepository studentRepo;

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll(Sort.by("firstName"));
    }

    @Override
    public Page<Student> getAllStudentsPaged(int pageNo) {
        return studentRepo.findAll(PageRequest.of(pageNo, 3, Sort.by("firstName")));
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public Student getStudentById(Long studentID) {
        return studentRepo.findById(studentID).orElse(null);
    }

    @Override
    public void deleteStudentById(Long studentID) {
        studentRepo.deleteById(studentID);
    }

    @Override
    public Page<Student> searchStudents(String str) {
        return studentRepo.findStudentByFirstNameContainsOrLastNameContainsOrMiddleNameContains(str,str,str);
    }
}
