package com.github.hdysh.dqtdb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.hdysh.dqtdb.model.SkillMin;
import com.github.hdysh.dqtdb.repository.SkillRepository;
import com.github.hdysh.dqtdb.service.SkillsService;

@Service
public class SkillsServiceImpl implements SkillsService {

	@Autowired
	private SkillRepository skillRepository;

	@Override
	public List<SkillMin> getAllSkill() {
		return skillRepository.findAllSkill();
	}

}