package no.hvl.dat102.oppgave2;

import java.util.Scanner;

public class Tekstgrensesnitt {

	private static Scanner scanner = new Scanner(System.in);


	public static void leggTilMedlemmer(Datakontakt arkiv) {
		Medlem m1 = new Medlem("Rolf Halvorsen");
		m1.leggTilHobby("Matlaging");
		m1.leggTilHobby("Fotball");
		arkiv.leggTilMedlem(m1);

		Medlem m2 = new Medlem("Einar Hansen");
		m2.leggTilHobby("Ski");
		m2.leggTilHobby("Løpe");
		m2.leggTilHobby("Sykle");
		arkiv.leggTilMedlem(m2);

		Medlem m3 = new Medlem("Ida Larsen");
		m3.leggTilHobby("Male");
		m3.leggTilHobby("Friidrett");
		arkiv.leggTilMedlem(m3);

		Medlem m4 = new Medlem("Ole Gunnar");
		m4.leggTilHobby("Innebandy");
		m4.leggTilHobby("Langrenn");
		arkiv.leggTilMedlem(m4);
		m4.leggTilHobby("Se på fotball");

		Medlem m5 = new Medlem("Petter Northug");
		m5.leggTilHobby("Dra på byn");
		m5.leggTilHobby("Barneskirenn");
		m5.leggTilHobby("Soling");
		arkiv.leggTilMedlem(m5);

	}

	public static void finnPartnere(Datakontakt arkiv) {
		int antall = arkiv.getAntall();
		Medlem[] medlemTab = arkiv.getMedlemTab();

		for (int i = 0; i < antall; i++) {
			if (medlemTab[i].getStatusIndeks() == -1) {
				String navn = medlemTab[i].getNavn();
				arkiv.finnPartnerFor(navn);
			}
		}
	}

	public static void skrivHobbyListe(Medlem m) {
		System.out.println(m.getHobbyer().toString());
	}

	public static void skrivParListe(Datakontakt arkiv) {
		int antall = arkiv.getAntall();
		Medlem[] medlemTab = arkiv.getMedlemTab();
		int antallPar = 0;

		System.out.println("\nPARNAVN\t\t\t\t\tHOBBYER");

		for (int indeks1 = 0; indeks1 < antall; indeks1++) {
			int indeks2 = medlemTab[indeks1].getStatusIndeks();

			if (indeks2 != -1 && indeks2 > indeks1) {
				Medlem m1 = medlemTab[indeks1];
				Medlem m2 = medlemTab[indeks2];
				antallPar++;

				System.out.format("%s og %s\t\t%s%n", m1.getNavn(), m2.getNavn(), m1.getHobbyer());
			}
		}

		System.out.println("Antall par funnet: " + antallPar);
	}

	public static Medlem lesMedlem() {
		System.out.print("Oppgi navn (bruk mellomrom mellom hver hobby): ");
		String navn = scanner.nextLine();
		System.out.print("Oppgi hobbyer: ");
		String hobbyer = scanner.nextLine();

		Medlem nyMedlem = new Medlem(navn);

		for (String hobby : hobbyer.split("\\s+")) {
			nyMedlem.leggTilHobby(hobby);
		}

		return nyMedlem;
	}
	
}