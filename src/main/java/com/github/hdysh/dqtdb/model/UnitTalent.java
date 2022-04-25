package com.github.hdysh.dqtdb.model;

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

	@ManyToOne(targetEntity = UnitAilmentRes.class)
	@JoinColumn(name = "ail_res")
	private UnitAilmentRes ailRes;
	@ManyToOne(targetEntity = EleRes.class)
	@JoinColumn(name = "ele_res")
	private EleRes eleRes;
	@ManyToOne(targetEntity = StatsRank.class)
	@JoinColumn(name = "stats")
	private StatsRank stats;
	@ManyToOne(targetEntity = Skill.class)
	@JoinColumn(name = "skill")
	private Skill skill;
	@ManyToOne(targetEntity = Passive.class)
	@JoinColumn(name = "passive")
	private Passive passive;
	@ManyToOne(targetEntity = IncreaseDamage.class)
	@JoinColumn(name = "brilliant")
	private IncreaseDamage increaseDamage;
	@ManyToOne(targetEntity = ReactionPassive.class)
	@JoinColumn(name = "reaction_passive")
	private ReactionPassive reactionPassive;
	@ManyToOne(targetEntity = SkillTypeRes.class)
	@JoinColumn(name = "skill_type_res")
	private SkillTypeRes skillTypeRes;
	@ManyToOne(targetEntity = DamageCut.class)
	@JoinColumn(name = "damage_cut")
	private DamageCut damageCut;
	@ManyToOne(targetEntity = SkillAilment.class)
	@JoinColumn(name = "ailment")
	private SkillAilment skillAilment;
	@ManyToOne(targetEntity = RepetitiveEffect.class)
	@JoinColumn(name = "repetitive_effect")
	private RepetitiveEffect repetitiveEffect;
}
