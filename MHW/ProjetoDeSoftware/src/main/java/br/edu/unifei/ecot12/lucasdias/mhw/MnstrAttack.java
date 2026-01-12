package br.edu.unifei.ecot12.lucasdias.mhw;

public class MnstrAttack implements Hunt {
	private Character character;
	private Monster monster;
	@Override
	public void fight() {

	}
	
	public Character getCharacter() {
		return character;
	}
	public void setCharacter(Character character) {
		this.character = character;
	}
	public Monster getMonster() {
		return monster;
	}
	public void setMonster(Monster monster) {
		this.monster = monster;
	}

}
