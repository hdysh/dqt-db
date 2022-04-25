package com.github.hdysh.dqtdb.service.impl;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.hdysh.dqtdb.model.Passive;
import com.github.hdysh.dqtdb.model.PassiveMin;
import com.github.hdysh.dqtdb.model.UnitMin;
import com.github.hdysh.dqtdb.repository.PassiveRepository;
import com.github.hdysh.dqtdb.repository.UnitsRepository;
import com.github.hdysh.dqtdb.service.PassiveService;

@Service
public class PassiveServiceImpl implements PassiveService {

	@Autowired
	private PassiveRepository passiveRepository;
	@Autowired
	private UnitsRepository unitsRepository;

	@Override
	public Passive getPassive(BigInteger id) {
		return passiveRepository.findPassiveById(id);
	}

	@Override
	public List<PassiveMin> getAllPassives() {
		return passiveRepository.getAllPassive();
	}

	@Override
	public List<UnitMin> getUnitByPassive(BigInteger id) {
		List<UnitMin> u = unitsRepository.findUnitByPassive(id);
		Collections.sort(u, new UnitMinComparator());
		return u;
	}

	@Override
	public List<UnitMin> getUnitByAwakening(BigInteger id) {
		List<UnitMin> u = unitsRepository.findUnitByAwakening(id);
		Collections.sort(u, new UnitMinComparator());
		return u;
	}

	@Override
	public List<UnitMin> getUnitByTalentPassive(BigInteger id) {
		List<UnitMin> u = unitsRepository.findUnitByTalentPassive(id);
		Collections.sort(u, new UnitMinComparator());
		return u;
	}

	@Override
	public List<UnitMin> getUnitByLeaderSkill(BigInteger id) {
		List<UnitMin> u = unitsRepository.findUnitByLeader(id);
		Collections.sort(u, new UnitMinComparator());
		return u;
	}

	@Override
	public List<Passive> getPassiveByAilment(BigInteger id) {
		return passiveRepository.findPassiveByAilment(id);
	}

	@Override
	public List<Passive> getPassiveBySkill(BigInteger id) {
		return passiveRepository.findPassiveBySkill(id);
	}

	@Override
	public List<Passive> getPassiveByBuff(BigInteger id) {
		return passiveRepository.findPassiveByBuff(id);
	}
}