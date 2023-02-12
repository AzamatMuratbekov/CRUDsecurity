package com.peaksoft.Controller;

import com.peaksoft.entity.Teacher;
import com.peaksoft.service.CourseService;
import com.peaksoft.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("teachers")
public class    TeacherController {
    private final TeacherService teacherService;
    private final CourseService courseService;

    @Autowired
    public TeacherController(TeacherService teacherService, CourseService courseService) {
        this.teacherService = teacherService;
        this.courseService = courseService;
    }

    @GetMapping
    public String student(Model model) {
        model.addAttribute("teachers", teacherService.getAllTeacher());
        return "teacher/teachers";
    }

    @GetMapping("/addTeacher")
    public String add(Model model) {
        model.addAttribute("teacher", new Teacher());
        model.addAttribute("courses", courseService.getAllCourse());
        return "teacher/addTeacher";
    }

    @PostMapping("/saveTeacher")
    public String save(@ModelAttribute("teacher") Teacher teacher) {
        teacherService.addTeacher(teacher, teacher.getCourseId());
        return "redirect:/teachers";
    }

    @GetMapping("/students/{id}")
    public String getStudents(@PathVariable("id") Long id, Model model) {
        Long count = teacherService.getStudentsByTeacherId(id);
        model.addAttribute("count", count);
        return "teacher/students";
    }
}