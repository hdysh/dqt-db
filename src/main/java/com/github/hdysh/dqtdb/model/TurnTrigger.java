package com.github.hdysh.dqtdb.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "turn_trigger")
@Data
public class TurnTrigger {
	private @Id BigInteger id;
	private BigInteger code;
	private BigInteger start;
	private BigInteger repeat;
	private BigInteger interval;
}