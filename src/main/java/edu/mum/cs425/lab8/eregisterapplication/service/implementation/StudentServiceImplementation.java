package edu.mum.cs425.lab8.eregisterapplication.service.implementation;

import edu.mum.cs425.lab8.eregisterapplication.model.Student;
import edu.mum.cs425.lab8.eregisterapplication.repository.StudentRepository;
import edu.mum.cs425.lab8.eregisterapplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImplementation implements StudentService {

    @Autowired
    public StudentRepository studentRepo;

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Student saveBook(Student student) {
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
}
