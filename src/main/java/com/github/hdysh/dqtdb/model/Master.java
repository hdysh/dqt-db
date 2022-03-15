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
@Table(name = "master")
@Data
public class Master {
	private @Id BigInteger code; 

	@OneToOne(fetch = FetchType.EAGER ,targetEntity = StatsRank.class)
	@JoinColumn(name = "stats")
	private StatsRank  stats;

}
