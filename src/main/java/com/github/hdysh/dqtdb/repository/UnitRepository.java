package com.github.hdysh.dqtdb.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.github.hdysh.dqtdb.model.AilmentRes;
import com.github.hdysh.dqtdb.model.Element;
import com.github.hdysh.dqtdb.model.Master;
import com.github.hdysh.dqtdb.model.ResistanceLevel;
import com.github.hdysh.dqtdb.model.Unit;

@Repository
public interface UnitRepository extends CrudRepository<Unit, BigInteger> {
	@Query("select e from Element e")
	List<Element> getAllElement();

	@Query("select a from AilmentRes a")
	List<AilmentRes> getAllAilment();

	@Query("select m from Master m")
	List<Master> getAllMaster();

	@Query("select a from ResistanceLevel a")
	List<ResistanceLevel> getResLevel();

	@Query("select a from AilmentRes a")
	List<AilmentRes> getAilments();

	@Query("select u from Unit u WHERE u.code = ?1")
	Unit findUnitById(BigInteger code);

//	@Query("select s from Stats s WHERE s.statsid.code = ?1 ORDER BY s.rank")
//	List<Stats> findById(BigInteger code);

}