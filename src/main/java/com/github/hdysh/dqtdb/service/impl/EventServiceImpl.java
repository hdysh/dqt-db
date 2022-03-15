package com.github.hdysh.dqtdb.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.hdysh.dqtdb.model.EventArea;
import com.github.hdysh.dqtdb.model.EventGroup;
import com.github.hdysh.dqtdb.model.EventPortal;
import com.github.hdysh.dqtdb.model.Stage;
import com.github.hdysh.dqtdb.repository.EventRepository;
import com.github.hdysh.dqtdb.service.EventService;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventRepository eventRepository;

	@Override
	public List<EventPortal> getEventPortals() {
		return eventRepository.getAllEventPortal();
	}

	@Override
	public List<EventPortal> getRemiPortals() {
		return eventRepository.getAllRemiPortal();
	}

	@Override
	public List<EventArea> getEventAreas(BigInteger id) {
		return eventRepository.findAllEventArea(id);
	}

	@Override
	public List<EventArea> getEventAreasByPortal(BigInteger id) {
		return eventRepository.findAllEventAreaByPortal(id);
	}

	@Override
	public List<Stage> getEventStages(BigInteger id) {
		return eventRepository.findAllEventStage(id);
	}

	@Override
	public List<EventArea> getStoryAreas() {
		return eventRepository.findAllStoryArea(1);
	}

	@Override
	public List<Stage> getStoryStages(BigInteger id) {
		return eventRepository.findAllStoryStage(id);
	}

	@Override
	public List<EventGroup> getEventGroups(BigInteger id) {
		return eventRepository.findAllEventGroup(id);
	}

	@Override
	public List<EventGroup> getStoryGroups(BigInteger id) {
		return eventRepository.findAllStoryGroup(id);
	}

	@Override
	public List<EventGroup> getBattleroads() {
		return eventRepository.findAllBattleroads();
	}

	@Override
	public List<EventGroup> getGroupDailies() {
		return eventRepository.findGroupDailies();
	}

	@Override
	public List<EventArea> getAreaDailies() {
		return eventRepository.findAreaDailies();
	}

	@Override
	public List<EventArea> getExtraArea() {
		return eventRepository.findExtraArea();
	}

	@Override
	public List<EventGroup> getExtraGroup() {
		return eventRepository.findExtraGroup();
	}
}