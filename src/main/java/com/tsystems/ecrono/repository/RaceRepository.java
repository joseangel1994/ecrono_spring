package com.tsystems.ecrono.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tsystems.ecrono.domain.RaceEntity;

public interface RaceRepository extends JpaRepository<RaceEntity, Long> {

    Page<RaceEntity> findByNameContains(String prefix, Pageable pageable);

}
