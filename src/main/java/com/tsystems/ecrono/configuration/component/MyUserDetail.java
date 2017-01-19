package com.tsystems.ecrono.configuration.component;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.tsystems.ecrono.domain.UserEntity;

public class MyUserDetail implements UserDetails {

    private final UserEntity user;

    public MyUserDetail(UserEntity user) {
	super();
	this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
	Set<String> roles = user.getRole();
	List<GrantedAuthority> authorities = new LinkedList<>();
	for (String role : roles) {
	    SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(role);
	    authorities.add(simpleGrantedAuthority);
	}
	// Forma alternativa
	// AuthorityUtils.createAuthorityList(user.getRole().toArray(new
	// String[user.getRole().size()]));
	return authorities;
    }

    @Override
    public String getPassword() {
	return user.getPassword();
    }

    @Override
    public String getUsername() {
	return user.getUserName();

    }

    @Override
    public boolean isAccountNonExpired() {
	return true;
    }

    @Override
    public boolean isAccountNonLocked() {
	return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
	return true;
    }

    @Override
    public boolean isEnabled() {
	return true;
    }

}
