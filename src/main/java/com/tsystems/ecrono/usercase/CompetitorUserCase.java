package com.tsystems.ecrono.usercase;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsystems.ecrono.domain.DorsalEntity;
import com.tsystems.ecrono.dto.Competitor;
import com.tsystems.ecrono.repository.DorsalRepository;
import com.tsystems.ecrono.repository.RunnerRepository;

@Service
public class CompetitorUserCase {

    private final RunnerRepository runnerRepository;
    private final DorsalRepository dorsalRepository;

    @Autowired
    public CompetitorUserCase(RunnerRepository runnerRepository, DorsalRepository dorsalRepository) {
	super();
	this.runnerRepository = runnerRepository;
	this.dorsalRepository = dorsalRepository;
    }

    public List<Competitor> getCompetitorsForRace(Long raceId) {

	List<DorsalEntity> findByRaceId = dorsalRepository.findByRaceId(raceId);
	List<Competitor> listToReturn = new LinkedList<>();

	for (DorsalEntity dorsalEntity : findByRaceId) {
	    // Traer datos a traves de una relacion es peligroso
	    Competitor competitor = new Competitor();
	    competitor.setDorsalNumber(dorsalEntity.getDorsalNumber());
	    competitor.setName(dorsalEntity.getRunner().getName());
	    competitor.setId(dorsalEntity.getRunner().getId());
	    listToReturn.add(competitor);
	}
	return listToReturn;

    }
}
