package com.pokiltenan.dqtdb;

import java.math.BigInteger;
import java.util.List;
import java.util.TreeMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.pokiltenan.dqtdb.model.ResistanceLevel;
import com.pokiltenan.dqtdb.repository.ResLevelRepository;

public class ResLevelLoader {

	@Autowired
	private ResLevelRepository repository;

	TreeMap<BigInteger, String> calcRes; 

	@PostConstruct
	public void initMethod() {
		List<ResistanceLevel> resLevel = repository.getResLevel();
		calcRes = new TreeMap<BigInteger, String>();
		for (ResistanceLevel rl : resLevel) {
			calcRes.put(rl.getMinv(), rl.getIcon());
		}  
	}

	public TreeMap<BigInteger, String> getCalcRes() {
		return calcRes;
	}
}
