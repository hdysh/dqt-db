package com.pokiltenan.dqtdb.model;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "stage")
@Data
@ToString
public class Stage {

	private @Id BigInteger code;
	private BigInteger area;
	private String name;
	private String icon;
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "stage")
	private List<Enemy> enemies;
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "code")
	private List<Drop> drops;
	private int cp, stamina;

	@OneToOne(targetEntity = MissionList.class)
	@JoinColumn(name = "missionlist")
	private MissionList missionList;

}
