package com.pokiltenan.dqtdb.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pokiltenan.dqtdb.model.EventArea;
import com.pokiltenan.dqtdb.model.EventGroup;
import com.pokiltenan.dqtdb.model.EventPortal;
import com.pokiltenan.dqtdb.model.Stage;

@Repository
public interface StagesRepository extends CrudRepository<Stage, Integer> {
	@Query("select s from Stage s")
	List<Stage> findAllStage();

	@Query("select u from Stage u WHERE u.code = ?1")
	Stage findStageById(BigInteger code);

	@Query("select a from EventArea a WHERE a.code = ?1")
	EventArea findAreaById(BigInteger code);

	@Query("select p from EventPortal p WHERE p.code = ?1")
	EventPortal findPortalById(BigInteger code);

	@Query("select p from EventGroup p WHERE p.code = ?1")
	EventGroup findGroupById(BigInteger id);
}