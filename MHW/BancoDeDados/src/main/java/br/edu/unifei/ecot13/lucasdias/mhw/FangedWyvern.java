package br.edu.unifei.ecot13.lucasdias.mhw;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class FangedWyvern extends MonsterType {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Override
	public void attack() {		
	}

	@Override
	public void printType() {
		System.out.println("Fanged Wyvern");
	}

}
