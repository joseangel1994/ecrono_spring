package com.tsystems.ecrono.controllers.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tsystems.ecrono.dto.Runner;
import com.tsystems.ecrono.dto.create.CreateRunner;
import com.tsystems.ecrono.dto.update.UpdateRunner;
import com.tsystems.ecrono.usercase.CrudRunnerUsercase;

@RestController // Para resolver devolviendo un json (usado para las API REST)
@RequestMapping("runners")

public class RunnerController {

    private final CrudRunnerUsercase crudRunnerUserCase;

    @Autowired
    public RunnerController(CrudRunnerUsercase crudRunnerUserCase) {
	super();
	this.crudRunnerUserCase = crudRunnerUserCase;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Runner> getRunners(@RequestParam(value = "name", required = false) String name) {
	if (name == null) {
	    return crudRunnerUserCase.findAll();
	} else {
	    return crudRunnerUserCase.findByNameFilter(name);
	}
    }

    @RequestMapping(value = "{id:\\d+}", method = RequestMethod.GET)
    public Runner getRunnerByName(@PathVariable("id") Long runnerId) {
	return crudRunnerUserCase.getRunnerById(runnerId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Runner createRunner(@RequestBody CreateRunner createRunner) {
	return crudRunnerUserCase.createNewRunner(createRunner);
    }

    @RequestMapping(value = "{id:\\d+}", method = RequestMethod.PUT)
    public Runner editRunner(@PathVariable("id") Long runnerId, @RequestBody UpdateRunner updateRunner) {
	return crudRunnerUserCase.updateRunner(updateRunner, runnerId);
    }

    @RequestMapping(value = "{id:\\d+}", method = RequestMethod.DELETE)
    public void deleteRunner(@PathVariable("id") Long runnerId) {
	crudRunnerUserCase.delete(runnerId);
    }

}
