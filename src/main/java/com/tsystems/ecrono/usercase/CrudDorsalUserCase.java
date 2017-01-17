package com.tsystems.ecrono.usercase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsystems.ecrono.domain.DorsalEntity;
import com.tsystems.ecrono.domain.RunnerEntity;
import com.tsystems.ecrono.dto.Dorsal;
import com.tsystems.ecrono.dto.create.CreateDorsal;
import com.tsystems.ecrono.mapper.DorsalMapper;
import com.tsystems.ecrono.repository.DorsalRepository;

@Service
public class CrudDorsalUserCase {

    private final DorsalRepository dorsalRepository;
    private final DorsalMapper mapper;

    @Autowired
    public CrudDorsalUserCase(DorsalRepository dorsalRepository, DorsalMapper mapper) {
	super();
	this.dorsalRepository = dorsalRepository;
	this.mapper = mapper;
    }

    public Dorsal createNewDorsal(Long raceId, Long runnerId, CreateDorsal createDorsal)
	    throws DuplicateEntityException {

	// Si el corredor esta dado de alta como lo soluciono
	RunnerEntity runnerEntity = new RunnerEntity();
	runnerEntity.setId(runnerId);
	DorsalEntity runnerInDb = dorsalRepository.findByRaceIdAndRunner(raceId, runnerEntity);
	if (runnerInDb == null) {
	    DorsalEntity dorsal = mapper.toDorsalEntity(raceId, runnerId, createDorsal);
	    dorsalRepository.save(dorsal);
	    return mapper.toDorsal(dorsal);
	} else {
	    throw new DuplicateEntityException("Ya existe un elemento con esas propiedades");
	}
    }

    // public Dorsal updateDorsal(UpdateDorsal updateDorsal, Long idDorsal) {
    //
    // DorsalEntity dorsalToUpdate = dorsalRepository.findOne(idDorsal);
    // mapper.updateDorsalEntity(updateDorsal, dorsalToUpdate);
    //
    // return mapper.toDorsal(dorsalToUpdate);
    // }

    public void delete(Long raceId, Long runnerId) {
	// RunnerEntity runnerEntity = new RunnerEntity();
	// runnerEntity.setId(runnerId);
	// dorsalRepository.deleteByRaceIdAndRunner(raceId, runnerEntity);
    }

}
