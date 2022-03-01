package com.pokiltenan.dqtdb.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "stage")
@Data
@ToString
public class StageMin {

	private @Id BigInteger code;
	private BigInteger area;
	private String name;  
	private int  stamina; 
 

}
