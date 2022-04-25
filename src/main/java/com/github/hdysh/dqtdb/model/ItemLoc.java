package com.github.hdysh.dqtdb.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class ItemLoc {
	private @Id BigInteger code;
	private String name;
	private int stamina;
	private BigInteger area;
	private int rate;
	private int quantity;
	private int first;
	private int slot;
}
