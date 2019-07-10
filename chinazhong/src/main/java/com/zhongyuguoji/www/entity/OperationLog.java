package com.zhongyuguoji.www.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "operationLog")
public class OperationLog {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "name")
	private String name;
	@Column(name = "count")
	private Integer count;
	@Column(name = "integraml")
	private Integer integraml;
	@Column(name = "creationTime")
	private Long creationTime;
	@Column(name = "updateTime")
	private Long updateTime;

	public OperationLog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OperationLog(String name, Integer count, Integer integraml, Long creationTime, Long updateTime) {
		super();
		this.name = name;
		this.count = count;
		this.integraml = integraml;
		this.creationTime = creationTime;
		this.updateTime = updateTime;
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

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getIntegraml() {
		return integraml;
	}

	public void setIntegraml(Integer integraml) {
		this.integraml = integraml;
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
		return "OperationLog [id=" + id + ", name=" + name + ", count=" + count + ", integraml=" + integraml
				+ ", creationTime=" + creationTime + ", updateTime=" + updateTime + "]";
	}

}
