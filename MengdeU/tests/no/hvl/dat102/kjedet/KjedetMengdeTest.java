package no.hvl.dat102.kjedet;
import no.hvl.dat102.mengde.*;
import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.adt.TestKjedetMengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;
import no.hvl.dat102.mengde.klient.Bingokule;
import no.hvl.dat102.*;

public class KjedetMengdeTest extends TestKjedetMengdeADT{
	@Override
		protected MengdeADT<Bingokule> reset() {
			return new KjedetMengde<Bingokule>();
	}
}
