package com.pokiltenan.dqtdb.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "skill")
@Data
@ToString
public class SkillMin {

	private @Id BigInteger code;

	private String name, icon;
	private BigInteger element;

}
