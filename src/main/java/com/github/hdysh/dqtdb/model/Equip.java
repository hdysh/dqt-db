package com.github.hdysh.dqtdb.model;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "equip")
@Data
public class Equip {

	private @Id BigInteger code;
	@OneToOne(targetEntity = Item.class)
	@JoinColumn(name = "item")
	private Item item;
	@OneToOne(targetEntity = Passive.class)
	@JoinColumn(name = "base_passive")
	private Passive basePassive;
	@OneToOne(targetEntity = Passive.class)
	@JoinColumn(name = "unique_passive")
	private Passive uniquePassive;
	@OneToOne(targetEntity = Passive.class)
	@JoinColumn(name = "reaction_passive")
	private Passive reactionPassive; 
	@OneToMany(mappedBy = "code")
	private List<AlchemySlot> alchemy;
}