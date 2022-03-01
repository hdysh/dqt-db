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
public interface EventRepository extends CrudRepository<EventPortal, Integer> {
	@Query("select e from EventPortal e")
	List<EventPortal> findAllEventPortal();

	@Query("select u from EventPortal u WHERE u.code = ?1")
	EventPortal findEventById(BigInteger code);

	@Query("select ea from EventArea ea where ea.areaGroup= ?1")
	List<EventArea> findAllEventArea(BigInteger eventPortal);
 
	@Query("select ea from Stage ea where ea.area= ?1")
	List<Stage> findAllEventStage(BigInteger eventArea);

	@Query("select ea from EventArea ea where ea.atype= ?1")
	List<EventArea> findAllStoryArea(int id);

	@Query("select ea from Stage ea where ea.area= ?1")
	List<Stage> findAllStoryStage(BigInteger eventArea);
 
	@Query("select ea from EventGroup ea where ea.eventPortal= ?1")
	List<EventGroup> findAllEventGroup(BigInteger id);

	@Query("select ea from EventGroup ea where ea.atype= ?1")
	List<EventGroup> findAllStoryGroup(BigInteger id);
}