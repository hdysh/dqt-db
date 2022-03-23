package com.github.hdysh.dqtdb.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "skill")
@Data
@ToString
public class SkillMin {

	private @Id BigInteger code;

	private String name, icon, button;
	private int baseDamage, minDamage, maxDamage, accuracy, mp, multiplier, pc;
	@ManyToOne(targetEntity = Element.class)
	@JoinColumn(name = "element")
	private Element element;
	@ManyToOne(targetEntity = RaritySkill.class)
	@JoinColumn(name = "rarity")
	private RaritySkill rarity;
}
