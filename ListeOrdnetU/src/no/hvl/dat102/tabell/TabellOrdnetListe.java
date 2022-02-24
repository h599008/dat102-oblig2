package no.hvl.dat102.tabell;

import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.exceptions.EmptyCollectionException;

import java.util.Arrays;

public class TabellOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {

	private final static int STDK = 100;
	private final static int IKKE_FUNNET = -1;
	private int antall;
	private T[] liste;

	public TabellOrdnetListe() {
		this(STDK);
	}

	public TabellOrdnetListe(int startKapasitet) {
		antall = 0;
		liste = (T[]) (new Comparable[startKapasitet]);
	}

	@Override
	public T fjernSiste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		var sisteIndex = antall - 1;
		T resultat = liste[sisteIndex];
		liste[sisteIndex] = null;
		antall -= 1;

		return resultat;
	}

	@Override
	public T fjernFoerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = liste[0];

		// Shifte hele arrayen mot venstre
		System.arraycopy(liste, 1, liste, 0, antall);
		antall -= 1;

		return resultat;
	}

	@Override
	public T foerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = liste[0];
		return resultat;
	}

	@Override
	public T siste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");
		
		T resultat = liste[antall - 1];

		return resultat;
	}

	@Override
	public boolean erTom() {
		return (antall == 0);
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public void leggTil(T element) {
		if (antall == liste.length) {
			utvid();
		}

		if (erTom()) {
			liste[0] = element;
			antall = 1;
			return;
		}

		// Hvis elementet må legges til midt i listen ett sted
		for (int i = 0; i < antall; i++) {
			if (element.compareTo(liste[i]) <= 0) {
				System.arraycopy(liste, i, liste, i + 1, antall - i);

				liste[i] = element;
				antall++;

				return;
			}
		}

		// Hvis elementet skal legges til på slutten av listen
		liste[antall] = element;
		antall++;
	}

	@Override
	public boolean inneholder(T element) {
		return (finn(element) != IKKE_FUNNET);
	}

	@Override
	public T fjern(T element) {
		var index = finn(element);
		if (index == IKKE_FUNNET) return null;

		var resultat = liste[index];

		// Shifte hele arrayen mot venstre, der hvor elementet skal bli slettet
		System.arraycopy(liste, index + 1, liste, index, antall - index);
		antall -= 1;

		return resultat;
	}

	private int finn(T el) {
		for (int i = 0; i < antall; i++) {
			if (liste[i].equals(el)) {
				return i;
			}
		}

		return IKKE_FUNNET;
	}

	public String toString() {
		String resultat = "";

		for (int i = 0; i < antall; i++) {
			resultat = resultat + liste[i].toString() + "\n";
		}
		return resultat;
	}

	private void utvid() {
		T[] hjelpeTabell = (T[]) (new Comparable[liste.length * 2]);

		for (int i = 0; i < liste.length; i++) {
			hjelpeTabell[i] = liste[i];
		}

		liste = hjelpeTabell;
	}

}// class
