package br.edu.unifei.ecot12.lucasdias.mhw;

public class Opponents {
	private Hunt hunt;
	protected void callFight() {
		hunt.fight();
	}
	
	public Hunt getHunt() {
		return hunt;
	}
	public void setHunt(Hunt hunt) {
		this.hunt = hunt;
	}
}
