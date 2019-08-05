package edu.mum.cs425.lab8.eregisterapplication.controller;

import edu.mum.cs425.lab8.eregisterapplication.model.Student;
import edu.mum.cs425.lab8.eregisterapplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;


    @GetMapping(value = {"eregister/students"})
    public ModelAndView listStudents(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("students",studentService.getAllStudents());
        modelAndView.setViewName("student/list");
        return modelAndView;
    }

    @GetMapping(value = {"/eregister/student/new"})
    public String displayNewStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "student/add";
    }

    @PostMapping(value = {"/eregister/student/new"})
    public String addNewStudent(@Valid @ModelAttribute("student") Student student,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "student/add";
        }
        student = studentService.saveStudent(student);
        return "redirect:/eregister/students";
    }

    @GetMapping(value = {"/eregister/student/delete/{studentId}"})
    public String deleteStudent(@PathVariable Long studentId, Model model) {
        studentService.deleteStudentById(studentId);
        return "redirect:/eregister/students";
    }

    @GetMapping(value = {"/eregister/student/edit/{studentId}"})
    public String editStudent(@PathVariable Long studentId, Model model) {
        Student student = studentService.getStudentById(studentId);
        if (student != null) {
            model.addAttribute("student", student);
            return "student/edit";
        }
        return "redirect:/eregister/students";
    }

    @PostMapping(value = {"/eregister/student/edit"})
    public String updateStudent(@Valid @ModelAttribute("student") Student student,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "student/edit";
        }
        student = studentService.saveStudent(student);
        return "redirect:/eregister/students";
    }

    @GetMapping(value = "/eregister/student/search")
    public ModelAndView searchResults(@RequestParam("searchCriteria") String searchCriteria){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("students",studentService.searchStudents(searchCriteria));
        modelAndView.setViewName("student/list");
        return modelAndView;
    }
//    public ModelAndView listStudents(){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("students",studentService.getAllStudents());
//        modelAndView.setViewName("student/list");
//        return modelAndView;
//    }


}
