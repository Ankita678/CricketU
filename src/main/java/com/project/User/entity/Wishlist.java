package com.project.User.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="wishlist")
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(CompositePK.class)
public class Wishlist {
	
	@Id
	@Column(name="BUYERID")
	private int buyerId;
	@Id
	@Column(name="PRODID")
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
}
