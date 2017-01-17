package com.tsystems.ecrono.mapper;

import com.tsystems.ecrono.domain.RaceEntity;
import com.tsystems.ecrono.dto.create.CreateRace;

public class RaceMapper {

    public RaceEntity toRaceEntity(CreateRace createRace) {
	RaceEntity raceToCreate = new RaceEntity();
	raceToCreate.setName(createRace.getName());
	return raceToCreate;
    }
}
