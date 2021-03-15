package com.project.User.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CompositePK implements Serializable{

	private int buyerId;
	private int prodId;
	
	public int getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}
	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	public CompositePK(int buyerId, int prodId) {
		super();
		this.buyerId = buyerId;
		this.prodId = prodId;
	}
	public CompositePK() {
		super();
	}
	
	
}
