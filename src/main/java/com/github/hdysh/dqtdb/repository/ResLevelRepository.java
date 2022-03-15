package com.github.hdysh.dqtdb.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.github.hdysh.dqtdb.model.ResistanceLevel;

@Repository
public interface ResLevelRepository extends CrudRepository<ResistanceLevel, BigInteger> {

	@Query("select r from ResistanceLevel r")
	List<ResistanceLevel> getResLevel();
}
