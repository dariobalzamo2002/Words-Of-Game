package gioco.parole.controller;

import gioco.parole.view.View;

public class Main {

	// VARIABILI GLOBALI
	final static String[] PAROLE_MISTERIOSE = new String[] { "lente", "fiore", "dolce" };
	final static byte SIZE_PAROLA_MISTERIOSA = 5;
	final static byte TENTATIVI = 10;
	final static View VIEW = new View();

	// VARIABILI PROGRAMMA
	static boolean win = false;
	static String parolaGenerata, word, restart;
	static byte numeroTentativi;

	public static void main(String[] args) {
		// BUSINESS LOGIC
		do {
			play();
			if (numeroTentativi == TENTATIVI) {
				System.out.println("OPS RITENTA, HAI ESAURITO I TENTATIVI !!");
			}
			restart = VIEW.leggiStringa("\nVuoi restartare (Y/N) ?");
		} while (restart.toUpperCase().equals("Y"));
		System.out.println("ALLA PROSSIMA");
	}

	public static void play() {
		System.out.println("################################ Welcome to Guess The Word ################################");
		System.out.println("INDOVINA LA PAROLA NASCOSTA");
		numeroTentativi = 0;
		parolaGenerata = VIEW.generaParola(PAROLE_MISTERIOSE);
		do {
			System.out.println("TENTATIVO[" + ++numeroTentativi + "/" + TENTATIVI + "]");
			word = VIEW.wordValidation(SIZE_PAROLA_MISTERIOSA);
			win = VIEW.wordChecker(parolaGenerata, word);

			// CONTROLLO SE LA PAROLA E' STATA INDOVINATA ESCO ALTRIMENTI MESSAGGIO DI ERRORE
			if (win) {
				System.out.println("\nCOMPLIMENTI HAI INDOVINATO LA PAROLA");
			} else {
				System.err.println("\nPAROLA ERRATA");
			}
		} while (numeroTentativi < TENTATIVI && !win);
	}

}