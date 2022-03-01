package com.pokiltenan.dqtdb.controller;

import java.math.BigInteger;
import java.util.ArrayList;
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

import com.pokiltenan.dqtdb.model.EventGroup;
import com.pokiltenan.dqtdb.model.UnitDrop;
import com.pokiltenan.dqtdb.service.EventService;
import com.pokiltenan.dqtdb.service.UnitsService;

@Controller
@RequestMapping("/")
public class MainController {

	@Autowired
	private UnitsService unitService;
	@Autowired
	private EventService eventService;

	@GetMapping("")
	public String home() {
		return "home";
	}

	@PostMapping("/unitdrop/q")
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<UnitDrop>> getAll() {
		List<String> temp = new ArrayList<>();
		List<UnitDrop> units = unitService.getAllUnitDrop();
		List<UnitDrop> u2 = new ArrayList<>();
		for (UnitDrop u : units) {
			if (!temp.contains(u.getUnitSplit()[0] + u.getStageSplit()[0] + u.getRate())) {
				temp.add(u.getUnitSplit()[0] + u.getStageSplit()[0] + u.getRate());
				u2.add(u);
			}
		}
		return ResponseEntity.ok(u2);
	}

	@GetMapping("/unitdrop")
	@ResponseBody
	public ModelAndView showUnits() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("unitdrop");
		return modelAndView;
	}

	@GetMapping("/story")
	@ResponseBody
	public ModelAndView showStory() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("story");
		List<EventGroup> units = eventService.getStoryGroups(new BigInteger("1"));
		modelAndView.addObject("lists", units);
		return modelAndView;
	}

	@GetMapping("/story/area/{id}")
	@ResponseBody
	public ModelAndView showStoryArea(@PathVariable(value = "id") BigInteger id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("eventgroup");
		List<EventGroup> units = eventService.getStoryGroups(id);
		modelAndView.addObject("lists", units);
		return modelAndView;
	}

	@GetMapping("/daily")
	@ResponseBody
	public ModelAndView showDaily() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("daily");
		List<EventGroup> units = eventService.getStoryGroups(new BigInteger("4"));
		modelAndView.addObject("lists", units);
		return modelAndView;
	}
}