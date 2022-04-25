package com.github.hdysh.dqtdb.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.hdysh.dqtdb.model.Item;
import com.github.hdysh.dqtdb.model.Skill;
import com.github.hdysh.dqtdb.model.UnitMin;
import com.github.hdysh.dqtdb.repository.SkillRepository;
import com.github.hdysh.dqtdb.repository.UnitsRepository;
import com.github.hdysh.dqtdb.service.SkillService;

@Service
public class SkillServiceImpl implements SkillService {

	@Autowired
	private SkillRepository skillRepository;
	@Autowired
	private UnitsRepository unitsRepository;

	@Override
	public Skill getSkill(BigInteger id) {
		return skillRepository.findSkillById(id);
	}

	@Override
	public String getEnhancement(BigInteger id) {
		return skillRepository.findEnhancementById(id);
	}

	@Override
	public List<UnitMin> getUnits(BigInteger id) {
		return unitsRepository.findAllUnit(id);
	}

	@Override
	public Item getSkillScroll(BigInteger id) { 
		return skillRepository.findSkillScroll(id);
	}

}