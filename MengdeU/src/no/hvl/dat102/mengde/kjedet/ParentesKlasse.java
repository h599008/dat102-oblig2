package no.hvl.dat102.mengde.kjedet;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.kjedet.*;

public class ParentesKlasse implements Parentessjekker {
	private int antall;
	private KjedetMengde<Character> stb;
	
	public ParentesKlasse(KjedetMengde<Character> stb) {

		this.stb = stb;
		this.antall = 0;
	}
	
	@Override
	public boolean erVenstreparentes(char p) {
		boolean result = false;
		
		if ((p == '(') || (p == '{') || (p == '[')) {
			result = true;
		}

		return result;
	}

	@Override
	public boolean erHogreparentes(char p) {
		boolean result = false;
		
		if ((p == ')') || (p == '}') || (p == ']')) {
			result = true;
		}

		return result;
	}

	@Override	
	public boolean erParentes(char p) {		
		return (erVenstreparentes(p) || erHogreparentes(p));
	}

	@Override
	public boolean erPar(char venstre, char hogre) {
		if (erVenstreparentes(venstre) && erHogreparentes(hogre)) {
			char[] tabv = { '(', '[', '{' };
			char[] tabh = { ')', ']', '}' };
			for (int i = 0; i < 3; i++) {
				if (venstre == tabv[i] && hogre == tabh[i]) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean erBalansert(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (erParentes(s.charAt(i))) {
				if (erVenstreparentes(s.charAt(i))) {
					stb.push(s.charAt(i));
					antall++;
				} else if (erHogreparentes(s.charAt(i)) && antall == 0) {
					empty();
					return false;
				} else if (erHogreparentes(s.charAt(i)) && antall != 0) {
					char x = stb.pop();
					antall--;
					if (!erPar(x, s.charAt(i))) {
						empty();
						return false;
					}
				}
			}
		}
		if (stb.erTom()) {
			return true;
		} else {
			empty();
			return false;
		}

	}
	
	public void empty() {
		while (!stb.erTom()) {
			stb.pop();
			antall--;
		}
	}

}
