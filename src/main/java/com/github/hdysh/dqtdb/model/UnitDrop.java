package com.github.hdysh.dqtdb.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Table(name = "unit_drop")
@Data
public class UnitDrop {

	private @Id BigInteger code;
	private BigInteger base;
	private String unit;
	private String stage;
	private String portal;
	private int rate;
	private int stamina;
	@Transient
	private boolean best;
	@Transient
	private double stamrate;

	public double getStamrate() {
		return 10000.0 / rate * stamina;
	}

	public void setStamrate(double stamrate) {
		this.stamrate = stamrate;
	}

	public boolean isBest() {
		return best;
	}

	public void setBest(boolean best) {
		this.best = best;
	}

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

	public String[] getPortalSplit() {
		return portal.split("~");
	}

}
