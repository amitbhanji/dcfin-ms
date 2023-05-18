package com.repository.data;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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
	@JsonIgnore
	@OneToMany
	@JoinTable(
			name="idp_entitlement_user_profiles",
			joinColumns = @JoinColumn(name="idp_entitlement_user_profile_userprofile_id"),
			inverseJoinColumns = @JoinColumn(name="idp_entitlement_user_profile_entitlement_id")
			
			)
	private List<Entitlement> entitlements;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "userProfiles")
	private List<User> users;
	
	public List<Entitlement> getEntitlements() {
		return entitlements;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public void setEntitlements(List<Entitlement> entitlements) {
		this.entitlements = entitlements;
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
