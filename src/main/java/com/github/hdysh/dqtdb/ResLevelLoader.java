package com.github.hdysh.dqtdb;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.math.BigInteger;
import java.util.List;
import java.util.TreeMap;

import javax.annotation.PostConstruct;
  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;

import com.github.hdysh.dqtdb.model.ResistanceLevel;
import com.github.hdysh.dqtdb.repository.ResLevelRepository;

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

	public static String asString(Resource resource) {
		try (Reader reader = new InputStreamReader(resource.getInputStream(), "UTF-8")) {
			return FileCopyUtils.copyToString(reader);
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}
}
