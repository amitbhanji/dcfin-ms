package com.repository.data;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="idp_entitlement_user_profiles")
public class EntitlementToUserProfile {

	@Id
	@Column(name="idp_entitlement_user_profile_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int entitlementToUserProfileId;
	@Column(name="idp_entitlement_user_profile_description")
	private String description;
	@Column(name="idp_entitlement_user_profile_entitlement_id")
	private int entitlementId;

	@Column(name="idp_entitlement_user_profile_userprofile_id")
	private int userProfileId;

	
	@Column(name="idp_entitlement_user_profile_create_date")
	private LocalDateTime userProfileCreateDate;
	
	public EntitlementToUserProfile()
	{
		
	}
	public int getEntitlementToUserProfileId() {
		return entitlementToUserProfileId;
	}

	public String getDescription() {
		return description;
	}

	public int getEntitlementId() {
		return entitlementId;
	}

	public int getUserProfileId() {
		return userProfileId;
	}

	public LocalDateTime getUserProfileCreateDate() {
		return userProfileCreateDate;
	}



	public void setEntitlementToUserProfileId(int entitlementToUserProfileId) {
		this.entitlementToUserProfileId = entitlementToUserProfileId;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setEntitlementId(int entitlementId) {
		this.entitlementId = entitlementId;
	}

	public void setUserProfileId(int userProfileId) {
		this.userProfileId = userProfileId;
	}

	public void setUserProfileCreateDate(LocalDateTime userProfileCreateDate) {
		this.userProfileCreateDate = userProfileCreateDate;
	}


	
}
