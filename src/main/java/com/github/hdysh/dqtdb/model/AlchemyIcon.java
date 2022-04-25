package com.github.hdysh.dqtdb.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "alchemy_icon")
@Data
@ToString
public class AlchemyIcon {
	private @Id BigInteger code;
	private String icon;
}
