package br.edu.unifei.ecot13.lucasdias.mhw;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Pcharacter {
	@Id
	private String name;
	private double health;
	private int level;
	@OneToOne
	private Palico palico;
	@OneToOne
	private Weapon weapon;
	@OneToMany
	private List<Equipment> equipments = new ArrayList<>(6);
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getHealth() {
		return health;
	}
	public void setHealth(double d) {
		this.health = d;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public Palico getPalico() {
		return palico;
	}
	public void setPalico(Palico palico) {
		this.palico = palico;
	}
	public Weapon getWeapon() {
		return weapon;
	}
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	public List<Equipment> getEquipments() {
		return equipments;
	}
	public void setEquipments(List<Equipment> equipments) {
		this.equipments = equipments;
	}	
	public void printCharacter() {
	    System.out.println("CHARACTER STATS");
	    System.out.println("Name: " + getName());
	    System.out.println("Health: " + getHealth());
	    System.out.println("Level: " + getLevel());
	    System.out.println();
	}

}
