package com.pgw.pojo;

import java.util.Date;
import java.util.List;

public class MidUser {
	private List<MidUserBuss> midUserBusses = null;

	private String usercode;

    private String username;

    private String comcode;

    private String password;

    private String sex;

    private Date birthday;

    private String headship;

    private String telephone;

    private String mobile;

    private String email;

    private String validstatus;

    private Integer sendcount;

    private Integer limitcount;

    private String remark;

    private String flag;

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode == null ? null : usercode.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getComcode() {
        return comcode;
    }

    public void setComcode(String comcode) {
        this.comcode = comcode == null ? null : comcode.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getHeadship() {
        return headship;
    }

    public void setHeadship(String headship) {
        this.headship = headship == null ? null : headship.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getValidstatus() {
        return validstatus;
    }

    public void setValidstatus(String validstatus) {
        this.validstatus = validstatus == null ? null : validstatus.trim();
    }

    public Integer getSendcount() {
        return sendcount;
    }

    public void setSendcount(Integer sendcount) {
        this.sendcount = sendcount;
    }

    public Integer getLimitcount() {
        return limitcount;
    }

    public void setLimitcount(Integer limitcount) {
        this.limitcount = limitcount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

	public List<MidUserBuss> getMidUserBusses() {
		return midUserBusses;
	}

	public void setMidUserBusses(List<MidUserBuss> midUserBusses) {
		this.midUserBusses = midUserBusses;
	}
}