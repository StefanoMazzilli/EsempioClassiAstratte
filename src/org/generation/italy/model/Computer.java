package org.generation.italy.model;

public abstract class Computer {
	protected String sistemaOs;
	protected int id;
	protected String marca;
	protected String modello;
	protected boolean stato;
	protected boolean connWifi;
	
	public abstract void accendi();
	
	public abstract void spegni();
	
	public abstract void connessioneInternetOn();
	
	public abstract void connessioneInternetOff();

	public String getSistemaOs() {
		return sistemaOs;
	}

	public int getId() {
		return id;
	}

	public String getMarca() {
		return marca;
	}

	public String getModello() {
		return modello;
	}

	public boolean isStato() {
		return stato;
	}

	public boolean isConnWifi() {
		return connWifi;
	}

}
