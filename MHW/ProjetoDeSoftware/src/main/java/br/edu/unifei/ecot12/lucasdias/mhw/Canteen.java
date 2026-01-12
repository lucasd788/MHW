package br.edu.unifei.ecot12.lucasdias.mhw;

public class Canteen extends Location {
	public void eat(Character c) {
		double h = c.getHealth();
		System.out.println(super.getName() + " - " + super.getRegion());
		System.out.print("Big Meal! " + h);
		h = h*1.3;
		c.setHealth(h);
		System.out.println(" -> " + h + " health. (+30%)");
		System.out.println();
	}
}
