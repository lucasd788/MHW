package br.edu.unifei.ecot12.lucasdias.mhw;

public class Character extends Opponents{
	private String name;
	private double health;
	private int level;
	private Palico palico;
	private Weapon weapon;
	private Equipment equipments[] = new Equipment[6];
	
	public void chAttack() {callFight();}
	
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
	public Equipment[] getEquipments() {
		return equipments;
	}
	public void setEquipments(Equipment[] equipments) {
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
