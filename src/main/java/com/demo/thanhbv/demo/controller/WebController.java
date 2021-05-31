package com.demo.thanhbv.demo.controller;

import com.demo.thanhbv.demo.entity.StudentEntity;
import com.demo.thanhbv.demo.model.BaseResponse;
import com.demo.thanhbv.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class WebController {
    @Autowired
    StudentService studentService;

    @GetMapping({"/admin/","/admin","/admin/index"})
    public String index(Model model){

        List<StudentEntity> data = studentService.GetAll();
        model.addAttribute("data", data);
        return "index";
    }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody StudentEntity input){
        BaseResponse res = new BaseResponse();
        try{
            studentService.CreateStudentInfo(input);
            res.status = 1;
            res.message = "Thêm mới thành công!";
            return  ResponseEntity.ok(res);
        }catch(Exception e){
            res.status = 0;
            res.message = "Có lỗi xảy ra với mã lỗi : " + res.toString();
            return  ResponseEntity.ok(res);
        }
    }

    @PostMapping("/update")
    public  ResponseEntity update(@RequestBody StudentEntity input){
        return  ResponseEntity.ok(studentService.UpdateStudentInfo(input));
    }

    @PostMapping("/delete")
    public ResponseEntity delete(@RequestParam int id){
       return ResponseEntity.ok(studentService.DeleteStudentInfo(id));
    }
}
