package com.github.hdysh.dqtdb.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "enemies_map")
@Data
public class Enemy {
	private @Id BigInteger code;
	@OneToOne(targetEntity = UnitEnemy.class)
	@JoinColumn(name = "enemy")
	private UnitEnemy enemy;

}
