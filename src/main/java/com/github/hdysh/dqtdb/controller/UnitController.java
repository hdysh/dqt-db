package com.github.hdysh.dqtdb.controller;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.hdysh.dqtdb.model.AilmentResPair;
import com.github.hdysh.dqtdb.model.EleResPair;
import com.github.hdysh.dqtdb.model.Passive;
import com.github.hdysh.dqtdb.model.Stats;
import com.github.hdysh.dqtdb.model.StatsRank;
import com.github.hdysh.dqtdb.model.Unit;
import com.github.hdysh.dqtdb.model.UnitAwakening;
import com.github.hdysh.dqtdb.model.UnitPassive;
import com.github.hdysh.dqtdb.model.UnitTalent;
import com.github.hdysh.dqtdb.service.UnitService;

@Controller
@RequestMapping("/unit")
public class UnitController {

	@Autowired
	private UnitService unitService;

	@GetMapping("")
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Unit> getUnit(BigInteger id) {
		Unit unit = unitService.getUnit(id);
		return ResponseEntity.ok(unit);
	}

	@GetMapping("/{id}")
	public ModelAndView showUnit(@PathVariable(value = "id") BigInteger id) throws JsonProcessingException {
		ModelAndView modelAndView = new ModelAndView("unit");
		List<EleResPair> rl = new ArrayList<>();
		List<AilmentResPair> al = new ArrayList<>();
		Unit unit = unitService.getUnit(id);
		rl.add(calcEle(unit.getEleRes().getEle1(), "1"));
		rl.add(calcEle(unit.getEleRes().getEle2(), "2"));
		rl.add(calcEle(unit.getEleRes().getEle3(), "3"));
		rl.add(calcEle(unit.getEleRes().getEle4(), "4"));
		rl.add(calcEle(unit.getEleRes().getEle5(), "5"));
		rl.add(calcEle(unit.getEleRes().getEle6(), "6"));
		rl.add(calcEle(unit.getEleRes().getEle7(), "7"));
		modelAndView.addObject("eleres", rl);
		al.add(calcAilment(unit.getAilres().getAil1(), "ail1"));
		al.add(calcAilment(unit.getAilres().getAil2(), "ail2"));
		al.add(calcAilment(unit.getAilres().getAil3(), "ail3"));
		al.add(calcAilment(unit.getAilres().getAil4(), "ail4"));
		al.add(calcAilment(unit.getAilres().getAil5(), "ail5"));
		al.add(calcAilment(unit.getAilres().getAil6(), "ail6"));
		al.add(calcAilment(unit.getAilres().getAil7(), "ail7"));
		al.add(calcAilment(unit.getAilres().getAil8(), "ail8"));
		al.add(calcAilment(unit.getAilres().getAil9(), "ail9"));
		al.add(calcAilment(unit.getAilres().getAil10(), "ail10"));
		al.add(calcAilment(unit.getAilres().getAil11(), "ail11"));
		al.add(calcAilment(unit.getAilres().getAil12(), "ail12"));
		al.add(calcAilment(unit.getAilres().getAil13(), "ail13"));
		String[] strAilment = { "ail1", "ail4", "ail8", "ail10", "ail9", "ail11", "ail5", "ail2", "ail7", "ail6",
				"ail3", "ail12", "ail13" };
		modelAndView.addObject("strAilment", strAilment);

		modelAndView.addObject("ailres", al);
		final ObjectMapper mapper = new ObjectMapper();

		modelAndView.addObject("ailment", unitService.getAilments());

		Map<BigInteger, StatsRank> mapAwaAdd = new HashMap<>();
		Map<BigInteger, StatsRank> mapAwaMul = new HashMap<>();
		Map<BigInteger, StatsRank> mapPassAdd = new HashMap<>();
		Map<BigInteger, StatsRank> mapPassMul = new HashMap<>();
		for (int i = 0; i < 6; i++) {
			mapAwaMul.put(new BigInteger(String.valueOf(i)), new StatsRank(null));
			mapAwaAdd.put(new BigInteger(String.valueOf(i)), new StatsRank(null));
		}
		for (Stats s : unit.getStats()) {
			if (s.getRank() == 0) {
				mapPassMul.put(new BigInteger(String.valueOf("1")), new StatsRank(null));
				mapPassAdd.put(new BigInteger(String.valueOf("1")), new StatsRank(null));
			} else {
				mapPassMul.put(new BigInteger(String.valueOf(s.getLevel())), new StatsRank(null));
				mapPassAdd.put(new BigInteger(String.valueOf(s.getLevel())), new StatsRank(null));
			}
		}

		for (UnitAwakening ua : unit.getAwakenings()) {
			Passive awa = ua.getAwakening();
			if (awa != null) {
				add2Map(awa, mapAwaAdd, mapAwaMul, ua.getLevel());
			}
		}
		for (UnitPassive up : unit.getPassives()) {
			Passive pass = up.getPassive();
			if (pass != null) {
				add2Map(pass, mapPassAdd, mapPassMul, up.getLevel());
			}
		}
		Map<BigInteger, StatsRank> sortedAwaMul = mergeStats(mapAwaMul);
		Map<BigInteger, StatsRank> sortedAwaAdd = mergeStats(mapAwaAdd);
		Map<BigInteger, StatsRank> sortedPassMul = mergeStats(mapPassMul);
		Map<BigInteger, StatsRank> sortedPassAdd = mergeStats(mapPassAdd);
		StatsRank talentStats = new StatsRank(null);
		for (UnitTalent ut : unit.getTalents()) {
			if (ut.getAilRes() != null) {
			}
			if (ut.getEleRes() != null) {
			}
			if (ut.getSkill() != null) {
			}
			if (ut.getStats() != null) {
				talentStats.add(ut.getStats());
			}
		}
		try {
			modelAndView.addObject("awaAdd", mapper.writeValueAsString(sortedAwaAdd));
			modelAndView.addObject("awaMul", mapper.writeValueAsString(sortedAwaMul));
			modelAndView.addObject("passAdd", mapper.writeValueAsString(sortedPassAdd));
			modelAndView.addObject("passMul", mapper.writeValueAsString(sortedPassMul));
			modelAndView.addObject("talentStats", mapper.writeValueAsString(talentStats));
			List<Stats> st = unitService.findByCodezz(id);
			String stats = mapper.writeValueAsString(st);
			modelAndView.addObject("stats", stats);
			Map<BigInteger, StatsRank> master = unitService.getMasters();
			master.put(new BigInteger("0"), new StatsRank());
			String sm = mapper.writeValueAsString(master);
			modelAndView.addObject("master", sm);
		} catch (IOException e) {
			e.printStackTrace();
		}
		modelAndView.addObject(unit);
		return modelAndView;
	}

