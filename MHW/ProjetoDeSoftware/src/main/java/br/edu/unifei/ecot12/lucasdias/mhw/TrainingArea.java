package br.edu.unifei.ecot12.lucasdias.mhw;

public class TrainingArea extends Location {
	public void train(Character c) {
		int l = c.getLevel();
		System.out.println(super.getName() + " - " + super.getRegion());
		System.out.print("Training Done! " + l);
		l = l+1;
		c.setLevel(l);
		System.out.println(" -> " + l + " level. (+1)");
		System.out.println();
	}
}
