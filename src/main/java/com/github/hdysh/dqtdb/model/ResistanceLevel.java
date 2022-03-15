package com.github.hdysh.dqtdb.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "res_level")
@Data
@ToString
public class ResistanceLevel {
	private @Id BigInteger id;
	private BigInteger minv;
	private BigInteger maxv;
	private String icon;
}
