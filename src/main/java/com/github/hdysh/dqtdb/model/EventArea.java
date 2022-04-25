package com.github.hdysh.dqtdb.model;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "event_area")
@Data
public class EventArea {

	private @Id BigInteger code;
	@Column(name = "areagroup")
	private BigInteger areaGroup;
	@Column(name = "eventportal")
	private BigInteger eventPortal;
	private String name, icon;
	private BigInteger category;
	private BigInteger subCategory;
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "code")
	@OrderBy("required DESC")
	private List<BrMember> brMember;
}
