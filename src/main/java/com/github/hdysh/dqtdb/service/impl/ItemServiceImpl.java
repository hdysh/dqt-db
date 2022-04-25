package com.github.hdysh.dqtdb.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.hdysh.dqtdb.model.Equip;
import com.github.hdysh.dqtdb.model.Item;
import com.github.hdysh.dqtdb.repository.ItemRepository;
import com.github.hdysh.dqtdb.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepository;

	@Override
	public List<Item> getAllItems() {
		return itemRepository.findAllItem();
	}

	@Override
	public Item getItem(BigInteger id) {
		return itemRepository.findItemByCode(id);
	}
	@Override
	public Equip getEquip(BigInteger id) {
		return itemRepository.findEquipByCode(id);
	}

	@Override
	public List<Object[]> getItemLocs(BigInteger id) {
		return itemRepository.findItemLocs(id);
	}

	@Override
	public List<Object[]> getItemLocsFirst(BigInteger id) {
		return itemRepository.findItemLocsFirst(id);
	}

}