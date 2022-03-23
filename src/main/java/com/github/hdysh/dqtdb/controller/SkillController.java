package com.github.hdysh.dqtdb.controller;

import java.math.BigInteger;
import java.util.List;

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

import com.github.hdysh.dqtdb.model.Skill;
import com.github.hdysh.dqtdb.model.UnitMin;
import com.github.hdysh.dqtdb.service.SkillService;

@Controller
@RequestMapping("/skill")
public class SkillController {

	@Autowired
	private SkillService skillService;

	@GetMapping("")
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Skill> getUnit(BigInteger id) {
		Skill skill = skillService.getSkill(id);
		return ResponseEntity.ok(skill);
	}

	@GetMapping("/{id}")
	public ModelAndView showSkill(@PathVariable(value = "id") BigInteger id) {
		ModelAndView modelAndView = new ModelAndView("skill");
		Skill skill = skillService.getSkill(id);
		List<UnitMin> units = skillService.getUnits(id);
		modelAndView.addObject(skill);
		modelAndView.addObject("units", units);
		String enhancement = skillService.getEnhancement(id);
		modelAndView.addObject("enhancement", enhancement);
		return modelAndView;
	}
}
