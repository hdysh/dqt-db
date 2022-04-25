package com.github.hdysh.dqtdb.controller;

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

import com.github.hdysh.dqtdb.model.Ailment;
import com.github.hdysh.dqtdb.model.Buff;
import com.github.hdysh.dqtdb.model.Passive;
import com.github.hdysh.dqtdb.model.SkillMin;
import com.github.hdysh.dqtdb.model.UnitMin;
import com.github.hdysh.dqtdb.service.BuffService;
import com.github.hdysh.dqtdb.service.PassiveService;
import com.github.hdysh.dqtdb.service.UnitsService;

@Controller
@RequestMapping("/")
public class AilmentController {

	@Autowired
	private UnitsService unitService; 
	@Autowired
	private BuffService buffService;
	@Autowired
	private PassiveService passiveService;

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
		List<Passive> passives = passiveService.getPassiveByAilment(id);
		modelAndView.addObject("passives", passives);
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
		List<Passive> passives = passiveService.getPassiveByBuff(id);
		modelAndView.addObject("passives", passives);
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
}