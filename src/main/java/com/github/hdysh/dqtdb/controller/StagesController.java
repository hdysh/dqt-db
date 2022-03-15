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

import com.github.hdysh.dqtdb.model.EventArea;
import com.github.hdysh.dqtdb.model.EventPortal;
import com.github.hdysh.dqtdb.model.Stage;
import com.github.hdysh.dqtdb.service.StagesService;

@Controller
@RequestMapping("/stages")
public class StagesController {
	@Autowired
	private StagesService stagesService;

	@GetMapping("/q")
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Stage>> getAll2() {
		List<Stage> stages = stagesService.getStages();
		return ResponseEntity.ok(stages);
	}

	@GetMapping("")
	@ResponseBody
	public ModelAndView showStages() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("stages");
		List<Stage> units = stagesService.getStages();
		modelAndView.addObject("lists", units);
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView showEventStage(@PathVariable(value = "id") BigInteger id) {
		ModelAndView modelAndView = new ModelAndView("stage");
		Stage stage = stagesService.getStage(id);
		modelAndView.addObject("stage", stage);
		EventArea area = stagesService.getArea(stage.getArea());
		modelAndView.addObject("area", area);
		EventPortal portal = stagesService.getPortal(area.getEventPortal());
		modelAndView.addObject("portal", portal);
		return modelAndView;
	}
}
