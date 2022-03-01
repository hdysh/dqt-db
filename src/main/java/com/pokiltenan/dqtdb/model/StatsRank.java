package com.pokiltenan.dqtdb.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "stats")
@Data
public class StatsRank {
	private @Id BigInteger code;
	private int level, hp, mp, attack, defense, intelligence, agility, mobility;
	private int rank;
	private String stype;

	public StatsRank() {
	}

	public StatsRank(BigInteger code) {
		this.code = code;
		this.level = 0;
		this.hp = 0;
		this.mp = 0;
		this.attack = 0;
		this.defense = 0;
		this.intelligence = 0;
		this.agility = 0;
		this.mobility = 0;

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

	public void add(StatsRank data) {
		this.level = data.level;
		this.hp += data.hp;
		this.mp += data.mp;
		this.attack += data.attack;
		this.defense += data.defense;
		this.intelligence += data.intelligence;
		this.agility += data.agility;
		this.mobility += data.mobility;
		this.rank = data.getRank();
	}
}
