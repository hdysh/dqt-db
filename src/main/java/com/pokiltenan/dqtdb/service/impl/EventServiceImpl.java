package com.pokiltenan.dqtdb.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokiltenan.dqtdb.model.EventArea;
import com.pokiltenan.dqtdb.model.EventGroup;
import com.pokiltenan.dqtdb.model.EventPortal;
import com.pokiltenan.dqtdb.model.Stage;
import com.pokiltenan.dqtdb.repository.EventRepository;
import com.pokiltenan.dqtdb.service.EventService;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventRepository eventRepository;

	@Override
	public List<EventPortal> getEventPostals() {
		return eventRepository.findAllEventPortal();
	}

	@Override
	public List<EventArea> getEventAreas(BigInteger id) {
		return eventRepository.findAllEventArea(id);
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

}