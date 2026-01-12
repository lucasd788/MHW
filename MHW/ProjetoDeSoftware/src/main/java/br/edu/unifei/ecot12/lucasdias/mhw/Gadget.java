package br.edu.unifei.ecot12.lucasdias.mhw;

public class Gadget {
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
