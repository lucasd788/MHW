package br.edu.unifei.ecot12.lucasdias.mhw;

public class RangedWpn extends Weapon {
	private String ammoType;

	@Override
	public void printWeaponType() {
		System.out.println("RANGED " + getAmmoType().toUpperCase() + " WEAPON");
	}
	public String getAmmoType() {
		return ammoType;
	}
	public void setAmmoType(String ammoType) {
		this.ammoType = ammoType;
	}

}
