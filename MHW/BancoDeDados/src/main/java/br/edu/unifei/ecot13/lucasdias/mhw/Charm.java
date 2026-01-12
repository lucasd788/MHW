package br.edu.unifei.ecot13.lucasdias.mhw;

import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
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
