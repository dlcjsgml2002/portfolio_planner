package com.yi.domain;

public class Exercise {
	private int eno;
	private String part;
	private String name;
	private String info;
	private String video;

	public Exercise() {}

	public Exercise(int eno, String part, String name, String info, String video) {
		this.eno = eno;
		this.part = part;
		this.name = name;
		this.info = info;
		this.video = video;
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

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	@Override
	public String toString() {
		return String.format("Exercise [eno=%s, part=%s, name=%s, info=%s, video=%s]", eno, part, name, info, video);
	}

}
