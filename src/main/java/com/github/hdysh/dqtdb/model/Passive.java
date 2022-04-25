package com.github.hdysh.dqtdb.model;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "passive")
@Data
public class Passive {
	private @Id BigInteger code;
	private String name;
	private String description;
	private String leadericon;
	@OneToOne(targetEntity = EleRes.class)
	@JoinColumn(name = "eleres")
	private EleRes eleres;
	@OneToOne(fetch = FetchType.EAGER, targetEntity = StatsRank.class)
	@JoinColumn(name = "stats")
	private StatsRank stats;
	@OneToOne(targetEntity = SkillAilment.class)
	@JoinColumn(name = "ailment")
	private SkillAilment ailment;
	@OneToOne(targetEntity = Skill.class)
	@JoinColumn(name = "skill")
	private Skill skill;
	@OneToOne(targetEntity = Boost.class)
	@JoinColumn(name = "boost")
	private Boost boost;
	@OneToOne(targetEntity = MainEffect.class)
	@JoinColumn(name = "main_effect")
	private MainEffect mainEffect;
	@OneToOne(targetEntity = RepetitiveEffect.class)
	@JoinColumn(name = "repetitive_effect")
	private RepetitiveEffect repetitiveEffect;
	@OneToOne(targetEntity = Trigger.class)
	@JoinColumn(name = "trigger")
	private Trigger trigger;
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "code")
	private List<SkillBuff> buffs;
	@OneToMany(mappedBy = "code")
	private List<AlchemyIcon> icon;
	private int var;

	public String replaceName(String text, String target, String replacement) {
		return text.replaceAll(target, replacement);
	}

	public String getIcon() {
		if (icon.size() == 0) {
			return null;
		} else {
			return icon.get(0).getIcon();
		}
	}

	public String getVar() {
		DecimalFormat format = new DecimalFormat("0.#");
		double out = this.var;
		if (Math.abs(this.var) > 99) {
			out = this.var / 100.0;
		}
		return format.format(out);
	}
}
