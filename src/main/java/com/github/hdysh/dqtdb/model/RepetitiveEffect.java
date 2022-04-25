package com.github.hdysh.dqtdb.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "repetitive_effect")
@Data
public class RepetitiveEffect {
	private @Id BigInteger code;
	private int probability, attenuation, times;
	private String name, description, message;
}