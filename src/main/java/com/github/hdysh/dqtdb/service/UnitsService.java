package com.github.hdysh.dqtdb.service;

import java.math.BigInteger;
import java.util.List;

import com.github.hdysh.dqtdb.model.UnitDrop;
import com.github.hdysh.dqtdb.model.UnitMin;

public interface UnitsService {
	List<UnitMin> getAll();

	List<UnitMin> getUnits(List<BigInteger> ids);

	List<UnitDrop> getAllUnitDrop();

}