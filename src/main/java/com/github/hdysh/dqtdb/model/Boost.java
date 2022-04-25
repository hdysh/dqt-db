package com.github.hdysh.dqtdb.model;

import java.math.BigInteger;
import java.text.DecimalFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "boost")
@Data
public class Boost {
	private @Id BigInteger code;
	private int damageIncrease;
	private int healingIncrease;
	private int mpDamageIncrease;
	private int mpHealingIncrease;
	private int requiredMpReduction;
	private int activeElement;
	@OneToOne(targetEntity = Element.class)
	@JoinColumn(name = "element")
	private Element element;
	private int activeType;
	@OneToOne(targetEntity = SkillType.class)
	@JoinColumn(name = "skill_type")
	private SkillType skillType;
	@OneToOne(targetEntity = Family.class)
	@JoinColumn(name = "family")
	private Family family;
	@OneToOne(targetEntity = Skill.class)
	@JoinColumn(name = "skill")
	private Skill skill;

	public String getMpReduction() {
		return format(Math.abs(this.requiredMpReduction));
	}

	public String getDamageIncrease() {
		return format(damageIncrease);
	}

	public String getHealingIncrease() {
		return format(healingIncrease);
	}

	public String getMpDamageIncrease() {
		return format(mpDamageIncrease);
	}

	public String getMpHealingIncrease() {
		return format(mpHealingIncrease);
	}

	private String format(double in) {
		if (Math.abs(in) > 99) {
			in = in / 100.0;
		}
		DecimalFormat format = new DecimalFormat("0.#");
		return format.format(in);
	}
}
