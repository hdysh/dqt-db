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

import com.pokiltenan.dqtdb.model.Skill;
import com.pokiltenan.dqtdb.service.SkillsService;

@Controller
@RequestMapping("/skills")
public class SkillsController {

	@Autowired
	private SkillsService skillsService;

	@PostMapping("/q")
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Skill>> getAll() {
		List<Skill> skills = skillsService.getAllSkill();
		return ResponseEntity.ok(skills);
	}

	@GetMapping("/q")
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Skill>> getAll2() {
		List<Skill> skills = skillsService.getAllSkill();
		return ResponseEntity.ok(skills);
	}

	@GetMapping("")
	@ResponseBody
	public ModelAndView showUnits() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("skills");
		return modelAndView;
	}

}