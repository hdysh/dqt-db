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
@Table(name = "unit_skill")
@Data 
@ToString
public class UnitSkill  {


	private @Id BigInteger id;
	private   BigInteger code;
	private BigInteger level; 

	@ManyToOne(targetEntity = Skill.class)
	@JoinColumn(name = "skill")
	private Skill skill;
}
