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
}