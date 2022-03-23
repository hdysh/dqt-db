package com.github.hdysh.dqtdb.model;

import java.math.BigInteger;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AilmentResPair {

	private String icon;
	private AilmentRes ail;
	private BigInteger value;

}
