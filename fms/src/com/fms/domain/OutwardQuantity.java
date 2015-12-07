package com.fms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="outward_quantity")

public class OutwardQuantity {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="outward_id")
	private int outwardid;
	
	@Column(name="item_name")
	private String itemname;
	
	@Column(name="quantity")
	private int quantity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOutwardid() {
		return outwardid;
	}

	public void setOutwardid(int outwardid) {
		this.outwardid = outwardid;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
