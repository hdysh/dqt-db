package com.github.hdysh.dqtdb.model;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Embeddable
@Data
public class BrMemberKey implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigInteger code;

	@ManyToOne(targetEntity = Unit.class)
	@JoinColumn(name = "unit")
	private Unit unit;
}
