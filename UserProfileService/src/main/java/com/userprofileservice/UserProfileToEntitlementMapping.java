package com.userprofileservice;

import java.time.LocalDateTime;
import java.util.List;

public class UserProfileToEntitlementMapping {

	private List<Integer> entIds;
	
	private String description;
	private LocalDateTime createDate;
	private String profileName;

	public String getDescription() {
		return description;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public String getProfileName() {
		return profileName;
	}

	public List<Integer> getEntIds() {
		return entIds;
	}

	

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public void setEntIds(List<Integer> entIds) {
		this.entIds = entIds;
	}

	public UserProfileToEntitlementMapping()
	{
		
	}
	
	
}
