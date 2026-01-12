package br.edu.unifei.ecot13.lucasdias.mhw;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public abstract class Equipment {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nameType;
	private int upgradeLv;
	private int rarity;
	
	public abstract void printStats();
	public String getNameType() {
		return nameType;
	}
	public void setNameType(String nameType) {
		this.nameType = nameType;
	}
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
