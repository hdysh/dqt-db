package com.github.hdysh.dqtdb.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "alchemy")
@Data
public class Alchemy {

	private @Id BigInteger id;
	private BigInteger code;
	private int no;
	private int rate;
	@OneToOne(targetEntity = Passive.class)
	@JoinColumn(name = "passive")
	private Passive passive;
	@OneToOne(targetEntity = Passive.class)
	@JoinColumn(name = "reaction")
	private BigInteger reaction;
	private int first;
	private int alchemyType;
}
