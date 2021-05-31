package com.demo.thanhbv.demo.service;

import com.demo.thanhbv.demo.entity.StudentEntity;
import com.demo.thanhbv.demo.model.BaseResponse;
import com.demo.thanhbv.demo.respository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceIplm implements StudentService {

    @Autowired
    StudentRepo studentRepo;

    @Override
    public List<StudentEntity> GetAll() {
        return studentRepo.findAll();
    }

    @Override
    public List<StudentEntity> CreateStudentInfo(StudentEntity data) {
        StudentEntity studentEntity = studentRepo.save(data);
        return studentRepo.findAll();
    }

    @Override
    public BaseResponse UpdateStudentInfo(StudentEntity data) {
        BaseResponse res = new BaseResponse();
        try{
            studentRepo.save(data);
            res.message = "Cập nhật thành công";


        }catch (Exception ex){
            res.status = 0;
            res.message = "Thất bại";
            return  res;
        }
        return res;
    }


    @Override
    public BaseResponse DeleteStudentInfo(int id) {
        BaseResponse res = new BaseResponse();
        try{
            StudentEntity data = FindByID(id);
            studentRepo.delete(data);
            res.message = "Xóa thành công!";
        }catch (Exception ex){
            res.status = 0;
            res.message = "Thất bại";
        }
        return  res;
    }

    @Override
    public StudentEntity FindByID(int id) {
        StudentEntity data = studentRepo.findById(id).get();
        return  data;
    }
}
