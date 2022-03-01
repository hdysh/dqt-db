package com.pokiltenan.dqtdb.model;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Where;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity(name = "UnitMin")
@Table(name = "unit")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString
public class UnitMin extends AbstractUnit<UnitMin> {
	public String getName() {
		return name;
	}

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "code")
	@Where(clause = "rank = 7")
	private List<Stats> stats;
	@Transient
	private List<BigInteger> stageDrop = new ArrayList<>();
	@Transient
	private List<Integer> dropRate = new ArrayList<>();
}
