package br.edu.unifei.ecot13.lucasdias.mhw;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Canteen extends Location {
	public void eat(Pcharacter c) {
		double h = c.getHealth();
		System.out.println(super.getName() + " - " + super.getRegion());
		System.out.print("Big Meal! " + h);
		h = h*1.3;
		c.setHealth(h);
		System.out.println(" -> " + h + " health. (+30%)");
		System.out.println();
	}
}
