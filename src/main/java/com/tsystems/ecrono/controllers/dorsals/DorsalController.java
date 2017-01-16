package com.tsystems.ecrono.controllers.dorsals;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tsystems.ecrono.dto.Dorsal;

@RestController // Para resolver devolviendo un json (usado para las API REST)
@RequestMapping("dorsals")

public class DorsalController {

    @RequestMapping(value = "{id:\\d+}", method = RequestMethod.GET)
    public Dorsal getDorsal() {
	throw new IllegalArgumentException("Not implemented yet");
    }

    @RequestMapping(method = RequestMethod.POST)
    public Dorsal createDorsal(@PathVariable("id_race") Long raceId, @PathVariable("id_runner") Long runnerId) {
	throw new IllegalArgumentException("Not implemented yet");
    }

    @RequestMapping(value = "{id:\\d+}", method = RequestMethod.PUT)
    public Dorsal editDorsal() {
	throw new IllegalArgumentException("Not implemented yet");
    }

    @RequestMapping(value = "{id:\\d+}", method = RequestMethod.DELETE)
    public Dorsal deleteDorsal(@PathVariable("id_race") Long raceId, @PathVariable("id_runner") Long runnerId) {
	throw new IllegalArgumentException("Not implemented yet");
    }

}
