package com.pets.web.models;

public class Cat extends Animal implements Pet {

	public Cat(String name, String breed, double weight) {
		super(name, breed, weight);
		// TODO Auto-generated constructor stub
	}

	public Cat() {
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public String showAffection() {		
		return this.name+" is Looking at you cutely!";
	}

}
