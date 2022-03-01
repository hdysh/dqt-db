package com.pokiltenan.dqtdb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokiltenan.dqtdb.model.UnitDrop;
import com.pokiltenan.dqtdb.model.UnitMin;
import com.pokiltenan.dqtdb.repository.UnitsRepository;
import com.pokiltenan.dqtdb.service.UnitsService;

@Service
public class UnitsServiceImpl implements UnitsService {

	@Autowired
	private UnitsRepository unitsRepository;

	@Override
	public List<UnitMin> getAll() {
		return unitsRepository.findAllUnit();
	}

	@Override
	public List<UnitDrop> getAllUnitDrop() {
		return unitsRepository.findAllUnitDrop();
	}

}