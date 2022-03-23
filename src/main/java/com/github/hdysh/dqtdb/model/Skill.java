package com.github.hdysh.dqtdb.model;

import java.math.BigInteger;
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

	public String getStrMul() {
		return multiplier / 10 + "";
	}

	public String getStrMaxMul() {
		return maxMul / 10 + "";
	}

}
