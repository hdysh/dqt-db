package com.pokiltenan.dqtdb.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pokiltenan.dqtdb.model.Ailment;
import com.pokiltenan.dqtdb.model.Element;
import com.pokiltenan.dqtdb.model.Master;
import com.pokiltenan.dqtdb.model.ResistanceLevel;
import com.pokiltenan.dqtdb.model.Stats;
import com.pokiltenan.dqtdb.model.Unit;

@Repository
public interface UnitRepository extends CrudRepository<Stats, Integer> {
	@Query("select e from Element e")
	List<Element> getAllElement();

	@Query("select a from Ailment a")
	List<Ailment> getAllAilment(); 
	
	@Query("select m from Master m")
	List<Master> getAllMaster(); 

	@Query("select a from ResistanceLevel a")
	List<ResistanceLevel> getResLevel();
	
	@Query("select a from Ailment a")
	List<Ailment> getAilments();

	@Query("select u from Unit u WHERE u.code = ?1") 
	Unit findUnitById(BigInteger code);  

//	@Query("select s from Stats s WHERE s.statsid.code = ?1 ORDER BY s.rank")
//	List<Stats> findById(BigInteger code);
	

	 List<Stats > findByCodeOrderByRankAsc(BigInteger code);
}