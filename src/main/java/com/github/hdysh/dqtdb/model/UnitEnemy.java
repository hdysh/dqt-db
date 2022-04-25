package com.github.hdysh.dqtdb.model;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "enemy")
@Data
@ToString
public class UnitEnemy {
	public @Id BigInteger code;
	@OneToOne(targetEntity = EleRes.class)
	@JoinColumn(name = "code")
	private EleRes eleRes;
	@ManyToOne(targetEntity = UnitAilmentRes.class)
	@JoinColumn(name = "ailres")
	private UnitAilmentRes ailres;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "code")
	private List<Stats> stats;
	private Integer rate;

	@OneToOne(targetEntity = Profile.class)
	@JoinColumn(name = "profile")
	private Profile profile;

}