	private Map<BigInteger, StatsRank> mergeStats(Map<BigInteger, StatsRank> mapMul) {
		Map<BigInteger, StatsRank> sorted = mapMul.entrySet().stream()
				.sorted(Collections.reverseOrder(Map.Entry.comparingByKey())).collect(Collectors.toMap(
						Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		sorted.entrySet().stream().forEach(x -> {
			mapMul.entrySet().stream().filter(f -> f.getKey().compareTo(x.getKey()) < 0).forEach(y -> {
				x.getValue().add(y.getValue());
			});
		});
		return sorted;
	}

	void add2Map(Passive awa, Map<BigInteger, StatsRank> mapAdd, Map<BigInteger, StatsRank> mapMul, BigInteger level) {
		if (awa.getStats() != null) {
			if ("ADD".equals(awa.getStats().getStype())) {
				if (mapAdd.containsKey(level)) {
					mapAdd.get(level).add(awa.getStats());
				} else {
					StatsRank temp = new StatsRank(null);
					temp.add(awa.getStats());
					mapAdd.put(level, temp);
				}
			}
			if ("MUL".equals(awa.getStats().getStype())) {
				if (mapMul.containsKey(level)) {
					mapMul.get(level).add(awa.getStats());
				} else {
					StatsRank temp = new StatsRank(null);
					temp.add(awa.getStats());
					mapMul.put(level, temp);
				}

			}
		}
	}

	EleResPair calcEle(int ele, String strEle) {
		return new EleResPair(unitService.getCalcRes().floorEntry(new BigInteger(String.valueOf(ele))).getValue(),
				unitService.getElements().get(new BigInteger(strEle)));
	}

	AilmentResPair calcAilment(int ailment, String strailment) {
		return new AilmentResPair(
				unitService.getCalcRes().floorEntry(new BigInteger(String.valueOf(ailment))).getValue(),
				unitService.getAilments().get(strailment));
	}
}