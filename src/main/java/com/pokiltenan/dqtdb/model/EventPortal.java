package com.pokiltenan.dqtdb.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "event_portal")
@Data
@ToString
public class EventPortal {

	private @Id BigInteger code;
	private String name, icon, description;
	private BigInteger achievement, shop;

}
