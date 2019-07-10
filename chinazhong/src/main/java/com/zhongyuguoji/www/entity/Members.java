package com.zhongyuguoji.www.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "members")
public class Members {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer id;
	@Column(name = "name")
	private String name;
	@Column(name = "grade")
	private String grade;
	@Column(name = "total")
	private Integer total;
	@Column(name = "phone")
	private Long phone;
	@Column(name = "totalCount")
	private Integer totalCount;
	@Column(name = "totalCountNew")
	private Integer totalCountNew;
	@Column(name = "creationTime")
	private Long creationTime;
	@Column(name = "updateTime")
	private Long updateTime;

	public Members() {
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

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getTotalCountNew() {
		return totalCountNew;
	}

	public void setTotalCountNew(Integer totalCountNew) {
		this.totalCountNew = totalCountNew;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
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
		return "Members [id=" + id + ", name=" + name + ", grade=" + grade + ", total=" + total + ", phone=" + phone
				+ ", totalCount=" + totalCount + ", totalCountNew=" + totalCountNew + ", creationTime=" + creationTime
				+ ", updateTime=" + updateTime + "]";
	}

}
