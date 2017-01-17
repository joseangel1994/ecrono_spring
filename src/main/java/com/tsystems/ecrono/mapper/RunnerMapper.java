package com.tsystems.ecrono.mapper;

import org.springframework.stereotype.Component;

import com.tsystems.ecrono.domain.RunnerEntity;
import com.tsystems.ecrono.dto.Runner;
import com.tsystems.ecrono.dto.create.CreateRunner;
import com.tsystems.ecrono.dto.update.UpdateRunner;

@Component
public class RunnerMapper {

    public RunnerEntity toRunnerEntity(CreateRunner createRunner) {
	RunnerEntity runnerToCreate = new RunnerEntity();
	runnerToCreate.setName(createRunner.getName());
	return runnerToCreate;
    }

    public RunnerEntity updateRunnerEntity(UpdateRunner updateRunner, RunnerEntity runnerToCreate) {
	runnerToCreate.setName(updateRunner.getName());
	return runnerToCreate;
    }

    public Runner toRunner(RunnerEntity runnerToReturn) {
	Runner target = new Runner();
	target.setName(runnerToReturn.getName());
	target.setId(runnerToReturn.getId());
	return target;
    }
}
