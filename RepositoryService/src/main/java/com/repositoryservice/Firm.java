package com.repositoryservice;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="idp_firm")
public class Firm {

	@Id
	@Column(name="idp_firm_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int firmId;
	@Column(name = "idp_firm_name")
	private String firmName;
	@Column(name="idp_firm_createdate") 
	private LocalDateTime createDate;
	@Column(name="idp_firm_description")
	private String description;
	public Firm()
	{
		
	}
	
	public int getFirmId() {
		return firmId;
	}

	public String getFirmName() {
		return firmName;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public String getDescription() {
		return description;
	}

	public void setFirmId(int firmId) {
		this.firmId = firmId;
	}
	public void setFirmName(String firmName) {
		this.firmName = firmName;
	}
	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Firm [firmId=" + firmId + ", firmName=" + firmName + ", createDate=" + createDate + ", description="
				+ description + "]";
	}
	
	
}
