package com.self.pickup.provider.student.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.self.pickup.common.dto.BaseResult;
import com.self.pickup.common.utils.MapperUtils;
import com.self.pickup.provider.student.domain.Student;
import com.self.pickup.provider.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping(value = "student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    /**
     * 根据学籍号获取学生的个人信息
     * @param jsonParam
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getPersonInfo", method = RequestMethod.POST)
    public String getPersonInfo(@RequestBody JSONObject jsonParam){
        String creditId = jsonParam.getString("creditId");

        Student student = null;
        // 从数据库中取出个人信息
        student = studentService.getInfoByCreditId(creditId);
        if(student == null){
            try {
                // 错误信息返回前端
                return MapperUtils.obj2json(BaseResult.notOk(Lists.newArrayList(
                        new BaseResult.Error("student", "该学生不存在"))));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            try {
                // 数据返回前端
                return MapperUtils.obj2json(BaseResult.ok(student)); // 返回给前端
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return "Exception!";
    }

    /**
     * 检查学籍号是否存在，注册时使用
     * @param creditId
     * @return
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
