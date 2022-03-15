package com.github.hdysh.dqtdb.service;

import java.math.BigInteger;
import java.util.List;

import com.github.hdysh.dqtdb.model.Skill;
import com.github.hdysh.dqtdb.model.UnitMin;

public interface SkillService {
	Skill getSkill(BigInteger id);

	List<UnitMin> getUnits(BigInteger id);

}