package com.pokiltenan.dqtdb.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private int baseDamage, minDamage, maxDamage, accuracy, mp, multiplier, maxMul;
	@ManyToOne(targetEntity = Element.class)
	@JoinColumn(name = "element")
	private Element element;
	@ManyToOne(targetEntity = RaritySkill.class)
	@JoinColumn(name = "rarity")
	private RaritySkill rarity;
	@Transient
	private String strMul;
	@Transient
	private String strMaxMul;
	private int pc;

	public String getStrMul() {
		return multiplier / 10 + "%";
	}

	public String getStrMaxMul() {
		return maxMul / 10 + "%";
	}

}
