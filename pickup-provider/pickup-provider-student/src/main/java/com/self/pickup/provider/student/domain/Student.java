package com.self.pickup.provider.student.domain;

import javax.persistence.*;

public class Student {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 学生姓名
     */
    @Column(name = "student_name")
    private String studentName;

    /**
     * 班级ID
     */
    @Column(name = "class_id")
    private Integer classId;

    /**
     * 身份信息
     */
    @Column(name = "credit_id")
    private String creditId;

    /**
     * 性别 0代表女 1代表男
     */
    private Boolean gender;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 家庭住址
     */
    private String address;

    /**
     * 学校ID
     */
    @Column(name = "school_id")
    private String schoolId;

    /**
     * 学生头像图片url
     */
    @Column(name = "student_pic_url")
    private String studentPicUrl;

    /**
     * @return ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取学生姓名
     *
     * @return student_name - 学生姓名
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * 设置学生姓名
     *
     * @param studentName 学生姓名
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * 获取班级ID
     *
     * @return class_id - 班级ID
     */
    public Integer getClassId() {
        return classId;
    }

    /**
     * 设置班级ID
     *
     * @param classId 班级ID
     */
    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    /**
     * 获取身份信息
     *
     * @return credit_id - 身份信息
     */
    public String getCreditId() {
        return creditId;
    }

    /**
     * 设置身份信息
     *
     * @param creditId 身份信息
     */
    public void setCreditId(String creditId) {
        this.creditId = creditId;
    }

    /**
     * 获取性别 0代表女 1代表男
     *
     * @return gender - 性别 0代表女 1代表男
     */
    public Boolean getGender() {
        return gender;
    }

    /**
     * 设置性别 0代表女 1代表男
     *
     * @param gender 性别 0代表女 1代表男
     */
    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    /**
     * 获取手机号
     *
     * @return phone - 手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号
     *
     * @param phone 手机号
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取家庭住址
     *
     * @return address - 家庭住址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置家庭住址
     *
     * @param address 家庭住址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取学校ID
     *
     * @return school_id - 学校ID
     */
    public String getSchoolId() {
        return schoolId;
    }

    /**
     * 设置学校ID
     *
     * @param schoolId 学校ID
     */
    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    /**
     * 获取学生头像图片url
     *
     * @return student_pic_url - 学生头像图片url
     */
    public String getStudentPicUrl() {
        return studentPicUrl;
    }

    /**
     * 设置学生头像图片url
     *
     * @param studentPicUrl 学生头像图片url
     */
    public void setStudentPicUrl(String studentPicUrl) {
        this.studentPicUrl = studentPicUrl;
    }
}