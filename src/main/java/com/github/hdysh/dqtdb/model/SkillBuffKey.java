package com.github.hdysh.dqtdb.model;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Embeddable
@Data
public class SkillBuffKey implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "code")
	private BigInteger code;

	@ManyToOne(targetEntity = Buff.class)
	@JoinColumn(name = "buff")
	private Buff buff;
}
