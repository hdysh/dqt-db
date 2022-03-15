package com.github.hdysh.dqtdb.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "ailment_res")
@Data
@ToString
public class AilmentRes {
	private @Id BigInteger code;
	private String name;
	private String icon;

}
