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

import com.github.hdysh.dqtdb.model.Passive;
import com.github.hdysh.dqtdb.model.PassiveMin;
import com.github.hdysh.dqtdb.model.UnitMin;
import com.github.hdysh.dqtdb.service.PassiveService;

@Controller
@RequestMapping("/")
public class PassiveController {

	@Autowired
	private PassiveService passiveService;

	@PostMapping("/passives/q")
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<PassiveMin>> getPassives() {
		List<PassiveMin> passives = passiveService.getAllPassives();
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
		List<UnitMin> unitsTalent = passiveService.getUnitByTalentPassive(id);
		modelAndView.addObject("unitsTalent", unitsTalent);
		return modelAndView;
	}

}