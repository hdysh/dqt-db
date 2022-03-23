package com.github.hdysh.dqtdb.service.impl;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.hdysh.dqtdb.model.Passive;
import com.github.hdysh.dqtdb.model.UnitMin;
import com.github.hdysh.dqtdb.repository.PassiveRepository;
import com.github.hdysh.dqtdb.service.PassiveService;

@Service
public class PassiveServiceImpl implements PassiveService {

	@Autowired
	private PassiveRepository passiveRepository;

	@Override
	public Passive getPassive(BigInteger id) {
		return passiveRepository.findPassiveById(id);
	}

	@Override
	public List<Passive> getAllPassives() {
		return passiveRepository.getAllPassive();
	}

	@Override
	public List<UnitMin> getUnitByPassive(BigInteger id) {
		List<UnitMin> u = passiveRepository.findUnitByPassive(id);
		Collections.sort(u, new UnitMinComparator());
		return u;
	}

	@Override
	public List<UnitMin> getUnitByAwakening(BigInteger id) {
		List<UnitMin> u = passiveRepository.findUnitByAwakening(id);
		Collections.sort(u, new UnitMinComparator());
		return u;
	}
}