package com.demo.thanhbv.demo.respository;

import com.demo.thanhbv.demo.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<StudentEntity,Integer> {
}
