package com.github.hdysh.dqtdb.model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "event_area")
@Data
@ToString
public class EventArea {

	private @Id BigInteger code;
	@Column(name = "areagroup")
	private BigInteger areaGroup;
	@Column(name = "eventportal")
	private BigInteger eventPortal;
	private String name, icon;
	private BigInteger category;
	private BigInteger subCategory;
}
