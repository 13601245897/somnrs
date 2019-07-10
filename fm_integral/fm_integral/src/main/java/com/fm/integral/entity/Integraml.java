package com.fm.integral.entity;

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
	// 积分上限
	@Column(name = "restrictive")
	private Integer restrictive;
	// 是否循环
	@Column(name = "circulation")
	private Integer circulation;
	@Column(name = "countTask")
	private Integer countTask;
	@Column(name = "creationTime")
	private Long creationTime;
	@Column(name = "updateTime")
	private Long updateTime;

	public Integraml() {
		super();
	}

	public Integraml(String name, Integer circulation, Integer restrictive, Integer countTask, Long creationTime,
			Long updateTime) {
		super();
		this.name = name;
		this.restrictive = restrictive;
		this.circulation = circulation;
		this.countTask = countTask;
		this.creationTime = creationTime;
		this.updateTime = updateTime;
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

	public Integer getRestrictive() {
		return restrictive;
	}

	public Integer getCirculation() {
		return circulation;
	}

	public void setCirculation(Integer circulation) {
		this.circulation = circulation;
	}

	public void setRestrictive(Integer restrictive) {
		this.restrictive = restrictive;
	}

	public Integer getCountTask() {
		return countTask;
	}

	public void setCountTask(Integer countTask) {
		this.countTask = countTask;
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
		return "Integraml [id=" + id + ", mId=" + mId + ", name=" + name + ", restrictive=" + restrictive
				+ ", circulation=" + circulation + ", countTask=" + countTask + ", creationTime=" + creationTime
				+ ", updateTime=" + updateTime + "]";
	}

}
