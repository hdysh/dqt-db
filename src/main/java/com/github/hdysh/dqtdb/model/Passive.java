package com.github.hdysh.dqtdb.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "passive")
@Data
public class Passive {
	private @Id BigInteger code;
	private String name;
	private String description;
	private String leadericon;
	@OneToOne(targetEntity = EleRes.class)
	@JoinColumn(name = "eleres")
	private EleRes eleres;

	@OneToOne(fetch = FetchType.EAGER, targetEntity = StatsRank.class)
	@JoinColumn(name = "stats")
	private StatsRank stats;
	private int var;

	public String replaceName(String text, String target, String replacement) {
		return text.replaceAll(target, replacement);
	}
}
