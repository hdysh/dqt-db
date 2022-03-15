package com.github.hdysh.dqtdb.model;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class LevelStatusKey implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "code")
	private BigInteger code;

	private BigInteger level;
}
