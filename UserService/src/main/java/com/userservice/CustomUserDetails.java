
package com.userservice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.repository.data.User;
import com.repository.data.UserProfile;

public class CustomUserDetails implements UserDetails  {

	private User user;
	
	public CustomUserDetails(User user)
	{
		this.user=user;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<UserProfile> profiles = user.getUserProfiles();
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		for(UserProfile profile: profiles)
		{
			authorities.add(new SimpleGrantedAuthority(profile.getDescription()));
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return new BCryptPasswordEncoder().encode(user.getPassword());
		//return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		//return user.getUserEmail();
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return user.isActive();
	}
	  public String getFullName() {
	        return user.getUserfname() + " " + user.getUserlname();
	    }
	 
}
