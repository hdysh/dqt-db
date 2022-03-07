package com.pokiltenan.dqtdb.model;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "enemy")
@Data
@ToString
@SecondaryTable(name = "unit_rate", pkJoinColumns = @PrimaryKeyJoinColumn(name = "code"))
public class UnitEnemy {
	public @Id BigInteger code;
	public String name; 
	public String icon;
	public String rarity;
	@OneToOne(targetEntity = EleRes.class)
	@JoinColumn(name = "code")
	private EleRes eleRes;
	@ManyToOne(targetEntity = AilmentRes.class)
	@JoinColumn(name = "ailres")
	private AilmentRes ailres;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "code")
	private List<Stats> stats;
	@Column(table = "unit_rate", name = "rate")
	private Integer rate;
 
	private BigInteger base ;

}
