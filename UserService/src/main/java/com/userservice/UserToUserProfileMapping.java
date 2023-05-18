package com.userservice;

import java.util.List;
import com.repository.data.User;

public class UserToUserProfileMapping {

	private User user;
	private List<Integer> profiles;
	
	public UserToUserProfileMapping()
	{
		
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Integer> getProfiles() {
		return profiles;
	}

	public void setProfiles(List<Integer> profiles) {
		this.profiles = profiles;
	}
	
	
}
