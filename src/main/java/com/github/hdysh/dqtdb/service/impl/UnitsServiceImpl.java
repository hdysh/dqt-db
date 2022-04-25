package com.github.hdysh.dqtdb.service.impl;

import java.math.BigInteger;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.hdysh.dqtdb.model.UnitDrop;
import com.github.hdysh.dqtdb.model.UnitMin;
import com.github.hdysh.dqtdb.repository.UnitsRepository;
import com.github.hdysh.dqtdb.service.UnitsService;

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

	@Override
	public List<UnitMin> getUnits(List<BigInteger> codes) {
		List<UnitMin> u = unitsRepository.findAllById(codes); 
		Collections.sort(u, new UnitMinComparator());
		return u;
	}

}

class UnitMinComparator implements Comparator<UnitMin> {

	@Override
	public int compare(UnitMin o1, UnitMin o2) {
		if (o1.getRarity().getCode().intValue() == o2.getRarity().getCode().intValue()) {
			return (o1.getCode().intValue() > o2.getCode().intValue()) ? 1 : -1;
		}
		return ((o1.getRarity().getCode().intValue() < o2.getRarity().getCode().intValue()) ? 1 : -1);
	}
}
