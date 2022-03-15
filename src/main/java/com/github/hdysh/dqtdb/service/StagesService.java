package com.github.hdysh.dqtdb.service;

import java.math.BigInteger;
import java.util.List;

import com.github.hdysh.dqtdb.model.EventArea;
import com.github.hdysh.dqtdb.model.EventGroup;
import com.github.hdysh.dqtdb.model.EventPortal;
import com.github.hdysh.dqtdb.model.Stage;

public interface StagesService {
	Stage getStage(BigInteger id);

	EventArea getArea(BigInteger id);

	EventPortal getPortal(BigInteger id);

	EventGroup getGroup(BigInteger id);

	List<Stage> getStages();

}