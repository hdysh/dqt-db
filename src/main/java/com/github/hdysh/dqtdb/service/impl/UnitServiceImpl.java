package com.github.hdysh.dqtdb.service.impl;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.github.hdysh.dqtdb.model.AilmentRes;
import com.github.hdysh.dqtdb.model.Element;
import com.github.hdysh.dqtdb.model.Master;
import com.github.hdysh.dqtdb.model.ResistanceLevel;
import com.github.hdysh.dqtdb.model.Stats;
import com.github.hdysh.dqtdb.model.StatsRank;
import com.github.hdysh.dqtdb.model.Unit;
import com.github.hdysh.dqtdb.repository.StatsRepository;
import com.github.hdysh.dqtdb.repository.UnitRepository;
import com.github.hdysh.dqtdb.service.UnitService;

@Service
public class UnitServiceImpl implements UnitService {

	@Autowired
	private UnitRepository unitRepository;
	@Autowired
	private StatsRepository statsRepository;
	Map<BigInteger, Element> ele;
	Map<String, AilmentRes> ail;
	TreeMap<BigInteger, String> calcRes;
	Map<BigInteger, StatsRank> master;

	@PostConstruct
	public void initMethod() {
		List<ResistanceLevel> resLevel = unitRepository.getResLevel();
		calcRes = new TreeMap<BigInteger, String>();
		for (ResistanceLevel rl : resLevel) {
			calcRes.put(rl.getMinv(), rl.getIcon());
		}
		List<Element> eleList = unitRepository.getAllElement();
		ele = new HashMap<>();
		for (Element e : eleList) {
			ele.put(e.getCode(), e);
		}
		List<AilmentRes> ailList = unitRepository.getAllAilment();
		ail = new HashMap<>();
		for (AilmentRes a : ailList) {
			ail.put("ail" + a.getCode(), a);
		}
		List<Master> masterList = unitRepository.getAllMaster();
		master = new HashMap<>();
		for (Master a : masterList) {
			master.put(a.getCode(), a.getStats());
		}
	}

	@Override
	public Unit getUnit(BigInteger id) {
		return unitRepository.findUnitById(id);
	}

	@Override
	public TreeMap<BigInteger, String> getCalcRes() {
		return calcRes;
	}

	@Override
	public Map<BigInteger, Element> getElements() {
		return ele;
	}

	@Override
	public Map<String, AilmentRes> getAilments() {
		return ail;
	}

	@Override
	public Map<BigInteger, StatsRank> getMasters() {
		return master;
	}

	@Override
	public List<ResistanceLevel> getResLevel() {
		return unitRepository.getResLevel();
	}

	@Override
	public List<Stats> findByCodezz(BigInteger id) {
		return statsRepository.findByCodeOrderByRankAsc(id);
	}
}