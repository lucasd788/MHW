package br.edu.unifei.ecot12.lucasdias.mhw;

public class Palico {
	private String name;
	private String color;
	private Character character;
	private Gadget gadget;
	private Equipment equipments[] = new Equipment[2];
	
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
	public Character getCharacter() {
		return character;
	}
	public void setCharacter(Character character) {
		this.character = character;
	}
	public Gadget getGadget() {
		return gadget;
	}
	public void setGadget(Gadget gadget) {
		this.gadget = gadget;
	}
	public Equipment[] getEquipments() {
		return equipments;
	}
	public void setEquipments(Equipment[] equipments) {
		this.equipments = equipments;
	}
	public void printPalico() {
		System.out.println(character.getName().toUpperCase() +" PALICO STATS");
	    System.out.println("Name: " + getName());
	    System.out.println("Color: " + getColor());
	    System.out.println();
	}
	
}
