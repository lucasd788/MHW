package br.edu.unifei.ecot12.lucasdias.mhw;

public class Monster extends Opponents{
	private String name;
	private double health;
	private int size;
	private String element;
	private String ailment;
	private MonsterType monsterType;
	public Monster(MonsterType monsterType) {this.monsterType = monsterType;}
	
	public void mnstrAttack() {callFight();}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getHealth() {
		return health;
	}
	public void setHealth(double health) {
		this.health = health;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getElement() {
		return element;
	}
	public void setElement(String element) {
		this.element = element;
	}
	public String getAilment() {
		return ailment;
	}
	public void setAilment(String ailment) {
		this.ailment = ailment;
	}
	public MonsterType getMonsterType() {
		return monsterType;
	}
	public void setMonsterType(MonsterType monsterType) {
		this.monsterType = monsterType;
	}
	public void printMonster() {
	    getMonsterType().printType();
	    System.out.println("Name: " + getName());
	    System.out.println("Health: " + getHealth());
	    System.out.println("Size: " + getSize());
	    System.out.println("Element: " + getElement());
	    System.out.println("Ailment: " + getAilment());
	    System.out.println();
	}
}
