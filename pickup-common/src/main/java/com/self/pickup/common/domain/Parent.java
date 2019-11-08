package com.self.pickup.common.domain;

import javax.persistence.*;

public class Parent {
    /**
     * 家长ID
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 拥有账号的家长的账号的ID
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 家长姓名
     */
    @Column(name = "parent_name")
    private String parentName;

    /**
     * 家长性别
     */
    @Column(name = "parent_gender")
    private Boolean parentGender;

    /**
     * 家庭住址
     */
    private String address;

    /**
     * 关系
     */
    private Integer relation;

    /**
     * 身份信息
     */
    @Column(name = "credit_id")
    private String creditId;

    /**
     * 家长头像图片url
     */
    @Column(name = "parent_photo_url")
    private String parentPhotoUrl;

    /**
     * 获取家长ID
     *
     * @return ID - 家长ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置家长ID
     *
     * @param id 家长ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取拥有账号的家长的账号的ID
     *
     * @return user_id - 拥有账号的家长的账号的ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置拥有账号的家长的账号的ID
     *
     * @param userId 拥有账号的家长的账号的ID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取家长姓名
     *
     * @return parent_name - 家长姓名
     */
    public String getParentName() {
        return parentName;
    }

    /**
     * 设置家长姓名
     *
     * @param parentName 家长姓名
     */
    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    /**
     * 获取家长性别
     *
     * @return parent_gender - 家长性别
     */
    public Boolean getParentGender() {
        return parentGender;
    }

    /**
     * 设置家长性别
     *
     * @param parentGender 家长性别
     */
    public void setParentGender(Boolean parentGender) {
        this.parentGender = parentGender;
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
     * 获取关系
     *
     * @return relation - 关系
     */
    public Integer getRelation() {
        return relation;
    }

    /**
     * 设置关系
     *
     * @param relation 关系
     */
    public void setRelation(Integer relation) {
        this.relation = relation;
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
     * 获取家长头像图片url
     *
     * @return parent_photo_url - 家长头像图片url
     */
    public String getParentPhotoUrl() {
        return parentPhotoUrl;
    }

    /**
     * 设置家长头像图片url
     *
     * @param parentPhotoUrl 家长头像图片url
     */
    public void setParentPhotoUrl(String parentPhotoUrl) {
        this.parentPhotoUrl = parentPhotoUrl;
    }
}