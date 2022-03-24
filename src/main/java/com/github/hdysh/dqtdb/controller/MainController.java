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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.github.hdysh.dqtdb.model.Ailment;
import com.github.hdysh.dqtdb.model.Buff;
import com.github.hdysh.dqtdb.model.EventArea;
import com.github.hdysh.dqtdb.model.EventGroup;
import com.github.hdysh.dqtdb.model.Passive;
import com.github.hdysh.dqtdb.model.SkillMin;
import com.github.hdysh.dqtdb.model.UnitDrop;
import com.github.hdysh.dqtdb.model.UnitMin;
import com.github.hdysh.dqtdb.service.BuffService;
import com.github.hdysh.dqtdb.service.EventService;
import com.github.hdysh.dqtdb.service.PassiveService;
import com.github.hdysh.dqtdb.service.UnitsService;

@Controller
@RequestMapping("/")
public class MainController {

	@Autowired
	private UnitsService unitService;
	@Autowired
	private EventService eventService;
	@Autowired
	private BuffService buffService;
	@Autowired
	private PassiveService passiveService;

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

	@GetMapping("/ailment/{id}")
	@ResponseBody
	public ModelAndView showAilment(@PathVariable(value = "id") BigInteger id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("ailment");
		Ailment ailment = buffService.getAilment(id);
		modelAndView.addObject("ailment", ailment);
		List<SkillMin> skills = buffService.getSkillByAilment(id);
		modelAndView.addObject("skills", skills);
		List<BigInteger> sid = new ArrayList<>();
		for (SkillMin skillMin : skills) {
			sid.add(skillMin.getCode());
		}
		List<BigInteger> uid = buffService.getUIDBySkills(sid);
		List<UnitMin> units = unitService.getUnits(uid);
		modelAndView.addObject("units", units);
		return modelAndView;
	}

	@GetMapping("/buff/{id}")
	@ResponseBody
	public ModelAndView showBuff(@PathVariable(value = "id") BigInteger id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("buff");
		Buff buff = buffService.getBuff(id);
		modelAndView.addObject("buff", buff);
		List<SkillMin> skillup = buffService.getSkillByBuffUp(id);
		List<SkillMin> skilldown = buffService.getSkillByBuffDown(id);
		List<List<SkillMin>> skills = new ArrayList<>();
		skills.add(skillup);
		skills.add(skilldown);
		modelAndView.addObject("skills", skills);
		List<BigInteger> sidu = new ArrayList<>();
		List<BigInteger> sidd = new ArrayList<>();
		for (SkillMin skillMin : skillup) {
			sidu.add(skillMin.getCode());
		}
		for (SkillMin skillMin : skilldown) {
			sidd.add(skillMin.getCode());
		}
		List<BigInteger> uidu = buffService.getUIDBySkills(sidu);
		List<BigInteger> uidd = buffService.getUIDBySkills(sidd);
		List<UnitMin> unitup = unitService.getUnits(uidu);
		List<UnitMin> unitdown = unitService.getUnits(uidd);
		List<List<UnitMin>> units = new ArrayList<>();
		units.add(unitup);
		units.add(unitdown);
		modelAndView.addObject("units", units);
		return modelAndView;
	}

	@PostMapping("/ailments/q")
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Ailment>> getAilments() {
		List<Ailment> ailments = buffService.getAllAilments();
		return ResponseEntity.ok(ailments);
	}

	@GetMapping("/ailments")
	@ResponseBody
	public ModelAndView showAilments() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("ailments");
		return modelAndView;
	}

	@PostMapping("/buffs/q")
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Buff>> getBuffs() {
		List<Buff> buff = buffService.getAllBuffs();
		return ResponseEntity.ok(buff);
	}

	@GetMapping("/buffs")
	@ResponseBody
	public ModelAndView showBuffs() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("buffs");
		return modelAndView;
	}

	@PostMapping("/passives/q")
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Passive>> getPassives() {
		List<Passive> passives = passiveService.getAllPassives();
		return ResponseEntity.ok(passives);
	}

	@GetMapping("/passives")
	@ResponseBody
	public ModelAndView showPassives() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("passives");
		return modelAndView;
	}

	@GetMapping("/passive/{id}")
	@ResponseBody
	public ModelAndView showPassive(@PathVariable(value = "id") BigInteger id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("passive");
		Passive passive = passiveService.getPassive(id);
		modelAndView.addObject("passive", passive);
		List<UnitMin> unitsPass = passiveService.getUnitByPassive(id);
		modelAndView.addObject("unitsPass", unitsPass);
		List<UnitMin> unitsAwa = passiveService.getUnitByAwakening(id);
		modelAndView.addObject("unitsAwa", unitsAwa);
		List<UnitMin> unitsLead = passiveService.getUnitByLeaderSkill(id);
		modelAndView.addObject("unitsLead", unitsLead);
		return modelAndView;
	}
}