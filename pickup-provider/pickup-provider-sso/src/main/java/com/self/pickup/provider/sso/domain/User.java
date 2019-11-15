package com.self.pickup.provider.sso.domain;

import javax.persistence.*;

public class User {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 推送token
     */
    private String token;

    /**
     * 身份信息
     */
    @Column(name = "credit_id")
    private String creditId;

    /**
     * 家庭ID
     */
    @Column(name = "familyId")
    private String familyid;

    /**
     * 用户类型 0为家长 1为教师
     */
    private Boolean type;

    /**
     * 是否被注销 0代表未注销 1代表已注销
     */
    private Boolean removed;

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
     * 获取账号
     *
     * @return account - 账号
     */
    public String getAccount() {
        return account;
    }

    /**
     * 设置账号
     *
     * @param account 账号
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取推送token
     *
     * @return token - 推送token
     */
    public String getToken() {
        return token;
    }

    /**
     * 设置推送token
     *
     * @param token 推送token
     */
    public void setToken(String token) {
        this.token = token;
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
     * 获取家庭ID
     *
     * @return familyId - 家庭ID
     */
    public String getFamilyid() {
        return familyid;
    }

    /**
     * 设置家庭ID
     *
     * @param familyid 家庭ID
     */
    public void setFamilyid(String familyid) {
        this.familyid = familyid;
    }

    /**
     * 获取用户类型 0为家长 1为教师
     *
     * @return type - 用户类型 0为家长 1为教师
     */
    public Boolean getType() {
        return type;
    }

    /**
     * 设置用户类型 0为家长 1为教师
     *
     * @param type 用户类型 0为家长 1为教师
     */
    public void setType(Boolean type) {
        this.type = type;
    }

    /**
     * 获取是否被注销 0代表未注销 1代表已注销
     *
     * @return removed - 是否被注销 0代表未注销 1代表已注销
     */
    public Boolean getRemoved() {
        return removed;
    }

    /**
     * 设置是否被注销 0代表未注销 1代表已注销
     *
     * @param removed 是否被注销 0代表未注销 1代表已注销
     */
    public void setRemoved(Boolean removed) {
        this.removed = removed;
    }

    /**
     * 空构造器
     */
    public User() {
    }

    /**
     * 注册用构造器，类型为家长
     * @param account
     * @param password
     * @param creditId
     */
    public User(String account, String password, String creditId) {
        this.account = account;
        this.password = password;
        this.creditId = creditId;
        this.familyid = "";
        this.token = "";
        this.type = false;
        this.removed = false;
    }
}