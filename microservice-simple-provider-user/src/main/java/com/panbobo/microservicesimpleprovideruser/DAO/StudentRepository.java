package com.panbobo.microservicesimpleprovideruser.DAO;

import com.panbobo.microservicesimpleprovideruser.DO.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface StudentRepository extends JpaRepository<Student, Long> {
}