package com.pbb.microserviceprovideruser.DAO;

import com.pbb.microserviceprovideruser.DO.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface StudentRepository extends JpaRepository<Student, Long> {
}
