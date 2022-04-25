package com.github.hdysh.dqtdb.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.github.hdysh.dqtdb.model.Passive;
import com.github.hdysh.dqtdb.model.PassiveMin;

@Repository
public interface PassiveRepository extends CrudRepository<Passive, BigInteger> {
	@Query("select p from PassiveMin p where p.name != '' ")
	List<PassiveMin> getAllPassive();

	@Query("select p from Passive p WHERE p.code = ?1")
	Passive findPassiveById(BigInteger code);

	@Query(value = "select passive.* from passive inner join skill_ailment on skill_ailment.code = passive.ailment where skill_ailment.ailment = ?1 ", nativeQuery = true)
	List<Passive> findPassiveByAilment(BigInteger code);

	@Query(value = "select passive.* from passive inner join skill on skill.code = passive.skill where skill.code = ?1 ", nativeQuery = true)
	List<Passive> findPassiveBySkill(BigInteger code);

	@Query(value = "select passive.* from passive inner join skill_buff on skill_buff.code = passive.code where skill_buff.buff = ?1 ", nativeQuery = true)
	List<Passive> findPassiveByBuff(BigInteger code);
}