package com.github.hdysh.dqtdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class InitController {
	@Autowired
	private Environment env;

	@ModelAttribute("divisor")
	public int divisor() {
		return Integer.parseInt(env.getProperty("dqt.divisor"));
	}

	@ModelAttribute("maxRank")
	public int maxRank() {
		return Integer.parseInt(env.getProperty("max.rank"));
	}

	@ModelAttribute("version")
	public int version() {
		return Integer.parseInt(env.getProperty("dqt.version"));
	}

	@ModelAttribute("gaid")
	public String gaid() {
		return env.getProperty("ga.id");
	}

	@ModelAttribute("jp")
	public String jp() {
		return env.getProperty("url.japan");
	}

	@ModelAttribute("gb")
	public String gb() {
		return env.getProperty("url.global");
	}
}
