package br.edu.unifei.ecot12.lucasdias.mhw;

import java.util.ArrayList;
import java.util.List;

public class App {
	public static void main(String[] args) {
		Character c1 = new Character();
		c1.setName("Lucas");
		c1.setHealth(100);
		c1.setLevel(71);
		c1.printCharacter();
		
		MeleeWpn mw1 = new MeleeWpn();
		mw1.setDamage(279);
		mw1.setSharpness(12);
		mw1.setAffinity(0);
		mw1.setElement("NONE");
		mw1.setRarity(3);
		mw1.setDamageType("CUT DAMAGE");
		c1.setWeapon(mw1);
		mw1.printWeapon();
		
		Equipment equipmentsC[] = new Equipment[6];
		Armor helm = new Armor();
		helm.setDefense(6);
		helm.setRarity(1);
		helm.setUpgradeLv(1);
		equipmentsC[0] = helm;
		
		Armor chest = new Armor();
		chest.setDefense(56);
		chest.setRarity(7);
		chest.setUpgradeLv(1);
		equipmentsC[1] = chest;
		
		Armor arms = new Armor();
		arms.setDefense(154);
		arms.setRarity(11);
		arms.setUpgradeLv(2);
		equipmentsC[2] = arms;
		
		Armor waist = new Armor();
		waist.setDefense(176);
		waist.setRarity(12);
		waist.setUpgradeLv(1);
		equipmentsC[3] = waist;
		
		Armor legs = new Armor();
		legs.setDefense(142);
		legs.setRarity(10);
		legs.setUpgradeLv(2);
		equipmentsC[4] = legs;
		
		Charm charm = new Charm();
		charm.setSkills("ATTACK BOOST");
		charm.setRarity(11);
		charm.setUpgradeLv(4);
		equipmentsC[5] = charm;
		c1.setEquipments(equipmentsC);
		for(Equipment equipment: equipmentsC) {
			equipment.printEquipment();
		}
		
		Palico p1 = new Palico();
		p1.setName("PALICO");
		p1.setColor("ORANGE");
		p1.setCharacter(c1);
		p1.printPalico();
		c1.setPalico(p1);
		
		Gadget g1 = new Gadget();
		g1.setRarity(9);
		g1.setProficiency(15);
		p1.setGadget(g1);
		g1.printGadget();
		
		Equipment equipmentsP[] = new Equipment[2];
		Armor helmP = new Armor();
		helmP.setDefense(56);
		helmP.setRarity(5);
		helmP.setUpgradeLv(3);
		equipmentsP[0] = helmP;
		
		Armor chestP = new Armor();
		chestP.setDefense(90);
		chestP.setRarity(9);
		chestP.setUpgradeLv(1);
		equipmentsP[1] = chestP;
		
		p1.setEquipments(equipmentsP);
		for(Equipment equipment: equipmentsP) {
			equipment.printEquipment();
		}
		
		Smithy sm = new Smithy();
		sm.setName("SMITHY");
		sm.setRegion("NORTH");
		sm.upgrade(mw1);
		
		Canteen ct = new Canteen();
		ct.setName("CANTEEN");
		ct.setRegion("EAST");
		ct.eat(c1);
		
		TrainingArea ta = new TrainingArea();
		ta.setName("TRAINING AREA");
		ta.setRegion("WEST");
		ta.train(c1);
		
		HuntingField hf = new HuntingField();
		hf.setName("HUNTING FIELD");
		hf.setRegion("SOUTH");
		hf.setWeather("RAIN");
		hf.setTime("NIGHT");
		
		List<Monster> monsters = new ArrayList<Monster>();
		ElderDragon ed = new ElderDragon();
		Monster m1 = new Monster(ed);
		m1.setName("Fatalis");
		m1.setHealth(100000);
		m1.setSize(4137);
		m1.setElement("FIRE");
		m1.setAilment("FIREBLIGHT");
		monsters.add(m1);
		
		FangedWyvern fw = new FangedWyvern();
		Monster m2 = new Monster(fw);
		m2.setName("Zinogre");
		m2.setHealth(30000);
		m2.setSize(2053);
		m2.setElement("THUNDER");
		m2.setAilment("THUNDERBLIGHT");
		monsters.add(m2);
		
		BruteWyvern bw = new BruteWyvern();
		Monster m3 = new Monster(bw);
		m3.setName("Brachydios");
		m3.setHealth(25000);
		m3.setSize(1961);
		m3.setElement("NONE");
		m3.setAilment("BLASTSCOURGE");
		monsters.add(m3);
		
		BirdWyvern bdw = new BirdWyvern();
		Monster m4 = new Monster(bdw);
		m4.setName("Yian Garuga");
		m4.setHealth(28000	);
		m4.setSize(1522);
		m4.setElement("FIRE");
		m4.setAilment("FIREBLIGHT; POISON");
		monsters.add(m4);
		
		PiscineWyvern pw = new PiscineWyvern();
		Monster m5 = new Monster(pw);
		m5.setName("Jyuratodus");
		m5.setHealth(20000);
		m5.setSize(1617);
		m5.setElement("WATER");
		m5.setAilment("WATERBLIGHT");
		monsters.add(m5);
		
		hf.setMonsters(monsters);
		hf.printHuntingField();
	    for(Monster monster: monsters) monster.printMonster();
	}
}
