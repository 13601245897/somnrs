package com.zhongyuguoji.www.entity;

import java.util.Date;

public class WxUser {
	private String id;

	private Date createTime;

	private String headImage;

	private String nickName;

	private String openId;

	private String sid;

	private String skey;

	private Date updateTime;

	private String popStatus;

	private Date updateUserInfoTime;

	private String headImageCir;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getHeadImage() {
		return headImage;
	}

	public void setHeadImage(String headImage) {
		this.headImage = headImage == null ? null : headImage.trim();
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName == null ? null : nickName.trim();
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId == null ? null : openId.trim();
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid == null ? null : sid.trim();
	}

	public String getSkey() {
		return skey;
	}

	public void setSkey(String skey) {
		this.skey = skey == null ? null : skey.trim();
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getPopStatus() {
		return popStatus;
	}

	public void setPopStatus(String popStatus) {
		this.popStatus = popStatus == null ? null : popStatus.trim();
	}

	public Date getUpdateUserInfoTime() {
		return updateUserInfoTime;
	}

	public void setUpdateUserInfoTime(Date updateUserInfoTime) {
		this.updateUserInfoTime = updateUserInfoTime;
	}

	public String getHeadImageCir() {
		return headImageCir;
	}

	public void setHeadImageCir(String headImageCir) {
		this.headImageCir = headImageCir == null ? null : headImageCir.trim();
	}
}