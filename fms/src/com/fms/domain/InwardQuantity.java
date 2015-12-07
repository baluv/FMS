package com.fms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="inward_quantity")

public class InwardQuantity {

	@Id
	@GeneratedValue
	@Column(name="id")
	public int id ;
	
	@Column(name="inward_id")
	public int inwardid;
	
	@Column(name="item_name")
	public String itemname;
	
	@Column(name="quantity")
	public int quantity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getInwardid() {
		return inwardid;
	}

	public void setInwardid(int inwardid) {
		this.inwardid = inwardid;
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
