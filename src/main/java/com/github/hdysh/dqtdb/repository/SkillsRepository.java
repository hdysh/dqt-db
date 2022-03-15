package com.github.hdysh.dqtdb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.github.hdysh.dqtdb.model.Skill;

@Repository
public interface SkillsRepository extends CrudRepository<Skill, Integer> {
	@Query(value = "select s from Skill s where s.pc = 1")
	List<Skill> findAllSkill();

}