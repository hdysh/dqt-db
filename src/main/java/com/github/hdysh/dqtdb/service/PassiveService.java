package com.github.hdysh.dqtdb.service;

import java.math.BigInteger;
import java.util.List;

import com.github.hdysh.dqtdb.model.Passive;
import com.github.hdysh.dqtdb.model.UnitMin;

public interface PassiveService {
	Passive getPassive(BigInteger id);

	List<Passive> getAllPassives();

	List<UnitMin> getUnitByPassive(BigInteger id);

	List<UnitMin> getUnitByAwakening(BigInteger id);
}