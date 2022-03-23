package com.github.hdysh.dqtdb.model;

import java.math.BigInteger;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EleResPair {

	private String icon;
	private Element ele;
	private BigInteger value;
}
