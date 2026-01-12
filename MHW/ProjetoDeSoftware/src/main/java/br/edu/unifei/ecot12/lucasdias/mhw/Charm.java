package br.edu.unifei.ecot12.lucasdias.mhw;

public class Charm extends Equipment {
	private String skills;

	@Override
	public void printStats() {
		System.out.println("CHARM");
		System.out.println("Skill: " + getSkills().toUpperCase());
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
}
