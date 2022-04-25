package com.github.hdysh.dqtdb.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "hero_quest")
@Data
@IdClass(HeroQuestKey.class)
public class HeroQuest {
	@Id
	private BigInteger code;
	@ManyToOne(targetEntity = Unit.class)
	@JoinColumn(name = "unit")
	@Id
	private Unit unit;
	private int required;
}
