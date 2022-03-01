package com.pokiltenan.dqtdb.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "element")
@Data
@ToString
public class Element {
	private @Id BigInteger code;
	private String name;
	private String icon;

}
