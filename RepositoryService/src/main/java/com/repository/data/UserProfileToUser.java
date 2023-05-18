package com.repository.data;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="idp_user_profile_user")
public class UserProfileToUser {

	@Id
	@Column(name="idp_user_profile_user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userProfileToUserId;
	@Column(name="idp_user_profile_user_description")
	private String profileDescription;
	@Column(name="idp_user_profile_user_profileid")
	private int userProfileId;
	@Column(name="idp_user_profile_user_userid")
	private int userId;
	@Column(name= "idp_user_profile_user_createdate") 
	private LocalDateTime createDateTime;
	@Column(name="idp_user_profile_usercol")
	private String userCol;
	
	public UserProfileToUser()
	{
		
		
	}

	public int getUserProfileToUserId() {
		return userProfileToUserId;
	}

	public String getProfileDescription() {
		return profileDescription;
	}

	public int getUserProfileId() {
		return userProfileId;
	}

	public int getUserId() {
		return userId;
	}

	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}

	public String getUserCol() {
		return userCol;
	}

	public void setUserProfileToUserId(int userProfileToUserId) {
		this.userProfileToUserId = userProfileToUserId;
	}

	public void setProfileDescription(String profileDescription) {
		this.profileDescription = profileDescription;
	}

	public void setUserProfileId(int userProfileId) {
		this.userProfileId = userProfileId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}

	public void setUserCol(String userCol) {
		this.userCol = userCol;
	}
	
	
}
