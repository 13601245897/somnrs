package com.zhongyuguoji.www.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "integraml")
public class Integraml {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer id;
	@Column(name = "mId")
	private Integer mId;
	@Column(name = "name")
	private String name;
	@Column(name = "countDay")
	private Integer countDay;
	@Column(name = "countNew")
	private Integer countNew;
	@Column(name = "creationTime")
	private Long creationTime;
	@Column(name = "updateTime")
	private Long updateTime;

	public Integraml() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getmId() {
		return mId;
	}

	public void setmId(Integer mId) {
		this.mId = mId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCountDay() {
		return countDay;
	}

	public void setCountDay(Integer countDay) {
		this.countDay = countDay;
	}

	public Integer getCountNew() {
		return countNew;
	}

	public void setCountNew(Integer countNew) {
		this.countNew = countNew;
	}

	public Long getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Long creationTime) {
		this.creationTime = creationTime;
	}

	public Long getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Long updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "Integraml [id=" + id + ", mId=" + mId + ", name=" + name + ", countDay=" + countDay + ", countNew="
				+ countNew + ", creationTime=" + creationTime + ", updateTime=" + updateTime + "]";
	}

}
