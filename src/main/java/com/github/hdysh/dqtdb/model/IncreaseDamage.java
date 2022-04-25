package com.github.hdysh.dqtdb.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "increase_brilliant")
@Data
public class IncreaseDamage {
	private @Id BigInteger code;
	private BigInteger element, atype, family;
	private int damage;
	private String name, description;
}