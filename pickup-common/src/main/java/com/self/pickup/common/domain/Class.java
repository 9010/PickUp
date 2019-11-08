package com.self.pickup.common.domain;

import javax.persistence.*;

public class Class {
    /**
     * 班级ID
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 年级
     */
    private String grade;

    /**
     * 班级
     */
    @Column(name = "class_num")
    private String classNum;

    /**
     * 班主任ID
     */
    @Column(name = "teacher_id")
    private Integer teacherId;

    /**
     * 获取班级ID
     *
     * @return ID - 班级ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置班级ID
     *
     * @param id 班级ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取年级
     *
     * @return grade - 年级
     */
    public String getGrade() {
        return grade;
    }

    /**
     * 设置年级
     *
     * @param grade 年级
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }

    /**
     * 获取班级
     *
     * @return class_num - 班级
     */
    public String getClassNum() {
        return classNum;
    }

    /**
     * 设置班级
     *
     * @param classNum 班级
     */
    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }

    /**
     * 获取班主任ID
     *
     * @return teacher_id - 班主任ID
     */
    public Integer getTeacherId() {
        return teacherId;
    }

    /**
     * 设置班主任ID
     *
     * @param teacherId 班主任ID
     */
    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }
}