package com.github.hdysh.dqtdb.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "main_effect")
@Data
public class MainEffect {
	private @Id BigInteger code;
	private int gutsProb;
	private int gutsAddProb;
	private int enhancAdd;
}
