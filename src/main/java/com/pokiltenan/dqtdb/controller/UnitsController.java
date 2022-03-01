package com.pokiltenan.dqtdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.pokiltenan.dqtdb.model.UnitMin;
import com.pokiltenan.dqtdb.service.UnitsService;

@Controller
@RequestMapping("/units")
public class UnitsController {

	@Autowired
	private UnitsService unitService;

	@PostMapping("/q") 
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<UnitMin>> getAll() {
		List<UnitMin> units = unitService.getAll();
		return ResponseEntity.ok(units);
	}

	@GetMapping("/q")
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<UnitMin>> getAll2() {
		List<UnitMin> units = unitService.getAll();
		return ResponseEntity.ok(units);
	}

	@GetMapping("")
	@ResponseBody
	public ModelAndView showUnits() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("units");
		List<UnitMin> units = unitService.getAll();
		modelAndView.addObject("lists", units);
		return modelAndView;
	}


}