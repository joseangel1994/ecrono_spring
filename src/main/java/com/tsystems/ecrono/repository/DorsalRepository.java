package com.tsystems.ecrono.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tsystems.ecrono.domain.DorsalEntity;
import com.tsystems.ecrono.domain.RunnerEntity;

public interface DorsalRepository extends JpaRepository<DorsalEntity, Long> {

    DorsalEntity findByRaceIdAndRunner(Long raceId, RunnerEntity runnerEntity);

    // Consulta en HQL
    @Query(value = "FROM DorsalEntity  d LEFT JOIN FETCH d.runner WHERE d.raceId =?1")
    List<DorsalEntity> findByRaceId(Long raceId);

    @Query(value = "FROM DorsalEntity d LEFT JOIN d.runner r WHERE d.raceId =?1 AND r.id = ?2")
    DorsalEntity findByRaceIdAndRunner(Long raceId, Long runnerId);

    @Query(value = "delete from dorsals where race_id =?1 and runner_id =?2", nativeQuery = true)
    void deleteByRaceIdAndRunner(Long raceId, Long runnerId);

}
