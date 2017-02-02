package com.pgw.pojo;

public class MidUserBuss {
	private String usercode;
	private MidUser miduser;
	private String taskcode;
	private String remark;
	private String flag;

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	public MidUser getMiduser() {
		return miduser;
	}

	public void setMiduser(MidUser miduser) {
		this.miduser = miduser;
	}

	public String getFlag() {
		return flag;
	}

	public String getTaskcode() {
		return taskcode;
	}

	public void setTaskcode(String taskcode) {
		this.taskcode = taskcode;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
}
