package org.generation.italy.model;

public class Cellulare extends Computer{
	private String numTel;
	private boolean connDati;
	
	@Override
	public void accendi() {
		if (!stato) {
			stato=true;
		} else {
			System.out.println("Cellulare già acceso");
		}
	}

	@Override
	public void spegni() {
		if (stato) {
			stato=false;
		} else {
			System.out.println("Cellulare già spento");
		}
	}

	@Override
	public void connessioneInternetOn() {
		//metodo override per accendere solo il wifi
		if (!connWifi) {
			connWifi=true;
		}else {
			System.out.println("Il wi-fi è già acceso");
		}
	}
	
	@Override
	public void connessioneInternetOff() {
		//metodo override per spegnere solo il wifi
		if (connWifi) {
			connWifi=false;
		} else {
			System.out.println("Il wi-fi è già spento");
		}
	}
	
	public void connessioneInternetOn (boolean dati) {
		//metodo polimorfico per accendere il wifi o la connessione dati
		if (dati) {
			//caso in cui ho selezionato la connessione dati
			if (!connDati) {
				//la connessione dati è spenta
				connDati=true;
			}else {
				System.out.println("La connessione dati è già accesa");
			}
		} else {
			//caso in cui ho deciso di accendere il wifi
			this.connessioneInternetOn();
		}
	}
	
	@Override
	public String toString() {
		return "[Stato: "+(stato?"acceso":"spento")+" - Connessione wi-fi: "+(connWifi?"connesso":"disconnesso")+" - Connessione Dati: " + (connDati?"connesso":"disconnesso") + "]";
	}

	public String getNumTel() {
		return numTel;
	}

	public boolean isConnDati() {
		return connDati;
	}

	public void connessioneInternetOff (boolean dati) {
		//metodo polimorfico per spegnere il wifi o la connessione dati
				if (dati) {
					//caso in cui ho selezionato la connessione dati
					if (connDati) {
						//la connessione dati è spenta
						connDati=false;
					}else {
						System.out.println("La connessione dati è già spenta");
					}
				} else {
					//caso in cui ho deciso di spegnere il wifi
					this.connessioneInternetOff();
				}
	}
}
