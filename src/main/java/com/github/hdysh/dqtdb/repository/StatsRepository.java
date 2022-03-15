package com.github.hdysh.dqtdb.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.github.hdysh.dqtdb.model.Stats;

@Repository
public interface StatsRepository extends CrudRepository<Stats, BigInteger> {

	List<Stats> findByCodeOrderByRankAsc(BigInteger code);
}
