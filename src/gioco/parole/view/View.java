package gioco.parole.view;

import java.util.Random;
import java.util.Scanner;

public final class View {

	public String generaParola(String[] parole) {
		Random random = new Random();
		int sizeArray = parole.length;
		return parole[random.nextInt(sizeArray)];
	}

	public String leggiStringa(String messaggio) {
		Scanner input = new Scanner(System.in);
		System.out.println(messaggio);
		return input.nextLine();
	}

	public void printWord(char[] chars) {
		for (char c : chars) {
			System.out.print(c + "\t");
		}
		System.out.println();
	}
	
	public boolean wordChecker(String parolaGenerata, String word) {
		// VARIABILI LOCALI
		byte i, j;
		char[] charsPS = parolaGenerata.toCharArray();       	// parola misteriosa generata
		char[] charsW = word.toCharArray(); 					// parola inserita dall'utente
		char[] symbols = new char[parolaGenerata.length()]; 	// array di simboli

		// BUSINESS LOGIC METHOD
		printWord(charsW);										// STAMPA PAROLA INSERITA

		if (word.equalsIgnoreCase(parolaGenerata)) {			// CASO 1) PAROLA UGUALE = RESTITUISCO TRUE
			for (i = 0; i < word.length(); i++) {
				symbols[i] = '✓';
			}
			printWord(symbols);
			return true;
		} else {												// CASO 2) PAROLA DIFFERENTE = RESTITUISCO FALSE
			for (i = 0; i < charsW.length; i++) {				// ESISTE IL METODO indexOf() per la ricerca del char
				for (j = 0; j < charsPS.length; j++) {
					if (charsW[i] != charsPS[j])				// LETTERA NON PRESENTE
						symbols[i] = '☓';
					else {										// LETTERA PRESENTE E CORRISPONDENZA NON ESATTA
						symbols[i] = '☆';
						break;
					}
				}
			}
			printWord(symbols);									// VISUALIZZAZIONE SIMBOLI
			return false;
		}
	}

	public String wordValidation(byte sizeParolaMisteriosa) {	
		String word = leggiStringa("SCRIVI LA PAROLA: ");
		
		while(word.length()!= sizeParolaMisteriosa) {			// CICLO DI VALIDAZIONE DELLA PAROLA
			System.err.println("SCRIVERE UNA PAROLA DI 5 LETTERE !!");
			return leggiStringa("SCRIVI LA PAROLA: ");
		}
		return word;
	}
		
}