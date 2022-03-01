package com.pokiltenan.dqtdb.model;

import java.math.BigInteger;

import javax.persistence.Column;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class StatsId  {
	@Column
	private BigInteger code;
	@Column
	private int rank;

	public StatsId() {
	} 

 
}
