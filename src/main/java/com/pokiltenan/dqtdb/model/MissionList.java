package com.pokiltenan.dqtdb.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "mission_list")
@Data
public class MissionList {
	private @Id BigInteger code;
	@OneToOne(targetEntity = Mission.class)
	@JoinColumn(name = "mission1")
	private Mission mission1;
	@OneToOne(targetEntity = Mission.class)
	@JoinColumn(name = "mission2")
	private Mission mission2;
	@OneToOne(targetEntity = Mission.class)
	@JoinColumn(name = "mission3")
	private Mission mission3;
}
