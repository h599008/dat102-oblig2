package no.hvl.dat102.oppgave2;

public class Datakontakt {

	private static final int START_KAPASITET = 10;

	private int antall;
	private Medlem[] medlemTab;

	public Datakontakt() {
		antall = 0;
		medlemTab = new Medlem[START_KAPASITET];
	}

	public void leggTilMedlem(Medlem m) {

		if (antall == medlemTab.length)
			utvidKapasitet();

		medlemTab[antall] = m;
		antall++;
	}

	public int finnMedlemsIndeks(String navn) {

		for (int i = 0; i < antall; i++)
			if (navn.equals(medlemTab[i].getNavn()))
				return i;

		return -1;
	}

	public int finnPartnerFor(String navn) {
		int indeks1 = finnMedlemsIndeks(navn);
		if (indeks1 == -1)
			return -1;

		tilbakestillStatusIndeks(navn);
		int indeks2 = -1;

		for (int i = 0; i < antall && indeks2 == -1; i++)
			if (i != indeks1 && medlemTab[i].getStatusIndeks() == -1)
				if (medlemTab[indeks1].passerTil(medlemTab[i]))
					indeks2 = i;

		if (indeks2 != -1) {
			medlemTab[indeks1].setStatusIndeks(indeks2);
			medlemTab[indeks2].setStatusIndeks(indeks1);
		}

		return indeks2;
	}
	

	public void tilbakestillStatusIndeks(String navn) {
		int indeks1 = finnMedlemsIndeks(navn);
		if (indeks1 == -1)
			return;

		int indeks2 = medlemTab[indeks1].getStatusIndeks();

		if (indeks2 != -1) {
			medlemTab[indeks1].setStatusIndeks(-1);
			medlemTab[indeks2].setStatusIndeks(-1);
		}
	}

	public int getAntall() {
		return antall;
	}

	public Medlem[] getMedlemTab() {
		return medlemTab;
	}

	private void utvidKapasitet() {
		int nyKapasitet = medlemTab.length * 2;
		Medlem[] hjelpeTab = new Medlem[nyKapasitet];

		for (int i = 0; i < antall; i++) {
			hjelpeTab[i] = medlemTab[i];
		}

		medlemTab = hjelpeTab;
	}
	
}