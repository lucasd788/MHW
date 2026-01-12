package br.edu.unifei.ecot13.lucasdias.mhw;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Gadget {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int rarity;
	private int proficiency;
	
	public int getRarity() {
		return rarity;
	}
	public void setRarity(int rarity) {
		this.rarity = rarity;
	}
	public int getProficiency() {
		return proficiency;
	}
	public void setProficiency(int proficiency) {
		this.proficiency = proficiency;
	}
	public void printGadget() {
		System.out.println("GADGET");
	    System.out.println("Rarity: " + getRarity());
	    System.out.println("Proficiency: " + getProficiency());
	    System.out.println();
	}
}
