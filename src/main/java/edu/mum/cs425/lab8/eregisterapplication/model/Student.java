package edu.mum.cs425.lab8.eregisterapplication.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue
    private Long studentId;
    @Column(nullable = false, unique = true)
    private Long studentNumber;
    @Column(nullable = false)
    private String firstName;
    private String middleName;
    @Column(nullable = false)
    private String lastName;
    private Double cgpa;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate enrollmentDate;
    @Column(nullable = false)
    private Boolean isInternational;

    public Student() {
        super();
    }

    public Student(Long studentNumber, String firstName, String middleName, String lastName, Double cgpa, LocalDate enrollmentDate, Boolean isInternational) {
        super();
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.enrollmentDate = enrollmentDate;
        this.isInternational = isInternational;
    }

    public Student(Long studentNumber, String firstName, String lastName, LocalDate enrollmentDate, Boolean isInternational) {
        super();
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.enrollmentDate = enrollmentDate;
        this.isInternational = isInternational;
    }

    public Long getStudentId() {
        return studentId;
    }

    public Long getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(Long studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getCgpa() {
        return cgpa;
    }

    public void setCgpa(Double cgpa) {
        this.cgpa = cgpa;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public Boolean getIsInternational() {
        return isInternational;
    }

    public void setIsInternational(Boolean international) {
        isInternational = international;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentNumber=" + studentNumber +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cgpa=" + cgpa +
                ", enrollmentDate=" + enrollmentDate +
                ", isInternational=" + isInternational +
                '}';
    }
}
