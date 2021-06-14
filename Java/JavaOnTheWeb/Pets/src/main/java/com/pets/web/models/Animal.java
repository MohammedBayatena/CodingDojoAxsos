package com.pets.web.models;

public class Animal {

	
public String name;
public String breed;
public double weight;


public Animal(String name, String breed, double weight) {
	super();
	this.name = name;
	this.breed = breed;
	this.weight = weight;
}

public Animal() {
	super();
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getBreed() {
	return breed;
}
public void setBreed(String breed) {
	this.breed = breed;
}
public double getWeight() {
	return weight;
}
public void setWeight(double weight) {
	this.weight = weight;
}

	
	
	
	
	
}
