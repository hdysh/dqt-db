package com.pokiltenan.dqtdb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pokiltenan.dqtdb.model.UnitDrop;
import com.pokiltenan.dqtdb.model.UnitMin;

@Repository
public interface UnitsRepository extends JpaRepository<UnitMin, Integer> {
	@Query(value = "select * from unit u", nativeQuery = true)
	List<UnitMin> findAllUnit();

	@Query("select u from UnitDrop u")
	List<UnitDrop> findAllUnitDrop();
}