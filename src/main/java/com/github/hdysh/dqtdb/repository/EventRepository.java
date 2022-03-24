package com.github.hdysh.dqtdb.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.github.hdysh.dqtdb.model.EventArea;
import com.github.hdysh.dqtdb.model.EventGroup;
import com.github.hdysh.dqtdb.model.EventPortal;
import com.github.hdysh.dqtdb.model.Stage;

@Repository
public interface EventRepository extends CrudRepository<EventPortal, BigInteger> {
	@Query("select ep from EventPortal ep where ep.reminiscence = 0 order by ep.achievement desc")
	List<EventPortal> getAllEventPortal();

	@Query("select ep from EventPortal ep where ep.reminiscence = 1 order by ep.code desc")
	List<EventPortal> getAllRemiPortal();

	@Query("select u from EventPortal u WHERE u.code = ?1")
	EventPortal findEventById(BigInteger code);

	@Query("select ea from EventArea ea where ea.areaGroup= ?1")
	List<EventArea> findAllEventArea(BigInteger eventGroup);

	@Query("select ea from EventArea ea where ea.eventPortal= ?1 and (ea.areaGroup is NULL or ea.areaGroup = 402)")
	List<EventArea> findAllEventAreaByPortal(BigInteger eventPortal);

	@Query("select s from Stage s where s.area= ?1")
	List<Stage> findAllEventStage(BigInteger eventArea);

	@Query("select ea from EventArea ea where ea.category= ?1")
	List<EventArea> findAllStoryArea(int id);

	@Query("select s from Stage s where s.area= ?1")
	List<Stage> findAllStoryStage(BigInteger eventArea);

	@Query("select eg from EventGroup eg where eg.eventPortal= ?1")
	List<EventGroup> findAllEventGroup(BigInteger id);

	@Query("select eg from EventGroup eg where eg.category= ?1")
	List<EventGroup> findAllStoryGroup(BigInteger id);

	@Query("select eg from EventGroup eg where eg.category= 4 and eg.eventPortal is null")
	List<EventGroup> findAllBattleroads();

	@Query("select eg from EventGroup eg where eg.category= 5 and eg.eventPortal is null")
	List<EventGroup> findGroupDailies();

	@Query("select ea from EventArea ea where ea.category= 5 and ea.areaGroup is null and ea.eventPortal is null")
	List<EventArea> findAreaDailies();

	@Query("select ea from EventArea ea where (ea.category= 6 or ea.category= 9 or ea.category= 2) and ea.areaGroup is null and ea.eventPortal is null")
	List<EventArea> findExtraArea();
 
	@Query("select eg from EventGroup eg where eg.category= 2 and eg.eventPortal is null")
	List<EventGroup> findExtraGroup();

	@Query("select eg from EventGroup eg where eg.category= 7")
	List<EventGroup> findHeroQuest();

	@Query("select eg from EventGroup eg where eg.category= 2 and eg.subCategory = 0 and eg.eventPortal is null")
	List<EventGroup> findMiscGroup();

	@Query("select ea from EventArea ea where ea.category= 2 and ea.subCategory = 0 and ea.eventPortal is null")
	List<EventArea> findMiscArea();
}