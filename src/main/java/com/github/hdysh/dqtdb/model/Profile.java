package com.github.hdysh.dqtdb.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "profile")
@Data
public class Profile {
	public @Id BigInteger code;
	public String name;
	@ManyToOne(targetEntity = Family.class)
	@JoinColumn(name = "family")
	public Family family;
	@ManyToOne(targetEntity = Role.class)
	@JoinColumn(name = "role")
	public Role role;
	public String icon;
}
