package br.edu.unifei.ecot12.lucasdias.mhw;

public class MeleeWpn extends Weapon {
	private String damageType;

	@Override
	public void printWeaponType() {
		System.out.println("MELEE " + getDamageType().toUpperCase() + " WEAPON");
	}
	public String getDamageType() {
		return damageType;
	}
	public void setDamageType(String damageType) {
		this.damageType = damageType;
	}
}
