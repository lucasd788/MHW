package br.edu.unifei.ecot13.lucasdias.mhw;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Armor extends Equipment {
	private int defense;
	
	@Override
	public void printStats() {
		System.out.println("ARMOR");
		System.out.println("Defense: " + getDefense());
	}
	public int getDefense() {
		return defense;
	}
	public void setDefense(int defense) {
		this.defense = defense;
	}
	
}
