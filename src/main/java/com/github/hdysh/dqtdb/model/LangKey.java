package com.github.hdysh.dqtdb.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class LangKey implements Serializable {
	private static final long serialVersionUID = 1L;

	private String locale;

	private String name;
}
 