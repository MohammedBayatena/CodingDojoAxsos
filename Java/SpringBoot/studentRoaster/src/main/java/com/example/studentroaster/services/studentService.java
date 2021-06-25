package com.example.studentroaster.services;

import com.example.studentroaster.models.Student;
import com.example.studentroaster.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class studentService {

    private final StudentRepository studentrepo;

    public studentService(StudentRepository studentrepo) {
        this.studentrepo = studentrepo;
    }

    public Student CreateStudent(Student s) {
        studentrepo.save(s);
        return s;
    }


    public List<Student> getnotmapped() {

        return studentrepo.findAllNotMapped();

    }
    public List<Student> getAllStudents() {
        return studentrepo.findAll();
    }
}
