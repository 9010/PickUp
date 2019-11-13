package com.self.pickup.provider.student.service.impl;

import com.self.pickup.common.myMapper.MyMapper;
import com.self.pickup.common.service.impl.BaseServiceImpl;
import com.self.pickup.provider.student.domain.Student;
import com.self.pickup.provider.student.mapper.StudentMapper;
import com.self.pickup.provider.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

@Service
public class StudentServiceImpl extends BaseServiceImpl<Student, Integer> implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public MyMapper<Student> getMapper() {
        return studentMapper;
    }

    /**
     * 根据学籍号获取学生个人信息
     * @param creditId
     * @return
     */
    @Override
    public Student getInfoByCreditId(String creditId) {
        Student student = null;
        System.out.println(creditId + "==================");
        // 从数据库中找到数据
        Example example = new Example(Student.class);
        example.createCriteria().andEqualTo("creditId", creditId);
        student = studentMapper.selectOneByExample(example);

        return student;
    }
}
