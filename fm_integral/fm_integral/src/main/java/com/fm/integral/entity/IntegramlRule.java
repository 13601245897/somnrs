package com.fm.integral.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "integramlRule")
public class IntegramlRule {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "name")
	private String name;
	//积分值
	@Column(name = ("integraml"))
	private Integer integraml;
	//是否循环
	@Column(name = "circulation")
	private Integer circulation;
	//积分上限
	@Column(name = "restrictive")
	private Integer restrictive;
	@Column(name = "integramlUrl")
	private String integramlUrl;
	@Column(name = "updateTime")
	private Long updateTime;
	@Column(name = "creationTime")
	private Long creationTime;

	public IntegramlRule() {
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

	public Integer getIntegraml() {
		return integraml;
	}

	public void setIntegraml(Integer integraml) {
		this.integraml = integraml;
	}


	public Integer getCirculation() {
		return circulation;
	}

	public void setCirculation(Integer circulation) {
		this.circulation = circulation;
	}

	public Integer getRestrictive() {
		return restrictive;
	}

	public void setRestrictive(Integer restrictive) {
		this.restrictive = restrictive;
	}

	public String getIntegramlUrl() {
		return integramlUrl;
	}

	public void setIntegramlUrl(String integramlUrl) {
		this.integramlUrl = integramlUrl;
	}

	public Long getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Long updateTime) {
		this.updateTime = updateTime;
	}

	public Long getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Long creationTime) {
		this.creationTime = creationTime;
	}

	@Override
	public String toString() {
		return "IntegramlRule [id=" + id + ", name=" + name + ", integraml=" + integraml + ", circulation="
				+ circulation + ", restrictive=" + restrictive + ", integramlUrl=" + integramlUrl + ", updateTime="
				+ updateTime + ", creationTime=" + creationTime + "]";
	}


}
