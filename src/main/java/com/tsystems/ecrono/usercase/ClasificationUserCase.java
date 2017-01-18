package com.tsystems.ecrono.usercase;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsystems.ecrono.domain.DorsalEntity;
import com.tsystems.ecrono.dto.Clasification;
import com.tsystems.ecrono.repository.ClasificationRepository;

@Service
public class ClasificationUserCase {

    private final ClasificationRepository clasificationRepository;

    @Autowired
    public ClasificationUserCase(ClasificationRepository clasificationRepository) {
	super();
	this.clasificationRepository = clasificationRepository;
    }

    public List<Clasification> getClasification(Long raceId) {

	List<DorsalEntity> dorsals = clasificationRepository.getClasificationForRace(raceId);
	List<Clasification> listToReturn = new LinkedList<>();

	for (DorsalEntity dorsalEntity : dorsals) {
	    Clasification clasification = new Clasification();
	    clasification.setDorsalNumber(dorsalEntity.getDorsalNumber());
	    clasification.setId(dorsalEntity.getRunner().getId());
	    clasification.setName(dorsalEntity.getRunner().getName());
	    clasification.setTimeStamp(dorsalEntity.getTimestamps().iterator().next().getTimeStamp());
	    listToReturn.add(clasification);

	}
	return listToReturn;

    }

}
