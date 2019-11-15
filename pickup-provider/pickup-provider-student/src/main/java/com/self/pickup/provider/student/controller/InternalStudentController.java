package com.self.pickup.provider.student.controller;

import com.self.pickup.provider.student.domain.Student;
import com.self.pickup.provider.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "exposure")
public class InternalStudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 设置家庭ID，注册时使用
     * @param creditId 学籍号
     * @param familyId 家庭ID
     * @return int
     */
    @ResponseBody
    @RequestMapping(value = "setFamilyID")
    public int setFamilyID(@RequestParam("creditId") String creditId,
                           @RequestParam("familyId") String familyId){
        Student student = null;
        student = studentService.getInfoByCreditId(creditId);

        // 学籍号出错
        if(student ==null){
            return 0;
        }
        else{
            // 更新familyId，并更新数据库
            student.setFamilyId(familyId);
            int success = studentService.updateByPrimaryKey(student);
            return success;
        }
    }

    /**
     * 检查学籍号是否存在，注册时使用
     * @param creditId 学籍号
     * @return boolean
     */
    @ResponseBody
    @RequestMapping(value = "checkCreditId")
    public boolean checkCreditId(@RequestParam("creditId") String creditId){
        Student student = null;
        student = studentService.getInfoByCreditId(creditId);

        if(student != null) return true;
        else return false;
    }
}
