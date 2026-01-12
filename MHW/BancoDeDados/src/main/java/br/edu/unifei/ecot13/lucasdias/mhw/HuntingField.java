package br.edu.unifei.ecot13.lucasdias.mhw;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class HuntingField extends Location {
	private String weather;
	private String time;
	@OneToMany
	private List<Monster> monsters = new ArrayList<Monster>();
	
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public List<Monster> getMonsters() {
		return monsters;
	}
	public void setMonsters(List<Monster> monsters) {
		this.monsters = monsters;
	}
	public void printHuntingField() {
		System.out.println(super.getName() + " - " + super.getRegion());
	    System.out.println("Weather: " + getWeather());
	    System.out.println("Time: " + getTime());
	    System.out.println();
	}
}
