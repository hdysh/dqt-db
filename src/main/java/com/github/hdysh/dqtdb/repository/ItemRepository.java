package com.github.hdysh.dqtdb.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.github.hdysh.dqtdb.model.Equip;
import com.github.hdysh.dqtdb.model.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, BigInteger> {

	@Query("SELECT i FROM Item i WHERE i.code > 0")
	List<Item> findAllItem();

	Item findItemByCode(BigInteger code);

	@Query("SELECT i FROM Equip i WHERE i.code = ?1")
	Equip findEquipByCode(BigInteger code);

	@Query("SELECT s,d,i FROM Stage s, Drop d, Item i WHERE s.code=d.code AND d.item=i.code AND d.first=false AND i.code = ?1 ORDER BY (s.stamina*100.0/d.rate/d.quantity) ASC")
	List<Object[]> findItemLocs(BigInteger id);

	@Query("SELECT s,d,i FROM Stage s, Drop d, Item i WHERE s.code=d.code AND d.item=i.code AND d.first=true AND i.code = ?1 ORDER BY (s.stamina*100.0/d.rate/d.quantity) ASC")
	List<Object[]> findItemLocsFirst(BigInteger id);
}