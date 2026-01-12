package br.edu.unifei.ecot13.lucasdias.mhw;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
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
