package com.pokiltenan.dqtdb.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pokiltenan.dqtdb.model.Skill;
import com.pokiltenan.dqtdb.model.UnitMin;

@Repository
public interface SkillRepository extends CrudRepository<UnitMin, Integer> {
	@Query("select s from Skill s")
	List<Skill> getAllSkill();

	@Query("select s from Skill s WHERE s.code = ?1")
	Skill findSkillById(BigInteger code);

	@Query(value = "select *  from unit inner join unit_skill on unit.code = unit_skill.code where unit_skill.skill = ?1 order by rarity desc", nativeQuery = true)
	List<UnitMin> findAllUnit(BigInteger skill);

}