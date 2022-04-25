package com.github.hdysh.dqtdb.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.github.hdysh.dqtdb.model.EventArea;
import com.github.hdysh.dqtdb.model.EventGroup;
import com.github.hdysh.dqtdb.model.UnitDrop;
import com.github.hdysh.dqtdb.service.EventService;
import com.github.hdysh.dqtdb.service.UnitsService;

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

	@GetMapping("/unitdrop/q")
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<UnitDrop>> getAll() {
		List<String> temp = new ArrayList<>();
		List<UnitDrop> units = unitService.getAllUnitDrop();
		Map<String, List<UnitDrop>> best = new HashMap<>();
		for (UnitDrop u : units) {
			String id = u.getUnitSplit()[0];
			double curentRate = 10000.0 / u.getRate() * u.getStamina();
			u.setStamrate(curentRate);
			if (best.containsKey(id)) {
				double bestRate = best.get(id).get(0).getStamrate();
				if (curentRate < bestRate) {
					u.setBest(true);
					for (UnitDrop unitDrop : best.get(id)) {
						unitDrop.setBest(false);
					}
					best.get(id).clear();
					best.get(id).add(u);
				} else if (curentRate == bestRate) {
					u.setBest(true);
					best.get(id).add(u);
				}
			} else {
				u.setBest(true);
				List<UnitDrop> list = new ArrayList<>();
				list.add(u);
				best.put(id, list);
			}
		}
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
		List<EventGroup> groups = eventService.getGroupDailies();
		modelAndView.addObject("groups", groups);
		List<EventArea> areas = eventService.getAreaDailies();
		modelAndView.addObject("areas", areas);
		return modelAndView;
	}

	@GetMapping("/battleroad")
	@ResponseBody
	public ModelAndView showBattleroad() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("battleroad");
		List<EventGroup> groups = eventService.getBattleroads();
		modelAndView.addObject("groups", groups);
		return modelAndView;
	}

	@GetMapping("/extra")
	@ResponseBody
	public ModelAndView showExtra() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("extra");
		List<EventArea> areas = eventService.getExtraArea();
		modelAndView.addObject("areas", areas);
		List<EventGroup> groups = eventService.getExtraGroup();
		modelAndView.addObject("groups", groups);
		return modelAndView;
	}
}