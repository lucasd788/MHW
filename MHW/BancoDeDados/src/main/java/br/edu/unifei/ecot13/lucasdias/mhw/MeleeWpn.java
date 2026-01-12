package br.edu.unifei.ecot13.lucasdias.mhw;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
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
