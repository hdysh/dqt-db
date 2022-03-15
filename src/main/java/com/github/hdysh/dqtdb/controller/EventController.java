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
import com.github.hdysh.dqtdb.model.EventGroup;
import com.github.hdysh.dqtdb.model.EventPortal;
import com.github.hdysh.dqtdb.model.Stage;
import com.github.hdysh.dqtdb.service.EventService;
import com.github.hdysh.dqtdb.service.StagesService;

@Controller
@RequestMapping("/event")
public class EventController {
	@Autowired
	private EventService eventService;
	@Autowired
	private StagesService stagesService;

	@GetMapping("/q")
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<EventPortal>> getAll2() {
		List<EventPortal> stages = eventService.getEventPortals();
		return ResponseEntity.ok(stages);
	}

	@GetMapping("")
	@ResponseBody
	public ModelAndView showStages() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("event");
		List<EventPortal> portals = eventService.getEventPortals();
		modelAndView.addObject("portals", portals);
		List<EventPortal> remi = eventService.getRemiPortals();
		modelAndView.addObject("remi", remi);
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView showEvent(@PathVariable(value = "id") BigInteger id) {
		ModelAndView modelAndView = new ModelAndView("eventportal");
		List<EventArea> areas = eventService.getEventAreasByPortal(id);
		List<EventGroup> group = eventService.getEventGroups(id);
		modelAndView.addObject("areas", areas);
		modelAndView.addObject("group", group);
		EventPortal portal = stagesService.getPortal(id);
		modelAndView.addObject("portal", portal);
		return modelAndView;
	}

	@GetMapping("/group/{id}")
	public ModelAndView showEventGroup(@PathVariable(value = "id") BigInteger id) {
		ModelAndView modelAndView = new ModelAndView("eventgroup");
		List<EventArea> areas = eventService.getEventAreas(id);
		modelAndView.addObject("areas", areas);
		EventGroup group = stagesService.getGroup(id);
		EventPortal portal = stagesService.getPortal(group.getEventPortal());
		modelAndView.addObject("group", group);
		modelAndView.addObject("portal", portal);
		return modelAndView;
	}

	@GetMapping("/area/{id}")
	public ModelAndView showEventArea(@PathVariable(value = "id") BigInteger id) {
		ModelAndView modelAndView = new ModelAndView("eventarea");
		List<Stage> stages = eventService.getEventStages(id);
		modelAndView.addObject("stages", stages);
		EventArea area = stagesService.getArea(id);
		modelAndView.addObject("area", area);
		EventGroup group = stagesService.getGroup(area.getAreaGroup());
		if (group != null) {
			modelAndView.addObject("group", group);
		}
		if (area.getEventPortal() == null) {
			if (group != null) {
				EventPortal portal = stagesService.getPortal(group.getEventPortal());
				modelAndView.addObject("portal", portal);
			}
		} else {
			EventPortal portal = stagesService.getPortal(area.getEventPortal());
			modelAndView.addObject("portal", portal);
		}
		return modelAndView;
	}

}
