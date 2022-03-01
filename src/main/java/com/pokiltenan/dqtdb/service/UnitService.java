package com.pokiltenan.dqtdb.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.pokiltenan.dqtdb.model.Ailment;
import com.pokiltenan.dqtdb.model.Element;
import com.pokiltenan.dqtdb.model.ResistanceLevel;
import com.pokiltenan.dqtdb.model.Stats;
import com.pokiltenan.dqtdb.model.StatsRank;
import com.pokiltenan.dqtdb.model.Unit;

public interface UnitService {
	Unit getUnit(BigInteger id);

	Map<BigInteger, Element> getElements();

	Map<String, Ailment> getAilments();

	List<ResistanceLevel> getResLevel();

	List<Stats> findByCodezz(BigInteger codezz);

	TreeMap<BigInteger, String> getCalcRes();

	Map<BigInteger, StatsRank> getMasters();
}