package com.pokiltenan.dqtdb.service;

import java.math.BigInteger;
import java.util.List;

import com.pokiltenan.dqtdb.model.EventArea;
import com.pokiltenan.dqtdb.model.EventGroup;
import com.pokiltenan.dqtdb.model.EventPortal;
import com.pokiltenan.dqtdb.model.Stage;

public interface StagesService {
	Stage getStage(BigInteger id);

	EventArea getArea(BigInteger id);

	EventPortal getPortal(BigInteger id);

	EventGroup getGroup(BigInteger id);

	List<Stage> getStages();

}