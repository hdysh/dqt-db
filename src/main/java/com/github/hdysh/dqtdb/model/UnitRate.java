package com.github.hdysh.dqtdb.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "skill_buff")
@Data
public class UnitRate {
	private @Id BigInteger code;
	private int rate;

}
