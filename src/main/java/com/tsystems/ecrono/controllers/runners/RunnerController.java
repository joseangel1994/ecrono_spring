package com.tsystems.ecrono.controllers.runners;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tsystems.ecrono.dto.Runner;

@RestController // Para resolver devolviendo un json (usado para las API REST)
@RequestMapping("runners")

public class RunnerController {

    @RequestMapping(method = RequestMethod.GET)
    public List<Runner> getRunners() {
	throw new IllegalArgumentException("Not implemented yet");
    }

    @RequestMapping(value = "{id:\\d+}", method = RequestMethod.GET)
    public Runner getRunnerByName(@PathVariable("name") String fullName) {
	throw new IllegalArgumentException("Not implemented yet");
    }

    @RequestMapping(method = RequestMethod.POST)
    public Runner createRace() {
	throw new IllegalArgumentException("Not implemented yet");
    }

    @RequestMapping(value = "{id:\\d+}", method = RequestMethod.PUT)
    public Runner editRunner() {
	throw new IllegalArgumentException("Not implemented yet");
    }

    @RequestMapping(value = "{id:\\d+}", method = RequestMethod.DELETE)
    public Runner deleteRunner() {
	throw new IllegalArgumentException("Not implemented yet");
    }

}
