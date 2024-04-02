package com.vistal.tech.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="features")
public class Features {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int fid;
	@Column(unique = true)
	private String title;
	
	private Timestamp doe;
	private Timestamp dom;

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Timestamp getDoe() {
		return doe;
	}

	public void setDoe(Timestamp doe) {
		this.doe = doe;
	}

	public Timestamp getDom() {
		return dom;
	}

	public void setDom(Timestamp dom) {
		this.dom = dom;
	}



}
