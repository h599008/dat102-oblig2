package no.hvl.dat102.mengde.klient;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;
import no.hvl.dat102.mengde.tabell.TabellMengde;

public class KlientBingo {
	// Oppretter 2 mengder med 75 bingokuler i hver.
	// Tester om en spesiell bingokule er med i den ene mengden,
	// og om de to mengdene er n�yaktig like.

	public static void main(String[] args) {
		final int ANTALL_BALLER = 75;
		MengdeADT<Bingokule> mengde1 = new TabellMengde<>();
		MengdeADT<Bingokule> mengde2 = new TabellMengde<>();
		
		MengdeADT<Bingokule> kjedet_mengde1 = new KjedetMengde<>();
		MengdeADT<Bingokule> kjedet_mengde2 = new KjedetMengde<>();
		
		Bingokule kule1 = new Bingokule(1);
		Bingokule kule2 = new Bingokule(2);
		Bingokule kule3 = new Bingokule(3);
		Bingokule kule4 = new Bingokule(4);
		Bingokule kule5 = new Bingokule(5);

		mengde1.leggTil(kule1);
		mengde1.leggTil(kule2);
		mengde1.leggTil(kule3);
		mengde1.leggTil(kule5);

		mengde2.leggTil(kule1);
		mengde2.leggTil(kule5);
		mengde2.leggTil(kule2);


		
		MengdeADT<Bingokule> differens = new TabellMengde<>();
		
		differens = mengde1.differens(mengde2);
		System.out.println(differens);
		
		for (int i = 1; i <= ANTALL_BALLER; i++) {
			kule1 = new Bingokule(i);
			kule2 = new Bingokule(ANTALL_BALLER + 1 - i);
			mengde1.leggTil(kule1);
			mengde2.leggTil(kule2);
		}
		
		System.out.println("\nAntall kuler totalt: " + mengde1.antall());
		System.out.println();

		kule1 = new Bingokule(10);
		if (mengde1.inneholder(kule1)) {
			System.out.println("kule 1 funnet i mengde 1");
		}

		if (mengde1.equals(mengde2)) {
			System.out.println("Like mengder");
		}

		if (!mengde1.erTom()) {
			mengde1.fjern(kule1);
			if (!mengde1.equals(mengde2)) {
				System.out.println("Ulike mengder");
			}
		}

	}
}// class