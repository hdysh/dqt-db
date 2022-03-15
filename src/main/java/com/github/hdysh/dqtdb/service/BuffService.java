package com.github.hdysh.dqtdb.service;

import java.math.BigInteger;
import java.util.List;

import com.github.hdysh.dqtdb.model.Ailment;
import com.github.hdysh.dqtdb.model.Buff;
import com.github.hdysh.dqtdb.model.SkillMin;

public interface BuffService {
	Ailment getAilment(BigInteger id);

	Buff getBuff(BigInteger id);

	List<Ailment> getAllAilments();

	List<Buff> getAllBuffs();

	List<SkillMin> getSkillByAilment(BigInteger id);

	List<SkillMin> getSkillByBuffUp(BigInteger id);

	List<SkillMin> getSkillByBuffDown(BigInteger id);

	List<BigInteger> getUIDBySkills(List<BigInteger> ids);
}