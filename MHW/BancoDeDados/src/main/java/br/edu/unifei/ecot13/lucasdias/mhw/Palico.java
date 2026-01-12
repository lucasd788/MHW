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
public class Palico {
	@Id
	private String name;
	private String color;
	@OneToOne
	private Pcharacter character;
	@OneToOne
	private Gadget gadget;
	@OneToMany
	List<Equipment> equipments = new ArrayList<>(2);
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Pcharacter getCharacter() {
		return character;
	}
	public void setCharacter(Pcharacter character) {
		this.character = character;
	}
	public Gadget getGadget() {
		return gadget;
	}
	public void setGadget(Gadget gadget) {
		this.gadget = gadget;
	}
	public List<Equipment> getEquipments() {
		return equipments;
	}
	public void setEquipments(List<Equipment> equipments) {
		this.equipments = equipments;
	}
	public void printPalico() {
		System.out.println(character.getName().toUpperCase() +" PALICO STATS");
	    System.out.println("Name: " + getName());
	    System.out.println("Color: " + getColor());
	    System.out.println();
	}
	
}
