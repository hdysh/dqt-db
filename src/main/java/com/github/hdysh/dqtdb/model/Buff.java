package com.github.hdysh.dqtdb.model;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Table(name = "buff")
@Data
public class Buff {
	private @Id BigInteger code;
	private String name;
	private String displayFormat;
	private String descFormat;
	private String suffixUp;
	private String suffixDown;
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "code")
	private List<LevelStatus> levelStatus;
	@Transient
	private String iconUp;
	@Transient
	private String iconDown;
	@Transient
	private Map<BigInteger, BigInteger> level;

	public boolean getUp() {
		boolean up = false;
		boolean down = false;
		for (LevelStatus lv : levelStatus) {
			if (lv.getLevel().intValue() > 0) {
				up = true;
			} else if (lv.getLevel().intValue() < 0) {
				down = true;
			}
		}
		if (!up & !down) {
			up = true;
		}
		return up;
	}

	public boolean getDown() {
		boolean down = false;
		for (LevelStatus lv : levelStatus) {
			if (lv.getLevel().intValue() < 0) {
				down = true;
			}
		}
		return down;
	}

	public String getSuffixUp() {
		if (suffixUp.trim().isEmpty())
			return "Empty.String";
		else
			return suffixUp;
	}

	public String getSuffixDown() {
		if (suffixDown.trim().isEmpty())
			return "Empty.String";
		else
			return suffixDown;
	}

	public List<String> getSuffix() {
		List<String> suffix = new ArrayList<>();
		suffix.add(getSuffixUp());
		suffix.add(getSuffixDown());
		return suffix;
	}

	public Map<BigInteger, BigInteger> getLevel() {
		Map<BigInteger, BigInteger> map = new HashMap<>();
		for (LevelStatus lv : levelStatus) {
			map.put(lv.getLevel(), lv.getValue());
			if (lv.getLevel().intValue() > 0) {
				this.iconUp = lv.getIcon();
			}
			if (lv.getLevel().intValue() < 0) {
				this.iconDown = lv.getIcon();
			}
		}
		return map;
	}

	public String getIconUp() {
		String up = "";
		String zero = "";
		for (LevelStatus lv : levelStatus) {
			if (lv.getLevel().intValue() > 0) {
				up = lv.getIcon();
			} else if (lv.getLevel().intValue() == 0) {
				zero = lv.getIcon();
			}
		}
		if (up.trim().isEmpty()) {
			up = zero;
		}
		return up;
	}

	public String getIconDown() {
		String down = "";
		String zero = "";
		for (LevelStatus lv : levelStatus) {
			if (lv.getLevel().intValue() < 0) {
				down = lv.getIcon();
			} else if (lv.getLevel().intValue() == 0) {
				zero = lv.getIcon();
			}
		}
		if (down.trim().isEmpty()) {
			down = zero;
		}
		return down;
	}
}
