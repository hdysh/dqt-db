package com.github.hdysh.dqtdb.model;

import java.math.BigInteger;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import lombok.Data;

@Entity
@Table(name = "lang")
@Data
public class Lang {

	private @Id BigInteger id;
	@NaturalId
    @Column(nullable = false, unique = true)
	private String name;
	private String en, ja;
	 @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass())
	            return false;
	        Lang post = (Lang) o;
	        return Objects.equals(name, post.name);
	    }
	 
	    @Override
	    public int hashCode() {
	        return Objects.hash(name);
	    }
}
