package com.github.hdysh.dqtdb.model;

import java.math.BigInteger;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@MappedSuperclass
@EqualsAndHashCode(callSuper = false)
public class AbstractUnit {
	public @Id BigInteger code;
	@ManyToOne(targetEntity = Profile.class)
	@JoinColumn(name = "profile")
	public Profile profile;
	@ManyToOne(targetEntity = Rarity.class)
	@JoinColumn(name = "rarity")
	public Rarity rarity;
	private int weight;
	private int talent;  
}
