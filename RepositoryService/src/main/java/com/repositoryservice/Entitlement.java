package com.repositoryservice;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="idp_entitlement")
public class Entitlement {

	@Id
	@Column(name="idp_entitlement_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int entitlementId;
	@Column(name="idp_entitlement_name")
	private String entitlementName;
	@Column(name="idp_entitlement_description") 
	private String entitlementDescription;
	@Column(name="idp_entitlement_create_date")
	private LocalDateTime createDateTime;
	
	
	public Entitlement()
	{
		
	}
	public int getEntitlementId() {
		return entitlementId;
	}
	public String getEntitlementName() {
		return entitlementName;
	}
	public String getEntitlementDescription() {
		return entitlementDescription;
	}
	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}
	public void setEntitlementId(int entitlementId) {
		this.entitlementId = entitlementId;
	}
	public void setEntitlementName(String entitlementName) {
		this.entitlementName = entitlementName;
	}
	public void setEntitlementDescription(String entitlementDescription) {
		this.entitlementDescription = entitlementDescription;
	}
	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}
	@Override
	public String toString() {
		return "Entitlement [entitlementId=" + entitlementId + ", entitlementName=" + entitlementName
				+ ", entitlementDescription=" + entitlementDescription + ", createDateTime=" + createDateTime + "]";
	}
	
	
}
