package com.vistal.tech.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

public class VehicleDTO {
	
	private int vid;
	private String vendor;
	private String color;
	private String model;
	private List<FeaturesDTO> features = new ArrayList<FeaturesDTO>();
	private long price;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getVid() {
		return vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fvid", referencedColumnName = "vid")
	public List<FeaturesDTO> getFeatures() {
		return features;
	}

	public void setFeatures(List<FeaturesDTO> features) {
		this.features = features;
	}

	

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	
	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

}
