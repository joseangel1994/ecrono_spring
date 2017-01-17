package com.tsystems.ecrono.usercase;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsystems.ecrono.domain.RaceEntity;
import com.tsystems.ecrono.dto.Race;
import com.tsystems.ecrono.dto.create.CreateRace;
import com.tsystems.ecrono.dto.update.UpdateRace;
import com.tsystems.ecrono.mapper.RaceMapper;
import com.tsystems.ecrono.repository.RaceRepository;

@Service
public class CrudRaceUserCase {

    private final RaceRepository raceRepository;
    private final RaceMapper mapper;

    @Autowired
    public CrudRaceUserCase(RaceRepository raceRepository, RaceMapper mapper) {
	super();
	this.raceRepository = raceRepository;
	this.mapper = mapper;
    }

    public Race getRaceById(Long raceId) {

	RaceEntity raceToReturn = raceRepository.findOne(raceId);
	Race target = mapper.toRace(raceToReturn);

	return target;

    }

    public Race createNewRace(CreateRace createRace) {

	RaceEntity raceToCreate = mapper.toRaceEntity(createRace);
	raceRepository.save(raceToCreate);

	return mapper.toRace(raceToCreate);
    }

    public Race updateRace(UpdateRace updateRace, Long idRace) {

	RaceEntity raceToUpdate = raceRepository.findOne(idRace);
	mapper.updateRaceEntity(updateRace, raceToUpdate);

	return mapper.toRace(raceToUpdate);
    }

    public List<Race> findAll() {
	List<RaceEntity> raceList = raceRepository.findAll();
	List<Race> listToReturn = new LinkedList<>();
	for (RaceEntity race : raceList) {
	    listToReturn.add(mapper.toRace(race));
	}
	// Forma opcional de hacerlo
	// return runnerList.stream().map(r
	// ->mapper.toRunner(r)).collect(Collectors.toList());
	return listToReturn;
    }

    public void delete(Long raceId) {
	raceRepository.delete(raceId);
    }

}
