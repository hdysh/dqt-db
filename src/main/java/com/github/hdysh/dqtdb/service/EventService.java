package com.github.hdysh.dqtdb.service;

import java.math.BigInteger;
import java.util.List;

import com.github.hdysh.dqtdb.model.EventArea;
import com.github.hdysh.dqtdb.model.EventGroup;
import com.github.hdysh.dqtdb.model.EventPortal;
import com.github.hdysh.dqtdb.model.Stage;

public interface EventService {
	List<EventPortal> getEventPortals();

	List<EventPortal> getRemiPortals();

	List<EventArea> getEventAreas(BigInteger id);

	List<EventArea> getEventAreasByPortal(BigInteger id);

	List<Stage> getEventStages(BigInteger id);

	List<EventArea> getStoryAreas();

	List<Stage> getStoryStages(BigInteger id);

	List<EventGroup> getEventGroups(BigInteger id);

	List<EventGroup> getStoryGroups(BigInteger id);

	List<EventGroup> getBattleroads();

	List<EventGroup> getGroupDailies();

	List<EventArea> getAreaDailies();

	List<EventArea> getExtraArea();

	List<EventGroup> getExtraGroup();
}