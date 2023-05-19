package net.roozbe.demorest.service;

import net.roozbe.demorest.da.entity.Student;
import net.roozbe.demorest.da.repository.StudentRepository;
import net.roozbe.demorest.model.request.StudentRequestModel;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Student getStudent(long id) throws ChangeSetPersister.NotFoundException {
        Optional<Student> fetchedStudent = repository.findById(id);
        if(fetchedStudent.isPresent()){
            return fetchedStudent.get();
        }else {
            throw new ChangeSetPersister.NotFoundException();
        }
    }

    public long insertStudent(StudentRequestModel model) {
        Student student = new Student();
        student.setMame(model.getName());
        student.setFamily(model.getFamily());
        Student savedStudent = repository.save(student);
        return savedStudent.getId();
    }
}
