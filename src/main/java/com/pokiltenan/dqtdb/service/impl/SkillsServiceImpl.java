package com.pokiltenan.dqtdb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokiltenan.dqtdb.model.Skill;
import com.pokiltenan.dqtdb.repository.SkillsRepository;
import com.pokiltenan.dqtdb.service.SkillsService;

@Service
public class SkillsServiceImpl implements SkillsService{

	@Autowired
	private SkillsRepository skillsRepository;


	@Override
	public List<Skill> getAllSkill() {
		return skillsRepository.findAllSkill();
	}

	
 
}