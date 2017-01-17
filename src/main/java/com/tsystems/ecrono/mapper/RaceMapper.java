package com.tsystems.ecrono.mapper;

import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import com.tsystems.ecrono.domain.RaceEntity;
import com.tsystems.ecrono.domain.component.RaceType;
import com.tsystems.ecrono.dto.Race;
import com.tsystems.ecrono.dto.create.CreateRace;
import com.tsystems.ecrono.dto.update.UpdateRace;

@Component
public class RaceMapper {

    public RaceEntity toRaceEntity(CreateRace createRace) {
	RaceEntity raceToCreate = new RaceEntity();
	raceToCreate.setName(createRace.getName());
	raceToCreate.setDistanceInMeters(createRace.getDistanceInMeters());
	raceToCreate.setInitTime(createRace.getInitTime());
	raceToCreate.setType(toRaceType(createRace.getDistanceInMeters()));
	return raceToCreate;
    }

    public RaceEntity updateRaceEntity(UpdateRace updateRace, RaceEntity raceToCreate) {
	raceToCreate.setName(updateRace.getName());
	raceToCreate.setDistanceInMeters(updateRace.getDistanceInMeters());
	raceToCreate.setType(toRaceType(updateRace.getDistanceInMeters()));
	raceToCreate.setInitTime(updateRace.getInitTime());
	return raceToCreate;
    }

    public Race toRace(RaceEntity raceToReturn) {
	Race target = new Race();
	target.setId(raceToReturn.getId());
	target.setName(raceToReturn.getName());
	target.setId(raceToReturn.getId());
	target.setDistanceInMeters(raceToReturn.getDistanceInMeters());
	target.setType(toRaceType(raceToReturn.getDistanceInMeters()));
	String formatDate = DateTimeFormatter.ISO_DATE_TIME.format(raceToReturn.getInitTime());
	target.setInitTime(formatDate);
	return target;
    }

    private RaceType toRaceType(Double distanceInMeters) {

	if (distanceInMeters <= 100) {
	    return RaceType.SPRINT;
	} else if (distanceInMeters <= 21000) {
	    return RaceType.HALF_MARATHON;
	} else if (distanceInMeters <= 42000) {
	    return RaceType.MARATHON;
	} else {
	    return RaceType.IRON_MAN;

	}
    }
}
