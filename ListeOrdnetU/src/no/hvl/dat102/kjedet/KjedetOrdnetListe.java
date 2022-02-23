package no.hvl.dat102.kjedet;

import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.exceptions.EmptyCollectionException;

/**
 * 
 * @param <T> elementypen
 */
public class KjedetOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {
	private int antall;
	private LinearNode<T> foerste, siste;

	/**
	 * Lager en ny tom liste.
	 */
	public KjedetOrdnetListe() {
		antall = 0;
		foerste = null;
		siste = null;
	}

	@Override
	public T fjernFoerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = foerste.getElement();

		// Sette foerste til å være den neste LinearNode (kan være null)
		foerste = foerste.getNeste();

		if (foerste == null) {
			siste = null;
		} else if (foerste.getNeste() == null) {
			siste = foerste;
		}

		antall -= 1;

		return resultat;
	}

	@Override
	public T fjernSiste() {
		// Hvis listen er tom
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		// Hvis listen har 1 element
		if (foerste.getNeste() == null) {
			T resultat = foerste.getElement();

			foerste = null;
			siste = null;
			antall = 0;

			return resultat;
		}

		// Hvis listen har 2 eller flere elementer
		LinearNode<T> nestSisteNode = foerste;
		while (nestSisteNode.getNeste().getNeste() != null) {
			nestSisteNode = nestSisteNode.getNeste();
		}

		T resultat = nestSisteNode.getNeste().getElement();

		nestSisteNode.setNeste(null);
		siste = nestSisteNode;
		antall -= 1;

		return resultat;
	}

	@Override
	public T foerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T svar = foerste.getElement();

		return svar;
	}

	@Override
	public T siste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = siste.getElement();

		return resultat;
	}

	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public void leggTil(T element) {
		LinearNode<T> nyNode = new LinearNode<T>(element);

		// Hvis listen er tom
		if (erTom()) {
			foerste = nyNode;
			siste = nyNode;
			antall = 1;

			return;
		}

		// Hvis listen har 1 eller flere elementer
		siste.setNeste(nyNode);
		siste = nyNode;
		antall += 1;
	}

	// Fra https://www.javatpoint.com/program-to-sort-the-elements-of-the-singly-linked-list
	@Override
	public void sorter() {
		if (erTom()) return;

		LinearNode<T> current = foerste, index = null;

		while(current != null) {
			// Node index will point to node next to current
			index = current.getNeste();

			while(index != null) {
				// If current node's data is greater than index's node data, swap the data between them

				if(current.getElement().compareTo(index.getElement()) > 0) {
					var temp = current.getElement();
					current.setElement(index.getElement());;
					index.setElement(temp);
				}
				index = index.getNeste();
			}
			current = current.getNeste();
		}
	}

	@Override
	public T fjern(T element) {
		T svar = null;
		LinearNode<T> forrige = null, denne = foerste;
		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			forrige = denne;
			denne = denne.getNeste();
		}
		if (denne != null && element.equals(denne.getElement())) { // funnet
			antall--;
			svar = denne.getElement();
			if (forrige == null) { // Første element
				foerste = foerste.getNeste();
				if (foerste == null) { // Tom liste
					siste = null;
				}
			} else { // Inni listen eller bak
				forrige.setNeste(denne.getNeste());
				if (denne == siste) { // bak
					siste = forrige;
				}
			}
		} // ikke-funn
		return svar;
	}

	@Override
	public boolean inneholder(T element) {
		LinearNode<T> denne = foerste;
		boolean resultat = false;
		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			denne = denne.getNeste();
		}
		if (denne != null) {
			if (element.equals(denne.getElement())) {
				resultat = true;
			}
		} // ikke-funn
		return resultat;
	}

	public String toString() {
		String resultat = "";

		LinearNode<T> node = foerste;
		while (node != null) {
			resultat = resultat + node.getElement().toString() + "\n";

			node = node.getNeste();
		}

		return resultat;
	}

}// class
