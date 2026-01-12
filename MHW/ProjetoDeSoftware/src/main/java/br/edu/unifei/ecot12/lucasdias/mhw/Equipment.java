package br.edu.unifei.ecot12.lucasdias.mhw;

public abstract class Equipment {
	private int upgradeLv;
	private int rarity;
	
	public abstract void printStats();
	public int getUpgradeLv() {
		return upgradeLv;
	}
	public void setUpgradeLv(int upgradeLv) {
		this.upgradeLv = upgradeLv;
	}
	public int getRarity() {
		return rarity;
	}
	public void setRarity(int rarity) {
		this.rarity = rarity;
	}
	public void printEquipment() {
		printStats();
		System.out.println("UpgradeLv: " + getUpgradeLv());
		System.out.println("Rarity: " + getRarity());
		System.out.println();
	}
}
