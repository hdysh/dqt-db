package com.pokiltenan.dqtdb.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "unit_passive")
@Data 
@ToString
public class UnitPassive  {


	private @Id BigInteger id;
	private   BigInteger code;
	private BigInteger level; 

	@ManyToOne(targetEntity = Passive.class)
	@JoinColumn(name = "passive")
	private Passive passive;
}
