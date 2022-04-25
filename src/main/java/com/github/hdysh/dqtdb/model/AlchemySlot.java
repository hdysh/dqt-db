package com.github.hdysh.dqtdb.model;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
 
@Entity
@Table(name = "alchemy_slot")
@Data
public class AlchemySlot {

	private BigInteger code;
	private @Id BigInteger slot;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "code")
	private List<Alchemy> alchemy;
}
