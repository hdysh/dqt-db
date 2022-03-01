package com.pokiltenan.dqtdb.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "ail_res")
@Data
public class AilmentRes {
	private @Id BigInteger code;
	private int ail1;
	private int ail2;
	private int ail3;
	private int ail4;
	private int ail5;
	private int ail6;
	private int ail7;
	private int ail8;
	private int ail9;
	private int ail10;
	private int ail11;
	private int ail12;
	private int ail13; 

}
