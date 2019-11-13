package com.self.pickup.provider.student.service;

import com.self.pickup.common.service.BaseService;
import com.self.pickup.provider.student.domain.Student;

public interface StudentService extends BaseService<Student, Integer> {
    /**
     * 根据学籍号获取学生个人信息
     * @param creditId
     * @return
     */
    public Student getInfoByCreditId(String creditId);
}
