package com.pokiltenan.dqtdb.model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "event_group")
@Data
@ToString
public class EventGroup {

	private @Id BigInteger code; 
	@Column(name="eventportal")
	private BigInteger eventPortal;
	private String name, icon;
	private BigInteger atype; 
}
