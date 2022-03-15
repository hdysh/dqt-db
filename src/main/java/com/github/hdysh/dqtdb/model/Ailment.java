package com.github.hdysh.dqtdb.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "ailment")
@Data
@ToString
public class Ailment {
	private @Id BigInteger code;
	private BigInteger res;
	private String name;
	private String displayFormat;
	private String descFormat;
	private String icon;
}
