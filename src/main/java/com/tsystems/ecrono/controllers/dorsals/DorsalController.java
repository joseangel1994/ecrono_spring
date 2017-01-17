package com.tsystems.ecrono.controllers.dorsals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tsystems.ecrono.dto.Dorsal;
import com.tsystems.ecrono.dto.create.CreateDorsal;
import com.tsystems.ecrono.usercase.CrudDorsalUserCase;
import com.tsystems.ecrono.usercase.DuplicateEntityException;

@RestController // Para resolver devolviendo un json (usado para las API REST)
@RequestMapping(value = "/races/{raceId:\\d+}/runners/{runnerId:\\d+}/dorsals")

public class DorsalController {

    private final CrudDorsalUserCase crudDorsalUserCase;

    @Autowired
    public DorsalController(CrudDorsalUserCase crudDorsalUserCase) {
	super();
	this.crudDorsalUserCase = crudDorsalUserCase;
    }

    @RequestMapping(value = "{id:\\d+}", method = RequestMethod.GET)
    public Dorsal getDorsal() {
	throw new IllegalArgumentException("Not implemented yet");
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Dorsal> createDorsal(@PathVariable(value = "runnerId") Long runnerId,
	    @PathVariable(value = "raceId") Long raceId, @RequestBody CreateDorsal createDorsal) {

	// Para ver si podemos crear el dorsal viendo si esta duplicado
	try {
	    Dorsal created = crudDorsalUserCase.createNewDorsal(raceId, runnerId, createDorsal);
	    return new ResponseEntity<Dorsal>(created, HttpStatus.CREATED);
	} catch (DuplicateEntityException e) {
	    return new ResponseEntity<Dorsal>(HttpStatus.CONFLICT);
	}
    }

    @RequestMapping(value = "{id:\\d+}", method = RequestMethod.PUT)
    public Dorsal editDorsal() {
	throw new IllegalArgumentException("Not implemented yet");
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteDorsal(@PathVariable(value = "runnerId") Long runnerId,
	    @PathVariable(value = "raceId") Long raceId) {
	crudDorsalUserCase.delete(raceId, runnerId);
    }

}
