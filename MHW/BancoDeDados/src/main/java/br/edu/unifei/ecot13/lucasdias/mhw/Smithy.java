package br.edu.unifei.ecot13.lucasdias.mhw;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Smithy extends Location {
	public void upgrade(Weapon w) {
		double d = w.getDamage();
		System.out.println(super.getName() + " - " + super.getRegion());
		System.out.print("Successfully Upgraded Weapon! " + d);
		d = d*1.2;
		w.setDamage(d);
		System.out.println(" -> " + d + " damage. (+20%)");
		System.out.println();
	}
}
