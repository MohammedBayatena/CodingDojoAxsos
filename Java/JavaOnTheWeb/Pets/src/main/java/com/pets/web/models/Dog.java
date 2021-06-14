package com.pets.web.models;

public class Dog extends Animal implements Pet {

	public Dog(String name, String breed, double weight) {
		super(name, breed, weight);
		// TODO Auto-generated constructor stub
	}

	public Dog() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String showAffection() {
		if (this.weight >= 30) {
			return (this.name+" is Curling up next to you!");
		}else {
			return (this.name+" have hopped into your lap! give em a good pet!");
		}
	}

}
