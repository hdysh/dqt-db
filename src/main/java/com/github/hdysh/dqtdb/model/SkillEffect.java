package com.github.hdysh.dqtdb.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "skill_effect")
@Data
public class SkillEffect {
	private @Id BigInteger id;
	private BigInteger code;
	private BigInteger effect;
	private int duration;
	private int multiplier;
	private int baseDamage;
	private int minDamage;
	private int maxDamage;
	private int intLimit;
	private int healMul;
	private int damageCalculation;

	public String getStrDuration() {
		if (duration == 1) {
			return duration + " turn";
		} else {
			return duration + " turns";
		}
	}

	public String getHeal() {
		return "heal " + minDamage + "-" + maxDamage + " hp";
	}

}
