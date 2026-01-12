package br.edu.unifei.ecot13.lucasdias.mhw;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class TrainingArea extends Location {
	public void train(Pcharacter c) {
		int l = c.getLevel();
		System.out.println(super.getName() + " - " + super.getRegion());
		System.out.print("Training Done! " + l);
		l = l+1;
		c.setLevel(l);
		System.out.println(" -> " + l + " level. (+1)");
		System.out.println();
	}
}
