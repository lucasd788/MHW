package br.edu.unifei.ecot12.lucasdias.mhw;

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
