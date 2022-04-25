package com.github.hdysh.dqtdb.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.github.hdysh.dqtdb.model.Equip;
import com.github.hdysh.dqtdb.model.Item;
import com.github.hdysh.dqtdb.service.ItemService;

@Controller
@RequestMapping("/")
public class ItemController {

	@Autowired
	private ItemService itemService;

	@GetMapping("/item/{id}")
	@ResponseBody
	public ModelAndView showItem(@PathVariable(value = "id") BigInteger id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("item");
		Item item = itemService.getItem(id);
		modelAndView.addObject("item", item);
		Equip equip = itemService.getEquip(id);
		modelAndView.addObject("equip", equip);
		List<Object[]> itemLocs = itemService.getItemLocs(id);
		modelAndView.addObject("itemLocs", itemLocs);
		List<Object[]> itemLocsFirst = itemService.getItemLocsFirst(id);
		modelAndView.addObject("itemLocsFirst", itemLocsFirst);
		return modelAndView;
	}

	@PostMapping("/items/q")
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Item>> getItems() {
		List<Item> items = itemService.getAllItems();
		return ResponseEntity.ok(items);
	}

	@GetMapping("/items")
	@ResponseBody
	public ModelAndView showItems() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("items");
		return modelAndView;
	}
}