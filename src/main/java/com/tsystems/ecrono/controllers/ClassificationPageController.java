package com.tsystems.ecrono.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tsystems.ecrono.dto.Clasification;
import com.tsystems.ecrono.usercase.ClasificationUserCase;

@Controller
public class ClassificationPageController {

    private final ClasificationUserCase clasificationUserCase;

    @Autowired
    public ClassificationPageController(ClasificationUserCase clasificationUserCase) {
	super();
	this.clasificationUserCase = clasificationUserCase;
    }

    @RequestMapping(value = "/clasificationpage/{id}", method = RequestMethod.GET)
    public String getClafication(@PathVariable(value = "id") Long raceId, Principal usuario, Model model) {

	List<Clasification> clasification = clasificationUserCase.getClasification(raceId);
	model.addAttribute("nombre1", clasification);
	model.addAttribute("nombre2", clasification);
	model.addAttribute("mensaje", "Hola!!!");

	return "classification";
    }
}
