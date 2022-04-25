package com.github.hdysh.dqtdb.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "reaction_passive")
@Data
public class ReactionPassive {
	private @Id BigInteger code;
	private BigInteger skill;
	private String name, description;
	private int accuracy;
}