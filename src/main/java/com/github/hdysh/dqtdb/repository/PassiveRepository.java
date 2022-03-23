package com.github.hdysh.dqtdb.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.github.hdysh.dqtdb.model.Passive;
import com.github.hdysh.dqtdb.model.UnitMin;

@Repository
public interface PassiveRepository extends CrudRepository<UnitMin, BigInteger> {
	@Query("select p from Passive p")
	List<Passive> getAllPassive();

	@Query("select p from Passive p WHERE p.code = ?1")
	Passive findPassiveById(BigInteger code);

	@Query(value = "select distinct unit.* from unit inner join unit_passive on unit.code = unit_passive.code where unit_passive.passive = ?1 ", nativeQuery = true)
	List<UnitMin> findUnitByPassive(BigInteger passive);

	@Query(value = "select distinct unit.* from unit inner join unit_awakening on unit.code = unit_awakening.code where unit_awakening.awakening = ?1 ", nativeQuery = true)
	List<UnitMin> findUnitByAwakening(BigInteger passive);
}