package br.edu.unifei.ecot12.lucasdias.mhw;

public abstract class Location {
	private String name;
	private String region;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
}
