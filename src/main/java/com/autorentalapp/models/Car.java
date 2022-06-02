package com.autorentalapp.models;

import java.io.Serializable;

public class Car implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -198296048764284282L;
	
	
	private int cid;
	private String modelNo;
	private String carmaker;
	private String color;
	private String registration;
//	private String image;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getModelNo() {
		return modelNo;
	}
	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}
	public String getCarmaker() {
		return carmaker;
	}
	public void setCarmaker(String carmaker) {
		this.carmaker = carmaker;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getRegistration() {
		return registration;
	}
	public void setRegistration(String registration) {
		this.registration = registration;
	}
//	public String getImage() {
//		return image;
//	}
//	public void setImage(String image) {
//		this.image = image;
//	}
	@Override
	public String toString() {
		return "Car [id=" + cid + ", model NO=" + modelNo  + ", car Maker=" + carmaker  + ", color=" + color + ", "
				+ "registration=" + registration  + "]";
	}
	
}
