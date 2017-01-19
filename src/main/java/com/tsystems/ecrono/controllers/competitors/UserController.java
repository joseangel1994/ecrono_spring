package com.tsystems.ecrono.controllers.competitors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tsystems.ecrono.dto.User;
import com.tsystems.ecrono.dto.create.CreateUser;
import com.tsystems.ecrono.usercase.CreateUserUserCase;

@RestController
public class UserController {

    private final CreateUserUserCase createUserUserCase;

    @Autowired
    public UserController(CreateUserUserCase createUserUserCase) {
	super();
	this.createUserUserCase = createUserUserCase;
    }

    // @Valid sirve para validar cualquier elemento con los validadores
    // automaticos de spring
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<User> createUser(@RequestBody @Valid CreateUser createUser) {
	User user = createUserUserCase.createNewUser(createUser);
	return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }
}
