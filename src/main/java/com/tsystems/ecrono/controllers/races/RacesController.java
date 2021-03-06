package com.tsystems.ecrono.controllers.races;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tsystems.ecrono.domain.component.RaceType;
import com.tsystems.ecrono.dto.Race;
import com.tsystems.ecrono.dto.create.CreateRace;
import com.tsystems.ecrono.dto.update.UpdateRace;
import com.tsystems.ecrono.usercase.CrudRaceUserCase;

@RestController // Para resolver devolviendo un json (usado para las API REST)
@RequestMapping("races")

public class RacesController {

    private final CrudRaceUserCase crudRaceUserCase;

    @Autowired
    public RacesController(CrudRaceUserCase crudRaceUserCase) {
	super();
	this.crudRaceUserCase = crudRaceUserCase;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Race> getRaces(@RequestParam(value = "type", required = false) RaceType raceType,
	    @RequestParam(value = "init_time", required = false) //
	    Instant initTime) {
	// Falta hacer la conversion a un formato de time adecuado
	if (raceType == null && initTime == null) {
	    return crudRaceUserCase.findAll();
	} else {
	    return crudRaceUserCase.findByTypeAndDateFilter(raceType, initTime);
	}
    }

    @RequestMapping(value = "{id:\\d+}", method = RequestMethod.GET)
    public Race getRaceById(@PathVariable("id") Long raceId) {
	return crudRaceUserCase.getRaceById(raceId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Race createRace(@RequestBody CreateRace createRace) {
	return crudRaceUserCase.createNewRace(createRace);
    }

    @RequestMapping(value = "{id:\\d+}", method = RequestMethod.PUT)
    public Race editRace(@PathVariable("id") Long raceId, @RequestBody UpdateRace updateRace) {
	return crudRaceUserCase.updateRace(updateRace, raceId);
    }

    @RequestMapping(value = "{id:\\d+}", method = RequestMethod.DELETE)
    public void deleteRace(@PathVariable("id") Long raceId) {
	crudRaceUserCase.delete(raceId);
    }

}
