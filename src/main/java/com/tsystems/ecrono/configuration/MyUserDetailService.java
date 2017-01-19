package com.tsystems.ecrono.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.tsystems.ecrono.configuration.component.MyUserDetail;
import com.tsystems.ecrono.domain.UserEntity;
import com.tsystems.ecrono.repository.UserRepository;

@Component
public class MyUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public MyUserDetailService(UserRepository userRepository) {
	super();
	this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
	UserEntity findByUserName = userRepository.findByUserName(userName);

	if (findByUserName != null) {
	    return new MyUserDetail(findByUserName);
	} else {
	    throw new UsernameNotFoundException("Usuario no encontrado");
	}
    }

}
