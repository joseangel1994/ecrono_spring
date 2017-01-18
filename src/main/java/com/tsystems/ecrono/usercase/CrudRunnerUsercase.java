package com.tsystems.ecrono.usercase;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsystems.ecrono.domain.RunnerEntity;
import com.tsystems.ecrono.dto.Runner;
import com.tsystems.ecrono.dto.create.CreateRunner;
import com.tsystems.ecrono.dto.update.UpdateRunner;
import com.tsystems.ecrono.mapper.RunnerMapper;
import com.tsystems.ecrono.repository.RunnerRepository;

@Service
public class CrudRunnerUsercase {

    private final RunnerRepository runnerRepository;
    private final RunnerMapper mapper;

    @Autowired
    public CrudRunnerUsercase(RunnerRepository runnerRepository, RunnerMapper mapper) {
	super();
	this.runnerRepository = runnerRepository;
	this.mapper = mapper;
    }

    public Runner getRunnerById(Long runnerId) {

	RunnerEntity runnerToReturn = runnerRepository.findOne(runnerId);
	Runner target = mapper.toRunner(runnerToReturn);

	return target;

    }

    public Runner createNewRunner(CreateRunner createRunner) {

	RunnerEntity runnerToCreate = mapper.toRunnerEntity(createRunner);
	runnerRepository.save(runnerToCreate);

	return mapper.toRunner(runnerToCreate);
    }

    public Runner updateRunner(UpdateRunner updateRunner, Long idRunner) {

	RunnerEntity runnerToUpdate = runnerRepository.findOne(idRunner);
	mapper.updateRunnerEntity(updateRunner, runnerToUpdate);

	return mapper.toRunner(runnerToUpdate);
    }

    public List<Runner> findAll() {
	List<RunnerEntity> runnerList = runnerRepository.findAll();
	List<Runner> listToReturn = new LinkedList<>();
	for (RunnerEntity runner : runnerList) {
	    listToReturn.add(mapper.toRunner(runner));
	}
	// Forma opcional de hacerlo
	// return runnerList.stream().map(r
	// ->mapper.toRunner(r)).collect(Collectors.toList());
	return listToReturn;
    }

    public List<Runner> findByNameFilter(String filter) {

	List<RunnerEntity> findByNameContains = runnerRepository.findByNameContains(filter);
	List<Runner> listToReturn = new LinkedList<>();
	for (RunnerEntity runner : findByNameContains) {
	    listToReturn.add(mapper.toRunner(runner));
	}
	return listToReturn;
    }

    public void delete(Long runnerId) {
	runnerRepository.delete(runnerId);
    }

}
