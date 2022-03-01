package com.pokiltenan.dqtdb.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "enemies_map")
@Data
public class EnemiesMap {
	private @Id BigInteger code;
	private BigInteger stage;
	private BigInteger enemy;

}
