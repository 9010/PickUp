package com.self.pickup.provider.parent.domain;

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
     * 拥有账号的家长的账号
     */
    private String account;

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
     * 家庭ID
     */
    @Column(name = "family_id")
    private String familyId;

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
     * 获取拥有账号的家长的账号
     *
     * @return account - 拥有账号的家长的账号
     */
    public String getAccount() {
        return account;
    }

    /**
     * 设置拥有账号的家长的账号
     *
     * @param account 拥有账号的家长的账号
     */
    public void setAccount(String account) {
        this.account = account;
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
     * 获取家庭ID
     *
     * @return family_id - 家庭ID
     */
    public String getFamilyId() {
        return familyId;
    }

    /**
     * 设置家庭ID
     *
     * @param familyId 家庭ID
     */
    public void setFamilyId(String familyId) {
        this.familyId = familyId;
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

    /**
     * 空构造器
     */
    public Parent() {
    }

    /**
     * 创建家长
     * @param account
     * @param parentName
     * @param parentGender
     * @param address
     * @param relation
     * @param familyId
     * @param parentPhotoUrl
     */
    public Parent(String account, String parentName, Boolean parentGender, String address, Integer relation, String familyId, String parentPhotoUrl) {
        this.account = account;
        this.parentName = parentName;
        this.parentGender = parentGender;
        this.address = address;
        this.relation = relation;
        this.familyId = familyId;
        this.parentPhotoUrl = parentPhotoUrl;
    }
}