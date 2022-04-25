package com.github.hdysh.dqtdb.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.github.hdysh.dqtdb.model.UnitDrop;
import com.github.hdysh.dqtdb.model.UnitMin;

@Repository
public interface UnitsRepository extends JpaRepository<UnitMin, BigInteger> {
	@Query(value = "select * from unit u", nativeQuery = true)
	List<UnitMin> findAllUnit();
//
//	List<UnitMin> findAllByCodeOrderByRarityAsc(List<BigInteger> codes);

	@Query("select u from UnitDrop u")
	List<UnitDrop> findAllUnitDrop();

	@Query(value = "select *  from unit inner join unit_skill on unit.code = unit_skill.code where unit_skill.skill = ?1 order by rarity desc", nativeQuery = true)
	List<UnitMin> findAllUnit(BigInteger skill);

	@Query(value = "select distinct unit.* from unit inner join unit_passive on unit.code = unit_passive.code where unit_passive.passive = ?1 ", nativeQuery = true)
	List<UnitMin> findUnitByPassive(BigInteger passive);

	@Query(value = "select distinct unit.* from unit inner join unit_awakening on unit.code = unit_awakening.code where unit_awakening.awakening = ?1 ", nativeQuery = true)
	List<UnitMin> findUnitByAwakening(BigInteger passive);

	@Query(value = "select distinct unit.* from unit inner join unit_talent on unit.code = unit_talent.code where unit_talent.passive = ?1 ", nativeQuery = true)
	List<UnitMin> findUnitByTalentPassive(BigInteger passive);

	@Query(value = "select * from unit where unit.leader = ?1 ", nativeQuery = true)
	List<UnitMin> findUnitByLeader(BigInteger leader);
}