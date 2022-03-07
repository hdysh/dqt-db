package com.pokiltenan.dqtdb.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "panel_content")
@Data
@ToString
public class PanelContent {

	private @Id BigInteger id;
	private BigInteger code;
	private String name;
	private String desc;
	private String icon;
	private String bg;
	private int stype;
}
