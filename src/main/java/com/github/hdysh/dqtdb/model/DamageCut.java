package com.github.hdysh.dqtdb.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "damage_cut")
@Data
public class DamageCut {
	private @Id BigInteger code;
	private String name, description;
	private int damage;
}