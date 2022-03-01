package com.pokiltenan.dqtdb.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Stats {
	private @Id BigInteger id;
	private BigInteger code;
	private int level, hp, mp, attack, defense, intelligence, agility, mobility, rank;
	private String stype;

	public Stats() {
	}

	public void addLevel(int val) {
		this.level += val;
	}

	public void addHp(int val) {
		this.hp += val;
	}

	public void addMp(int val) {
		this.mp += val;
	}

	public void addAttack(int val) {
		this.attack += val;
	}

	public void addDefense(int val) {
		this.defense += val;
	}

	public void addIntelligence(int val) {
		this.intelligence += val;
	}

	public void addAgility(int val) {
		this.agility += val;
	}

	public void addMobility(int val) {
		this.mobility += val;
	}

	public void add(Stats data) {
		this.level = data.level;
		this.hp += data.hp;
		this.mp += data.mp;
		this.attack += data.attack;
		this.defense += data.defense;
		this.intelligence += data.intelligence;
		this.agility += data.agility;
		this.mobility += data.mobility;
	}
}
