package com.pokiltenan.dqtdb.service;

import java.util.List;

import com.pokiltenan.dqtdb.model.UnitDrop;
import com.pokiltenan.dqtdb.model.UnitMin;

public interface UnitsService {
	List<UnitMin> getAll();
	List<UnitDrop> getAllUnitDrop();

}