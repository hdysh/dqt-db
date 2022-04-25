package com.github.hdysh.dqtdb.model;

import java.math.BigInteger;
import java.text.DecimalFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "passive")
@Data
public class PassiveMin {
	private @Id BigInteger code;
	private String name;
	private String description;
	private int var;

	public String getVar() {
		DecimalFormat format = new DecimalFormat("0.#");
		double out = this.var;
		if (Math.abs(this.var) > 99) {
			out = this.var / 100.0;
		}
		return format.format(out);

	}
}
