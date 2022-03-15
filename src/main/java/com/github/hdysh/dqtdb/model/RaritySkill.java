package com.github.hdysh.dqtdb.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "skill_rarity")
@Data
@ToString
public class RaritySkill {
	private @Id BigInteger code;
	private String name; 
	private String icon;  
	private String background; 

}
