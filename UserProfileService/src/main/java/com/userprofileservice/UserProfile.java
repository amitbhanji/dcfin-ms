package com.userprofileservice;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="idp_user_profile")
public class UserProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idp_user_profile_id")
	private int userProfileId;
	@Column (name="idp_user_profile_description") 
	private String description;
	@Column(name="idp_user_profile_createdate")
	private LocalDateTime createDate;
	@Column(name="idp_user_profile_name")
	private String profileName;
	
	public UserProfile()
	{
		
	}
	
	public UserProfile(int id)
	{
		this.userProfileId=id;
	}
	
	public int getUserProfileId() {
		return userProfileId;
	}
	public String getDescription() {
		return description;
	}
	public LocalDateTime getCreateDate() {
		return createDate;
	}
	public String getProfileName() {
		return profileName;
	}



	public void setUserProfileId(int userProfileId) {
		this.userProfileId = userProfileId;
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



	@Override
	public String toString() {
		return "UserProfile [userProfileId=" + userProfileId + ", description=" + description + ", createDate="
				+ createDate + ", profileName=" + profileName + "]";
	}
	
	
}
