package no.hvl.dat102.mengde.kjedet;
import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.*;
import no.hvl.dat102.mengde.klient.Bingokule;

public class ParentesMain {

	public static void main(String[] args) {
		ParentesKlasse p = new ParentesKlasse(new KjedetMengde<Character>());
	
		String s = "Dette er en test();";
		System.out.println(p.erBalansert("{{()()}")); // Uten par. false
		System.out.println(p.erBalansert("()()()[{{[()]}}]")); // true
		System.out.println(p.erBalansert("{{()()}")); // Mangler en slutt-"}". false
	
	}
	
}
