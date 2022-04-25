package com.github.hdysh.dqtdb.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "item")
@Data
public class Item {
	private @Id BigInteger code;
	private String name, description, icon;
	private int max;
	@OneToOne(targetEntity = Skill.class)
	@JoinColumn(name = "skill")
	private Skill skill;
	@OneToOne(targetEntity = RarityItem.class)
	@JoinColumn(name = "consumable_rank")
	private RarityItem rankItem;
	@OneToOne(targetEntity = RarityEquip.class)
	@JoinColumn(name = "equip_rank")
	private RarityEquip rankEquip;
	private int type;
}
