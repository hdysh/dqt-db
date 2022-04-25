package com.github.hdysh.dqtdb.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "unit_ail_res")
@Data
public class UnitAilmentRes {
	private @Id BigInteger code;
	private int ail1;
	private int ail2;
	private int ail3;
	private int ail4;
	private int ail5;
	private int ail6;
	private int ail7;
	private int ail8;
	private int ail9;
	private int ail10;
	private int ail11;
	private int ail12;
	private int ail13;
	private String name, description;

	public void add(UnitAilmentRes ua) {
		this.ail1 += ua.getAil1();
		this.ail2 += ua.getAil2();
		this.ail3 += ua.getAil3();
		this.ail4 += ua.getAil4();
		this.ail5 += ua.getAil5();
		this.ail6 += ua.getAil6();
		this.ail7 += ua.getAil7();
		this.ail8 += ua.getAil8();
		this.ail9 += ua.getAil9();
		this.ail10 += ua.getAil10();
		this.ail11 += ua.getAil11();
		this.ail12 += ua.getAil12();
		this.ail13 += ua.getAil13();
	}

	public int getAilTalentRaw() {
		if (ail1 != 0) {
			return ail1;
		}
		if (ail2 != 0) {
			return ail2;
		}
		if (ail3 != 0) {
			return ail3;
		}
		if (ail4 != 0) {
			return ail4;
		}
		if (ail5 != 0) {
			return ail5;
		}
		if (ail6 != 0) {
			return ail6;
		}
		if (ail7 != 0) {
			return ail7;
		}
		if (ail8 != 0) {
			return ail8;
		}
		if (ail9 != 0) {
			return ail9;
		}
		if (ail10 != 0) {
			return ail10;
		}
		if (ail11 != 0) {
			return ail11;
		}
		if (ail12 != 0) {
			return ail12;
		}
		if (ail13 != 0) {
			return ail13;
		}
		return 0;
	}

	public int getAilTalent() {
		int val = getAilTalentRaw();
		if (val > 99) {
			return val / 100;
		} else {
			return val;
		}
	}
}
