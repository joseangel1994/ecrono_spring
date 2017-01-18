package com.tsystems.ecrono.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tsystems.ecrono.domain.DorsalEntity;

//Para poder bajar a hibernate desde criteria
@Repository
@Transactional
public class HibernateClasificationRepository implements ClasificationRepository {

    private final EntityManager entityManager;

    @Autowired
    public HibernateClasificationRepository(EntityManager entityManager) {
	super();
	this.entityManager = entityManager;
    }

    // Consulta con criteria para obtener una lista de dorsales que tengan un
    // raceId determinado
    @SuppressWarnings("unchecked")
    @Override
    public List<DorsalEntity> getClasificationForRace(Long raceId) {

	return entityManager.unwrap(Session.class).createCriteria(DorsalEntity.class)//
		.add(Restrictions.eq("raceId", raceId))//
		.setFetchMode("timestamps", FetchMode.JOIN)//
		.setFetchMode("runner", FetchMode.JOIN)//
		.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

    }
}
