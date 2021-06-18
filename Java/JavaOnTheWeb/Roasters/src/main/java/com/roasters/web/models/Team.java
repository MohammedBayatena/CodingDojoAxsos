package com.roasters.web.models;

import java.util.ArrayList;

public class Team {

	private String name;
	private ArrayList<Player> players = new ArrayList<>();
	private int noOfPlayers;
	
	public Team() {
		super();
	}

	public Team(String name, int noOfPlayers) {
		super();
		this.name = name;
		this.noOfPlayers = noOfPlayers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNoOfPlayers() {
		return noOfPlayers;
	}

	public void setNoOfPlayers(int noOfPlayers) {
		this.noOfPlayers = noOfPlayers;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	public void updateplayers() {
		setNoOfPlayers(getPlayers().size());
	}
	
	
	
	
	
	
	
	
}
