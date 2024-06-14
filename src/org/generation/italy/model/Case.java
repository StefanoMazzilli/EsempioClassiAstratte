package org.generation.italy.model;

public class Case extends Computer {
	private boolean tastiera;
	
	public Case() {
		super();
		this.tastiera=false;
	}

	@Override
	public String toString() {
		return "[Stato: "+(stato?"acceso":"spento")+" - Connessione: "+(connWifi?"connesso":"disconnesso")+" - Tastiera: " + (tastiera?"collegata":"scollegata") + "]";
	}

	@Override
	public void accendi() {
		if (!stato) {
			stato=true;
		} else {
			System.out.println("Il computer è già acceso");
		}
		
	}

	@Override
	public void spegni() {
		if (stato) {
			stato=false;
		} else {
			System.out.println("Il computer è già spento");
		}
	}

	@Override
	public void connessioneInternetOn() {
		if (!connWifi) {
			connWifi=true;
		} else {
			System.out.println("La connessione wi-fi è già accesa");
		}
	}

	@Override
	public void connessioneInternetOff() {
		if (connWifi) {
			connWifi=false;
		} else {
			System.out.println("La connessione wi-fi è già spenta");
		}
	}

	public boolean isTastiera() {
		return tastiera;
	}

	public void setTastiera(boolean tastiera) {
		this.tastiera = tastiera;
	}
	
	
}
