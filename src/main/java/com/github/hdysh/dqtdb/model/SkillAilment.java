package com.github.hdysh.dqtdb.model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "skill_ailment")
@Data
public class SkillAilment {
	private BigInteger id;
	private @Id  BigInteger code;
	@ManyToOne(targetEntity = Ailment.class)
	@JoinColumn(name = "ailment")
	private Ailment ailment;
	@Column(name="accuracy")
	private int accuracy;
	private int minDur;
	private int maxDur;

	public String getDuration() {
		String turn = " turn";
		if (minDur > 1) {
			turn += "s";
		}
		if (minDur == maxDur) {
			return minDur + turn;
		} else {
			return minDur + "-" + maxDur + turn;
		}
	}
}
