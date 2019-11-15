package com.self.pickup.provider.family.domain;

import javax.persistence.*;

public class Family {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 账号
     */
    private String account;

    /**
     * 家庭ID
     */
    @Column(name = "familyId")
    private String familyid;

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
}