package com.tsystems.ecrono.domain;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "time_stamps", indexes = { @Index(columnList = "chip_code") }

)
@Data
@ToString(of = { "timeStamp" })
public class TimeStampEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "time_stamp", nullable = false)
    private Instant timeStamp;

    @Column(name = "chip_code", nullable = false)
    private String chipCode;

    @Column(name = "machine_id", nullable = false, updatable = false)
    private Long machineId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dorsal_id", referencedColumnName = "id")
    private DorsalEntity dorsal;

}