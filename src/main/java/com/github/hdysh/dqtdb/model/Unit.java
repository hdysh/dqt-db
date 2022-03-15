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
import javax.persistence.OrderBy;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "unit")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString
@SecondaryTable(name = "unit_rate", pkJoinColumns = @PrimaryKeyJoinColumn(name = "code", referencedColumnName = "code"))
public class Unit extends AbstractUnit {
	private @Id BigInteger code;
	private String name;
	@ManyToOne(targetEntity = Family.class)
	@JoinColumn(name = "family")
	private Family family;
	@ManyToOne(targetEntity = Role.class)
	@JoinColumn(name = "role")
	private Role role;
	@ManyToOne(targetEntity = Rarity.class)
	@JoinColumn(name = "rarity")
	private Rarity rarity;
	private String icon;

	@OneToOne(targetEntity = EleRes.class)
	@JoinColumn(name = "code")
	private EleRes eleRes;
//	@OneToOne(targetEntity = UnitEleRes.class)
//	@JoinColumn(name = "code")
//	private EleRes unitEleRes;
	@ManyToOne(targetEntity = UnitAilmentRes.class)
	@JoinColumn(name = "ailres")
	private UnitAilmentRes ailres;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "code")
	@OrderBy("level")
	private List<UnitPassive> passives;
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "code")
	@OrderBy("level")
	private List<UnitAwakening> awakenings;
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "code")
	@OrderBy("level")
	private List<UnitSkill> skills;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "code")
	private List<Stats> stats;
	@OneToOne(targetEntity = Passive.class)
	@JoinColumn(name = "leader")
	private Passive leader;
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "code")
	private List<UnitTalent> talents;

}
