package com.pokiltenan.dqtdb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pokiltenan.dqtdb.model.ResistanceLevel;

@Repository
public interface ResLevelRepository extends CrudRepository<ResistanceLevel, Integer> {

	@Query("select r from ResistanceLevel r")
	List<ResistanceLevel> getResLevel();
}
