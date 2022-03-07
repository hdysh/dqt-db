package com.pokiltenan.dqtdb.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "drops")
@Data
public class Drop {
	private @Id BigInteger id;
	private BigInteger code;
	@OneToOne(targetEntity = Item.class)
	@JoinColumn(name = "item")
	private Item item;
	private int minroll, maxroll, rate, quantity;
	private boolean first;
}
