package com.github.hdysh.dqtdb.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.github.hdysh.dqtdb.model.Ailment;
import com.github.hdysh.dqtdb.model.Buff;
import com.github.hdysh.dqtdb.model.SkillMin;

@Repository
public interface BuffRepository extends CrudRepository<SkillMin, BigInteger> {
	@Query("select a from Ailment a")
	List<Ailment> getAllAilment();

	@Query("select b from Buff b")
	List<Buff> getAllBuff();

	@Query("select a from Ailment a WHERE a.code = ?1")
	Ailment findAilmentById(BigInteger code);

	@Query("select b from Buff b WHERE b.code = ?1")
	Buff findBuffById(BigInteger id);

	@Query(value = "select * from skill inner join skill_ailment on skill.code = skill_ailment.code where skill.pc = 1 and skill_ailment.ailment = ?1 ", nativeQuery = true)
	List<SkillMin> findSkillByAilment(BigInteger ailment);

	@Query(value = "select * from skill inner join skill_buff on skill.code = skill_buff.code where skill.pc = 1 and skill_buff.level > 0 and skill_buff.buff = ?1 ", nativeQuery = true)
	List<SkillMin> findSkillByBuffUp(BigInteger buff);

	@Query(value = "select * from skill inner join skill_buff on skill.code = skill_buff.code where skill.pc = 1 and skill_buff.level < 0 and skill_buff.buff = ?1 ", nativeQuery = true)
	List<SkillMin> findSkillByBuffDown(BigInteger buff);

	@Query(value = "select unit_skill.code from unit_skill inner join skill on skill.code = unit_skill.skill where skill.code in (:ids) ", nativeQuery = true)
	List<BigInteger> findUIDBySkills(List<BigInteger> ids);

	@Query(value = "select unit_skill.code from unit_skill inner join skill on skill.code = unit_skill.skill where skill.code = ?1 ", nativeQuery = true)
	List<BigInteger> findUIDByAilment(BigInteger buff);

}