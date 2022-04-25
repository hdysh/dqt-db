package com.github.hdysh.dqtdb.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "lang")
@Data
//@IdClass(LangKey.class)
public class Lang {
 
	private String locale;
	@Id
	private String name;
	private String val;
}
