package com.tsystems.ecrono.controllers.competitors;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tsystems.ecrono.dto.Competitor;
import com.tsystems.ecrono.usercase.CompetitorUserCase;

@RestController // Para resolver devolviendo un json (usado para las API REST)
public class CompetitorsController {

    private final CompetitorUserCase competitorUserCase;

    @Autowired
    public CompetitorsController(CompetitorUserCase competitorUserCase) {
	super();
	this.competitorUserCase = competitorUserCase;
    }

    @RequestMapping(value = "/races/{id}/competitors", method = RequestMethod.GET)
    public List<Competitor> getCompetitors(@PathVariable(value = "id") Long raceId) {
	return competitorUserCase.getCompetitorsForRace(raceId);
    }
}
