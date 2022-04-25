package com.github.hdysh.dqtdb.service;

import java.math.BigInteger;
import java.util.List;

import com.github.hdysh.dqtdb.model.Passive;
import com.github.hdysh.dqtdb.model.PassiveMin;
import com.github.hdysh.dqtdb.model.UnitMin;

public interface PassiveService {
	Passive getPassive(BigInteger id);

	List<PassiveMin> getAllPassives();

	List<UnitMin> getUnitByPassive(BigInteger id);

	List<UnitMin> getUnitByAwakening(BigInteger id);

	List<UnitMin> getUnitByTalentPassive(BigInteger id);

	List<UnitMin> getUnitByLeaderSkill(BigInteger id);

	List<Passive> getPassiveByAilment(BigInteger id);

	List<Passive> getPassiveBySkill(BigInteger id);

	List<Passive> getPassiveByBuff(BigInteger id);
}