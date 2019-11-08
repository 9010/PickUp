package com.self.pickup.common.domain;

import javax.persistence.*;

public class Family {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 家庭ID
     */
    @Column(name = "family_id")
    private Integer familyId;

    /**
     * 家庭成员ID
     */
    @Column(name = "member_id")
    private Integer memberId;

    /**
     * 类型 1代表学生 2代表家长
     */
    @Column(name = "TYPE")
    private Integer type;

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
     * 获取家庭ID
     *
     * @return family_id - 家庭ID
     */
    public Integer getFamilyId() {
        return familyId;
    }

    /**
     * 设置家庭ID
     *
     * @param familyId 家庭ID
     */
    public void setFamilyId(Integer familyId) {
        this.familyId = familyId;
    }

    /**
     * 获取家庭成员ID
     *
     * @return member_id - 家庭成员ID
     */
    public Integer getMemberId() {
        return memberId;
    }

    /**
     * 设置家庭成员ID
     *
     * @param memberId 家庭成员ID
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    /**
     * 获取类型 1代表学生 2代表家长
     *
     * @return TYPE - 类型 1代表学生 2代表家长
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置类型 1代表学生 2代表家长
     *
     * @param type 类型 1代表学生 2代表家长
     */
    public void setType(Integer type) {
        this.type = type;
    }
}