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
}
