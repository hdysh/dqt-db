package com.github.hdysh.dqtdb.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.hdysh.dqtdb.model.Ailment;
import com.github.hdysh.dqtdb.model.Buff;
import com.github.hdysh.dqtdb.model.SkillMin;
import com.github.hdysh.dqtdb.repository.BuffRepository;
import com.github.hdysh.dqtdb.service.BuffService;

@Service
public class BuffServiceImpl implements BuffService {

	@Autowired
	private BuffRepository buffRepository;

	@Override
	public Ailment getAilment(BigInteger id) {
		return buffRepository.findAilmentById(id);
	}

	@Override
	public Buff getBuff(BigInteger id) {
		return buffRepository.findBuffById(id);
	}

	@Override
	public List<Ailment> getAllAilments() {
		return buffRepository.getAllAilment();
	}

	@Override
	public List<Buff> getAllBuffs() {
		return buffRepository.getAllBuff();
	}

	@Override
	public List<SkillMin> getSkillByAilment(BigInteger id) {
		return buffRepository.findSkillByAilment(id);
	}

	@Override
	public List<SkillMin> getSkillByBuffUp(BigInteger id) {
		return buffRepository.findSkillByBuffUp(id);
	}

	@Override
	public List<SkillMin> getSkillByBuffDown(BigInteger id) {
		return buffRepository.findSkillByBuffDown(id);
	}

	@Override
	public List<BigInteger> getUIDBySkills(List<BigInteger> ids) {
		return buffRepository.findUIDBySkills(ids);
	}
}