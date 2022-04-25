package com.github.hdysh.dqtdb.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.github.hdysh.dqtdb.model.Item;
import com.github.hdysh.dqtdb.model.Skill;
import com.github.hdysh.dqtdb.model.SkillMin;

@Repository
public interface SkillRepository extends CrudRepository<Skill, BigInteger> {
	@Query("select s from Skill s")
	List<Skill> getAllSkill();

	@Query("select s from Skill s WHERE s.code = ?1")
	Skill findSkillById(BigInteger code);

	@Query(value = "select value from enhancement  WHERE enhancement.code = ?1", nativeQuery = true)
	String findEnhancementById(BigInteger code);

	@Query("select s from SkillMin s where s.pc = 1")
	List<SkillMin> findAllSkill();

	@Query("SELECT i from Skill s, Item i WHERE s.code = i.skill AND s.code = ?1 ")
	Item findSkillScroll(BigInteger code);

//	@Query(value = "select *  from unit inner join unit_skill on unit.code = unit_skill.code where unit_skill.skill = ?1 order by rarity desc", nativeQuery = true)
//	List<UnitMin> findAllUnit(BigInteger skill);

}