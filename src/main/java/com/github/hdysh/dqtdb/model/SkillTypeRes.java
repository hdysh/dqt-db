package com.github.hdysh.dqtdb.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "skill_type_res")
@Data
public class SkillTypeRes {
	private @Id BigInteger code;
	private BigInteger atype, element;
	private int rate;
	private String name, description;
}