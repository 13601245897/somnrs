package com.fm.integral.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "memberSetting")
public class MemberSetting {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "name")
	private String name;
	// 上线
	@Column(name = "floorLevel")
	private Integer floorLevel;
	// 下限
	@Column(name = "upperLevel")
	private Integer upperLevel;

	@Column(name = "creationTime")
	private Long creationTime;

	@Column(name = "updateTime")
	private Long updateTime;

	public MemberSetting() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getFloorLevel() {
		return floorLevel;
	}

	public void setFloorLevel(Integer floorLevel) {
		this.floorLevel = floorLevel;
	}

	public Integer getUpperLevel() {
		return upperLevel;
	}

	public void setUpperLevel(Integer upperLevel) {
		this.upperLevel = upperLevel;
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
		return "MemberSetting [id=" + id + ", name=" + name + ", floorLevel=" + floorLevel + ", upperLevel="
				+ upperLevel + ", creationTime=" + creationTime + ", updateTime=" + updateTime + "]";
	}

}
