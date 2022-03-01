package com.pokiltenan.dqtdb.service;

import java.math.BigInteger;
import java.util.List;

import com.pokiltenan.dqtdb.model.Skill;
import com.pokiltenan.dqtdb.model.UnitMin;

public interface SkillService {
	Skill getSkill(BigInteger id);
	List<UnitMin> getUnits(BigInteger id);
}