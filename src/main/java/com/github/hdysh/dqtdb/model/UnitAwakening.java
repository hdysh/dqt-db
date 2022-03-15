package com.github.hdysh.dqtdb.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "unit_awakening")
@Data
@ToString
public class UnitAwakening {

	private @Id BigInteger id;
	private BigInteger code;
	private BigInteger level;

	@ManyToOne(targetEntity = Passive.class)
	@JoinColumn(name = "awakening")
	private Passive awakening;
}
