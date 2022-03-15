package com.github.hdysh.dqtdb.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.hdysh.dqtdb.model.EventArea;
import com.github.hdysh.dqtdb.model.EventGroup;
import com.github.hdysh.dqtdb.model.EventPortal;
import com.github.hdysh.dqtdb.model.Stage;
import com.github.hdysh.dqtdb.repository.StagesRepository;
import com.github.hdysh.dqtdb.service.StagesService;

@Service
public class StagesServiceImpl implements StagesService {

	@Autowired
	private StagesRepository stagesRepository;

	@Override
	public List<Stage> getStages() {
		return stagesRepository.findAllStage();
	}

	@Override
	public Stage getStage(BigInteger id) {
		return stagesRepository.findStageById(id);
	}

	@Override
	public EventArea getArea(BigInteger id) {
		return stagesRepository.findAreaById(id);
	}

	@Override
	public EventPortal getPortal(BigInteger id) {
		return stagesRepository.findPortalById(id);
	}

	@Override
	public EventGroup getGroup(BigInteger id) {
		return stagesRepository.findGroupById(id);
	}

}