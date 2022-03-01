package com.pokiltenan.dqtdb.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokiltenan.dqtdb.model.Skill;
import com.pokiltenan.dqtdb.model.UnitMin;
import com.pokiltenan.dqtdb.repository.SkillRepository;
import com.pokiltenan.dqtdb.service.SkillService;

@Service
public class SkillServiceImpl implements SkillService {

	@Autowired
	private SkillRepository skillRepository;

	@Override
	public Skill getSkill(BigInteger id) {
		return skillRepository.findSkillById(id);
	}

	@Override
	public List<UnitMin> getUnits(BigInteger id) {
		return skillRepository.findAllUnit(id);
	}

}