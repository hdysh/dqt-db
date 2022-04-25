package com.github.hdysh.dqtdb.service;

import java.math.BigInteger;
import java.util.List;

import com.github.hdysh.dqtdb.model.Equip;
import com.github.hdysh.dqtdb.model.Item;

public interface ItemService {

	List<Item> getAllItems();

	Item getItem(BigInteger id);

	Equip getEquip(BigInteger id);

	List<Object[]> getItemLocs(BigInteger id);

	List<Object[]> getItemLocsFirst(BigInteger id);

}