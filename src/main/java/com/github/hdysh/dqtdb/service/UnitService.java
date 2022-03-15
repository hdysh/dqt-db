package com.github.hdysh.dqtdb.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.github.hdysh.dqtdb.model.AilmentRes;
import com.github.hdysh.dqtdb.model.Element;
import com.github.hdysh.dqtdb.model.ResistanceLevel;
import com.github.hdysh.dqtdb.model.Stats;
import com.github.hdysh.dqtdb.model.StatsRank;
import com.github.hdysh.dqtdb.model.Unit;

public interface UnitService {
	Unit getUnit(BigInteger id);

	Map<BigInteger, Element> getElements();

	Map<String, AilmentRes> getAilments();

	List<ResistanceLevel> getResLevel();

	List<Stats> findByCodezz(BigInteger codezz);

	TreeMap<BigInteger, String> getCalcRes();

	Map<BigInteger, StatsRank> getMasters();
}