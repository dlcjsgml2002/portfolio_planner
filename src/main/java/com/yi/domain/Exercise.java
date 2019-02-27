package com.yi.domain;

public class Exercise {
	private int eno;
	private String part;
	private String name;
	private String link;

	public Exercise() {}

	public Exercise(int eno, String part, String name, String link) {
		this.eno = eno;
		this.part = part;
		this.name = name;
		this.link = link;
	}

	public int getEno() {
		return eno;
	}

	public void setEno(int eno) {
		this.eno = eno;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return String.format("Exercise [eno=%s, part=%s, name=%s, link=%s]", eno, part, name, link);
	}

}
