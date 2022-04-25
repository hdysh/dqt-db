package com.github.hdysh.dqtdb.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "ele_res")
@Data
public class EleRes {

	private @Id BigInteger code;
	private int ele1;
	private int ele2;
	private int ele3;
	private int ele4;
	private int ele5;
	private int ele6;
	private int ele7;
	private String name, description;

	public EleRes add(EleRes res) {
		if (res != null) {
			this.ele1 += res.ele1;
			this.ele2 += res.ele2;
			this.ele3 += res.ele3;
			this.ele4 += res.ele4;
			this.ele5 += res.ele5;
			this.ele6 += res.ele6;
			this.ele7 += res.ele7;
		}
		return this;
	}

	public int getEleTalent() {
		int val = getEleTalentRaw();
		if (val > 99) {
			return val / 100;
		} else {
			return val;
		}
	}

	public int getEleTalentRaw() {
		if (this.ele1 != 0) {
			return this.ele1;
		}
		if (this.ele2 != 0) {
			return this.ele2;
		}
		if (this.ele3 != 0) {
			return this.ele3;
		}
		if (this.ele4 != 0) {
			return this.ele4;
		}
		if (this.ele5 != 0) {
			return this.ele5;
		}
		if (this.ele6 != 0) {
			return this.ele6;
		}
		if (this.ele7 != 0) {
			return this.ele7;
		}
		return 0;
	}
}
