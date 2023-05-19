package net.roozbe.demorest.controller;

import net.roozbe.demorest.da.entity.Student;
import net.roozbe.demorest.model.request.StudentRequestModel;
import net.roozbe.demorest.service.StudentService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Student fetchStudentById(@PathVariable String id) throws ChangeSetPersister.NotFoundException {
        return service.getStudent(Long.parseLong(id));
    }

    @PostMapping()
    public long createStudent(@RequestBody StudentRequestModel model){
        return service.insertStudent(model);
    }
}
