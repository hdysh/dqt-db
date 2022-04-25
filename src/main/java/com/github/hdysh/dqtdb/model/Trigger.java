package com.github.hdysh.dqtdb.model;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "trigger")
@Data
@ToString
public class Trigger {
	private @Id BigInteger code;
	private BigInteger upperHp;
	private BigInteger lowerHp;
	private BigInteger probability;
	private BigInteger timing;
	private BigInteger paramType;
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "code")
	private List<TurnTrigger> turns;
}