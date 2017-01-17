package com.tsystems.ecrono.mapper;

import org.springframework.stereotype.Component;

import com.tsystems.ecrono.domain.DorsalEntity;
import com.tsystems.ecrono.domain.RunnerEntity;
import com.tsystems.ecrono.dto.Dorsal;
import com.tsystems.ecrono.dto.create.CreateDorsal;
import com.tsystems.ecrono.dto.update.UpdateDorsal;

@Component
public class DorsalMapper {

    public DorsalEntity toDorsalEntity(Long raceId, Long runnerId, CreateDorsal createDorsal) {
	DorsalEntity dorsalToCreate = new DorsalEntity();
	dorsalToCreate.setChipCode(createDorsal.getChipCode());
	dorsalToCreate.setDorsalNumber(createDorsal.getDorsalNumber());
	dorsalToCreate.setRaceId(raceId);
	RunnerEntity runner = new RunnerEntity();
	runner.setId(runnerId);
	dorsalToCreate.setRunner(runner);
	return dorsalToCreate;
    }

    public DorsalEntity updateDorsalEntity(UpdateDorsal updateDorsal, Long raceId, Long runnerId,
	    DorsalEntity dorsalToUpdate) {
	dorsalToUpdate.setChipCode(updateDorsal.getChipCode());
	dorsalToUpdate.setDorsalNumber(updateDorsal.getDorsalNumber());
	dorsalToUpdate.setRaceId(raceId);
	RunnerEntity runner = new RunnerEntity();
	runner.setId(runnerId);
	dorsalToUpdate.setRunner(runner);
	return dorsalToUpdate;
    }

    public Dorsal toDorsal(DorsalEntity dorsalToReturn) {

	Dorsal target = new Dorsal();
	target.setChipCode(dorsalToReturn.getChipCode());
	target.setDorsalNumber(dorsalToReturn.getDorsalNumber());
	target.setRaceId(dorsalToReturn.getRaceId());
	target.setRunnerId(dorsalToReturn.getRunner().getId());

	return target;
    }
}
