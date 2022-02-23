package no.hvl.dat102.mengde.adt;
import no.hvl.dat102.mengde.adt.*;
import no.hvl.dat102.mengde.kjedet.*;
import no.hvl.dat102.mengde.klient.Bingokule;
import no.hvl.dat102.mengde.tabell.TabellMengde;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public abstract class TestTabellMengdeADT {
	
	private MengdeADT<Bingokule> mengde1;
	private MengdeADT<Bingokule> mengde2;

	// ulike_kjedet_mengde er mengder uten felles elementer.
	private MengdeADT<Bingokule> ulik_mengde1;
	private MengdeADT<Bingokule> ulik_mengde2;
	
	private Bingokule kule1;
	private Bingokule kule2;
	private Bingokule kule3;
	private Bingokule kule4;
	private Bingokule kule5;
	private Bingokule kule6;
	
	protected abstract MengdeADT<Bingokule> reset();
	
	@BeforeEach
	public void setUp() {
		mengde1 = new TabellMengde<>();
		mengde2 = new TabellMengde<>();
		
		// Ulik_mengde er mengder uten felles elementer.
		ulik_mengde1 = new TabellMengde<>();
		ulik_mengde2 = new TabellMengde<>();
		
		kule1 = new Bingokule(1);
		kule2 = new Bingokule(2);
		kule3 = new Bingokule(3);
		kule4 = new Bingokule(4);
		kule5 = new Bingokule(5);
		kule6 = new Bingokule(6);
		
		mengde1.leggTil(kule1);
		mengde1.leggTil(kule2);
		mengde1.leggTil(kule3);
		mengde1.leggTil(kule5);

		mengde2.leggTil(kule1);
		mengde2.leggTil(kule5);
		mengde2.leggTil(kule2);
		
		// Ulike kjedet mengder
		ulik_mengde1.leggTil(kule1);
		ulik_mengde1.leggTil(kule2);
		ulik_mengde1.leggTil(kule3);

		ulik_mengde2.leggTil(kule4);
		ulik_mengde2.leggTil(kule5);
		ulik_mengde2.leggTil(kule6);
	}
	
	@Test		
	public void testUnion() {
		MengdeADT<Bingokule> fasit = new TabellMengde<>();
		MengdeADT<Bingokule> union = new TabellMengde<>();
		fasit.leggTil(kule1);
		fasit.leggTil(kule2);
		fasit.leggTil(kule3);
		fasit.leggTil(kule5);
		
		union = mengde1.union(mengde2);
		assertTrue(union.equals(fasit));	
	}
	
	@Test
	public void testSnitt() {
		MengdeADT<Bingokule> fasit = new TabellMengde<>();
		MengdeADT<Bingokule> snitt = new TabellMengde<>();
		fasit.leggTil(kule1);
		fasit.leggTil(kule2);
		fasit.leggTil(kule5);
		
		snitt = mengde1.snitt(mengde2);
		assertTrue(snitt.equals(fasit));
	}
	
	@Test
	public void testDifferens() {
		MengdeADT<Bingokule> fasit = new TabellMengde<>();
		MengdeADT<Bingokule> differens = new TabellMengde<>();
		fasit.leggTil(kule3);
		
		differens = mengde1.differens(mengde2);
		assertTrue(differens.equals(fasit));
	}
	
	
	// Ulike menger:
	
	@Test		
	public void testUlikeUnion() {
		MengdeADT<Bingokule> fasit = new TabellMengde<>();
		MengdeADT<Bingokule> union = new TabellMengde<>();
		fasit.leggTil(kule1);
		fasit.leggTil(kule2);
		fasit.leggTil(kule3);
		fasit.leggTil(kule4);
		fasit.leggTil(kule5);
		fasit.leggTil(kule6);
		
		union = ulik_mengde1.union(ulik_mengde2);
		assertTrue(union.equals(fasit));	
	}
	
	@Test
	public void testUlikeSnitt() {
		MengdeADT<Bingokule> fasit = new TabellMengde<>();
		MengdeADT<Bingokule> snitt = new TabellMengde<>();		
		
		snitt = ulik_mengde1.snitt(ulik_mengde2);
		assertTrue(snitt.equals(fasit));
	}
	
	@Test
	public void testUlikeDifferens() {
		MengdeADT<Bingokule> fasit = new TabellMengde<>();
		MengdeADT<Bingokule> differens = new TabellMengde<>();
		fasit.leggTil(kule1);
		fasit.leggTil(kule2);
		fasit.leggTil(kule3);
		
		differens = ulik_mengde1.differens(ulik_mengde2);
		assertTrue(differens.equals(fasit));
	}
}
