package com.github.hdysh.dqtdb.model;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "skill")
@Data
@ToString
public class Skill {

	private @Id BigInteger code;

	private String name, description, icon, button, range, reach;
	private int baseDamage, minDamage, maxDamage, accuracy, mp, multiplier, maxMul, usage, turn;
	@ManyToOne(targetEntity = Element.class)
	@JoinColumn(name = "element")
	private Element element;
	@ManyToOne(targetEntity = RaritySkill.class)
	@JoinColumn(name = "rarity")
	private RaritySkill rarity;
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "code")
	private List<SkillBuff> buffs;
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "code", referencedColumnName = "code")
	private List<SkillAilment> ailments;
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "code")
	private List<SkillEffect> effects;
	@Transient
	private String strMul;
	@Transient
	private String strMaxMul;
	private int pc;
	private int activeSkillAction;
	private int activeSkill;
	private int activeSkillTarget;
	private int damageCalculation;
	private int minInt;

	public double getConstant() {
		return minDamage - (multiplier / 1000.0) * minInt;
	}

	public String getMaxInt() {
		DecimalFormat format = new DecimalFormat("0.#");
		return format.format(Math.ceil((maxDamage - minDamage) / (multiplier / 1000.0) + minInt));
	}

	public String getFormula() {
		DecimalFormat format = new DecimalFormat("0.#");
		String add = " ";
		if (getConstant() > 0) {
			add = " + ";
		}
		String stat = "WIS";
		if (damageCalculation == 10) {
			stat = "ATK";
		}
		return stat + " * " + (multiplier / 1000.0) + add + format.format(getConstant());
	}

	public String getStrMul() {
		return multiplier / 10 + "";
	}

	public String getStrMaxMul() {
		return maxMul / 10 + "";
	}

	public SkillBuff getBuff() {
		if (buffs.size() > 0)
			return buffs.get(0);
		else
			return null;
	}

}
