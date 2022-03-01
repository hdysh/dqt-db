package com.pokiltenan.dqtdb.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "unit_drop")
public class UnitDrop {

	private @Id BigInteger code; 
	private String unit; 
	private String stage;
	private int rate;
	private int stamina; 

	public BigInteger getCode() {
		return code;
	}

	public void setCode(BigInteger code) {
		this.code = code;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public int getStamina() {
		return stamina;
	}

	public void setStamina(int stamina) {
		this.stamina = stamina;
	}

	public String[] getStageSplit() {
		return stage.split("~");
	}

	public String[] getUnitSplit() {
		return unit.split("~");
	}
 

}
