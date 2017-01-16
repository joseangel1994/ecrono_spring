package com.tsystems.ecrono.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "runners")
@Data
@ToString(of = { "id" })
public class RunnerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String name;

    // @MANYTOMANY(FETCH = FETCHTYPE.LAZY)
    // @JOINTABLE(NAME = "DORSALS", JOINCOLUMNS = @JOINCOLUMN(NAME =
    // "RUNNER_ID"), INVERSEJOINCOLUMNS = @JOINCOLUMN(NAME = "RACE_ID"))
    // PRIVATE LIST<RACEENTITY> RACES;

}
