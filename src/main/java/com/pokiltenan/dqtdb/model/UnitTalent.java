package com.pokiltenan.dqtdb.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "unit_talent")
@Data
@ToString
public class UnitTalent {
	private @Id BigInteger id;
	private BigInteger code;
	private BigInteger no;

	@ManyToOne(targetEntity = AilmentRes.class)
	@JoinColumn(name = "ail_res")
	private AilmentRes ailRes;
	@ManyToOne(targetEntity = EleRes.class)
	@JoinColumn(name = "ele_res")
	private EleRes eleRes;
	@ManyToOne(targetEntity = StatsRank.class)
	@JoinColumn(name = "stats")
	private StatsRank stats;
	@ManyToOne(targetEntity = Skill.class)
	@JoinColumn(name = "skill")
	private Skill skill;
}
