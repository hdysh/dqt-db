package com.github.hdysh.dqtdb.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "unit_ele_res")
@Data
public class UnitEleRes {

	private @Id BigInteger code;
	private int frizz;
	private int sizz;
	private int crack;
	private int woosh;
	private int bang;
	private int zap;
	private int zam;

	public void add(UnitEleRes ue) {
		this.frizz += ue.getFrizz();
		this.sizz += ue.getSizz();
		this.crack += ue.getCrack();
		this.woosh += ue.getWoosh();
		this.bang += ue.getBang();
		this.zap += ue.getZap();
		this.zam += ue.getZam();
	}
}
