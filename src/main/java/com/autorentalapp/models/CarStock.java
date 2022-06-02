package com.autorentalapp.models;

import java.io.Serializable;

public class CarStock implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5558604925976262492L;
	
	private int id;
	private boolean available;
	private int cid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	
	@Override
	public String toString() {
		return "Car [id=" + id + ", available=" + available  + ", Car id=" + cid  + "]";
	}
	
}
