package com.github.hdysh.dqtdb.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "skill_buff")
@Data
@IdClass(SkillBuffKey.class)
public class SkillBuff {
	@Id
	private BigInteger code;
	@ManyToOne(targetEntity = Buff.class)
	@JoinColumn(name = "buff")
	@Id
	private Buff buff;
	private int accuracy;
	private int level;
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

	public String getSuffix() {
		if (level > 0) {
			return buff.getSuffixUp();
		} else {
			return buff.getSuffixDown();
		}
	}

}
