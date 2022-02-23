package no.hvl.dat102.tabell;
import no.hvl.dat102.mengde.*;
import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.adt.TestKjedetMengdeADT;
import no.hvl.dat102.mengde.adt.TestTabellMengdeADT;
import no.hvl.dat102.mengde.klient.Bingokule;
import no.hvl.dat102.mengde.tabell.TabellMengde;
import no.hvl.dat102.*;

public class TabellMengdeTest extends TestTabellMengdeADT{
	@Override
		protected MengdeADT<Bingokule> reset() {
			return new TabellMengde<Bingokule>();
	}
}
