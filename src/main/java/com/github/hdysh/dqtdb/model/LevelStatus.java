package com.github.hdysh.dqtdb.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "level_status")
@Data
@ToString
@IdClass(LevelStatusKey.class)
public class LevelStatus {
	@Id
	private BigInteger code;
	@Id
	private BigInteger level;
	private BigInteger value;
	private String icon;
}