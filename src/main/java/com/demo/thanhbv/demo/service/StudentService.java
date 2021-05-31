package com.demo.thanhbv.demo.service;

import com.demo.thanhbv.demo.entity.StudentEntity;
import com.demo.thanhbv.demo.model.BaseResponse;

import java.util.List;

public interface StudentService {
    List<StudentEntity> GetAll();

    List<StudentEntity> CreateStudentInfo(StudentEntity data);
    BaseResponse UpdateStudentInfo(StudentEntity data);
    BaseResponse DeleteStudentInfo(int id);
    StudentEntity FindByID(int id);
}
