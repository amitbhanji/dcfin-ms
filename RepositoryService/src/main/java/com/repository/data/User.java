package com.repository.data;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="idp_user")
public class User {

@Id
@Column(name="DCF_IDP_USER_ID")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int userId;

@Column(name="DCF_IDP_USER_UNAME")
@Size(min=2,message="name should be of min size 2")
	private String username;
	@Email
	@Column(name="DCF_IDP_USER_EMAIL")
	private String userEmail;
	@Column(name="DCF_IDP_USER_FNAME")
	private String userfname;
	@Column(name="DCF_IDP_USER_MNAME")
	private String usermname;
	@Column(name="DCF_IDP_USER_LNAME")
	private String userlname;
	@Column(name="DCF_IDP_USER_ADDRESS")
	private String address;
	@Past(message="date must be less than today")
	@Column(name="DCF_IDP_USER_CREATE_TIME")	
	private LocalDate createTime;
	@Column(name="DCF_IDP_USER_CREATE_BY")
	private String createdBy;
	@Column(name="DCF_IDP_USER_UPDATE_TIME")
	private String updateTime;
	@Column(name="DCF_IDP_USER_UPDATE_BY")
	private String updatedBy;
	@Column(name="DCF_IDP_USER_DELETE_TIME")
	private String deleteTime;
	@Column(name="DCF_IDP_USER_DELETE_BY")
	private String deletedBy;
	@Column(name="DCF_IDP_USER_IS_ACTIVE")
	private boolean isActive;
	@Column(name="DCF_IDP_USER_PASSWORD")
	private String password;

	public User()
	{
		
	}
	
	@JsonIgnore
	@OneToMany
	@JoinTable(
			name="idp_user_profile_user",
			joinColumns = @JoinColumn(name="idp_user_profile_user_userid"),
			inverseJoinColumns = @JoinColumn(name="idp_user_profile_user_profileid")
			)
	
	
    private List<UserProfile> userProfiles;
	
	public List<UserProfile> getUserProfiles() {
		return userProfiles;
	}
	public void setUserProfiles(List<UserProfile> userProfiles) {
		this.userProfiles = userProfiles;
	}
	public int getUserId() {
		return userId;
	}
	public String getUsername() {
		return username;
	}
	
	public String getUserEmail() {
		return userEmail;
	}

	public String getUserfname() {
		return userfname;
	}
	public String getUsermname() {
		return usermname;
	}
	public String getUserlname() {
		return userlname;
	}
	public String getAddress() {
		return address;
	}
	public LocalDate getCreateTime() {
		return createTime;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public String getDeleteTime() {
		return deleteTime;
	}
	public String getDeletedBy() {
		return deletedBy;
	}
	
	public boolean isActive() {
		return isActive;
	}

	public String getPassword() {
		return password;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	public void setUserfname(String userfname) {
		this.userfname = userfname;
	}


	public void setUsermname(String usermname) {
		this.usermname = usermname;
	}


	public void setUserlname(String userlname) {
		this.userlname = userlname;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public void setCreateTime(LocalDate createTime) {
		this.createTime = createTime;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}


	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}


	public void setDeleteTime(String deleteTime) {
		this.deleteTime = deleteTime;
	}


	public void setDeletedBy(String deletedBy) {
		this.deletedBy = deletedBy;
	}


	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", userfname=" + userfname + ", usermname="
				+ usermname + ", userlname=" + userlname + ", address=" + address + ", createTime=" + createTime
				+ ", createdBy=" + createdBy + ", updateTime=" + updateTime + ", updatedBy=" + updatedBy
				+ ", deleteTime=" + deleteTime + ", deletedBy=" + deletedBy + ", password=" + password + "]";
	}
	
	
}
