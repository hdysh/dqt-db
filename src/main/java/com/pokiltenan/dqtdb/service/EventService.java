package com.pokiltenan.dqtdb.service;

import java.math.BigInteger;
import java.util.List;

import com.pokiltenan.dqtdb.model.EventArea;
import com.pokiltenan.dqtdb.model.EventGroup;
import com.pokiltenan.dqtdb.model.EventPortal;
import com.pokiltenan.dqtdb.model.Stage;

public interface EventService {
	List<EventPortal> getEventPostals();
	List<EventArea> getEventAreas(BigInteger id);
	List<Stage> getEventStages(BigInteger id);
	List<EventArea> getStoryAreas( );
	List<Stage> getStoryStages(BigInteger id);
	List<EventGroup> getEventGroups(BigInteger id);
	List<EventGroup> getStoryGroups(BigInteger id);
}