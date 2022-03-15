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
public class AbstractUnit<T extends AbstractUnit> {
	public @Id BigInteger code;
	 public	 String name;
	@ManyToOne(targetEntity = Family.class)
	@JoinColumn(name = "family")
	public	 Family family;
	@ManyToOne(targetEntity = Role.class)
	@JoinColumn(name = "role")
	public	 Role role;
	@ManyToOne(targetEntity = Rarity.class)
	@JoinColumn(name = "rarity")
	public Rarity rarity;
	public String icon;
}
