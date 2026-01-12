package br.edu.unifei.ecot12.lucasdias.mhw;

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
