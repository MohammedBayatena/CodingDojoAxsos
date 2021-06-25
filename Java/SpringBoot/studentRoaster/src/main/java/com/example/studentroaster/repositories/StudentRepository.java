package com.example.studentroaster.repositories;

import com.example.studentroaster.models.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

    List<Student> findAll();

    Optional<Student> getStudentById(Long id);

    @Query(value = "select * from students as s where s.id not in (select student_id from contacts)",
            nativeQuery = true)
    List<Student> findAllNotMapped();
}
