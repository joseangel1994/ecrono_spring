package com.tsystems.ecrono.usercase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsystems.ecrono.domain.UserEntity;
import com.tsystems.ecrono.dto.User;
import com.tsystems.ecrono.dto.create.CreateUser;
import com.tsystems.ecrono.repository.UserRepository;

@Service
public class CreateUserUserCase {

    private final UserRepository userRepository;

    @Autowired
    public CreateUserUserCase(UserRepository userRepository) {
	super();
	this.userRepository = userRepository;
    }

    public User createNewUser(CreateUser createUser) {

	UserEntity userToCreate = new UserEntity();
	userToCreate.setUserName(createUser.getUserName());
	userToCreate.setPassword(createUser.getPassword());
	userToCreate.setRole(createUser.getRole());
	userRepository.save(userToCreate);

	User target = new User();
	target.setUserName(userToCreate.getUserName());
	target.setRole(userToCreate.getRole());

	return target;
    }
}
