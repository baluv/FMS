package com.fms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "assets")
public class Assets implements java.io.Serializable {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "general_assetid")
	private int generalassetid;
	
	@Column(name = "item_name")
	private String itemName;
	
	@Column(name = "item_count")
	private int itemCount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGeneralassetid() {
		return generalassetid;
	}

	public void setGeneralassetid(int generalassetid) {
		this.generalassetid = generalassetid;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}
}
