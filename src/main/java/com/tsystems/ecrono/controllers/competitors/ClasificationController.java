package com.tsystems.ecrono.controllers.competitors;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tsystems.ecrono.dto.Clasification;
import com.tsystems.ecrono.usercase.ClasificationUserCase;

@RestController
public class ClasificationController {

    private final ClasificationUserCase clasificationUserCase;

    public ClasificationController(ClasificationUserCase clasificationUserCase) {
	super();
	this.clasificationUserCase = clasificationUserCase;
    }

    @RequestMapping(value = "/races/{id}/clasification", method = RequestMethod.GET)
    public List<Clasification> getClafication(@PathVariable(value = "id") Long raceId) {
	return clasificationUserCase.getClasification(raceId);
    }
}
