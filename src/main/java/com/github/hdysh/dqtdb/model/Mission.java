package com.github.hdysh.dqtdb.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "mission")
@Data
public class Mission {
	private @Id BigInteger code;
	@OneToOne(targetEntity = Item.class)
	@JoinColumn(name = "reward")
	private Item reward;
	private int quantity;
	private String condition;
	private String num;
	private String obj;

	public String[] getConditions() {
		return condition.split(",");
	}

	public String[] getNums() {
		return num.split(",");
	}

	public String[] getObjs() {
		return obj.split(",");
	}

}
