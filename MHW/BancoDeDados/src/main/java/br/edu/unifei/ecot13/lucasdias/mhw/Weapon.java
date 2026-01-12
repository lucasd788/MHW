package br.edu.unifei.ecot13.lucasdias.mhw;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public abstract class Weapon {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private double damage;
	private double sharpness;
	private int affinity;
	private int rarity;
	private String element;
	
	public abstract void printWeaponType();
	public double getDamage() {
		return damage;
	}
	public void setDamage(double damage) {
		this.damage = damage;
	}
	public double getSharpness() {
		return sharpness;
	}
	public void setSharpness(double sharpness) {
		this.sharpness = sharpness;
	}
	public int getAffinity() {
		return affinity;
	}
	public void setAffinity(int affinity) {
		this.affinity = affinity;
	}
	public int getRarity() {
		return rarity;
	}
	public void setRarity(int rarity) {
		this.rarity = rarity;
	}
	public String getElement() {
		return element;
	}
	public void setElement(String element) {
		this.element = element;
	}
	public void printWeapon() {
		printWeaponType();
		System.out.println("Damage: " + getDamage());
		System.out.println("Sharpness: " + getSharpness());
		System.out.println("Affinity: " + getAffinity() + "%");
		System.out.println("Rarity: " + getRarity());
		System.out.println("Element: " + getElement());
		System.out.println();
	}
}
