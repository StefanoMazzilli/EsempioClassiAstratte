package org.generation.italy;

import java.util.Scanner;

import org.generation.italy.model.Case;
import org.generation.italy.model.Cellulare;
import org.generation.italy.model.Computer;

public class Main {

	public static void main(String[] args) {
		
		//variabili
		String risposta;
		Scanner sc= new Scanner (System.in);
		Computer c;
		String programma;
		String selezioneConn;
		boolean dati;
		
		//gli faccio generare un laptop o un cellulare
		System.out.println("Creazione computer in corso. Preferisci un Case o un Cellulare?");
		risposta=sc.nextLine().toLowerCase();
		
		if (risposta.equals("cellulare")) {
			c=new Cellulare();
			System.out.println("Cellulare creato con successo!");
		} else {
			c=new Case();
			System.out.println("Case creato con successo!");
		}
		
		//gestione del dispositivo
		do {
			System.out.println("\n\nMenù di gestione del dispositivo");
			System.out.println("Selezionare l'operazione da svolgere");
			System.out.println("1) Accensione\n2) Spegnimento\n3) Connessione a internet\n4) Spegnimento connessione a internet\n5) Altri dispositivi\n6) Visualizza stato\n7) ESCI");
			programma=sc.nextLine();
			
			switch (programma) {
			case "1":
				c.accendi();
				break;
				
			case "2":
				c.spegni();
				break;
				
			case "3":
				if (c instanceof Cellulare) {
					//il dispositivo è un cellulare
					System.out.println("Accendere connessione dati o wifi?");
					selezioneConn= sc.nextLine().toLowerCase();
					
					if(selezioneConn.equals("dati")) {
						//accensione connessione dati
						dati=true;
					} else {
						//accensione wifi
						dati=false;
					}
					//casting sul dispositivo per trattarlo come un cellulare
					((Cellulare)c).connessioneInternetOn(dati);
				} else {
					//il dispositivo è un case
					c.connessioneInternetOn();
				}
				break;
				
			case "4":
				if (c instanceof Cellulare) {
					//il dispositivo è un cellulare
					System.out.println("Spegnere connessione dati o wifi?");
					selezioneConn= sc.nextLine().toLowerCase();
					
					if(selezioneConn.equals("dati")) {
						//accensione connessione dati
						dati=true;
					} else {
						//accensione wifi
						dati=false;
					}
					//casting sul dispositivo per trattarlo come un cellulare
					((Cellulare)c).connessioneInternetOff(dati);
				} else {
					//il dispositivo è un case
					c.connessioneInternetOff();
				}
				break;
				
			case "5":
				if (c instanceof Case) {
					//il dispositivo è un case
					if (((Case)c).isTastiera()==false) {
						System.out.println("La tastiera è scollegata. Ora la collego");
						((Case)c).setTastiera(true);
					} else {
						System.out.println("La tastiera è collegata. Ora la scollego");
						((Case)c).setTastiera(false);
					}
				} else {
					//il dispositivo è un cellulare
					System.out.println("Il dispositivo non supporta ancora collegamenti ad altri dispositivi!");
				}
				break;
				
			case "6":
				if (c instanceof Case) {
					System.out.println(((Case)c).toString());
				} else {
					System.out.println(((Cellulare)c).toString());
				}
				break;
				
			case "7":
				System.out.println("Arrivederci!");
				break;
				
			default:
				System.out.println("Selezione non valida!");
			}
			
		}while (!programma.equals("7"));
	}

}
