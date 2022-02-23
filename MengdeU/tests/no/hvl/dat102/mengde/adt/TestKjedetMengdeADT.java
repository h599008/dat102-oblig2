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

public abstract class TestKjedetMengdeADT {

	private MengdeADT<Bingokule> kjedet_mengde1;
	private MengdeADT<Bingokule> kjedet_mengde2;
	
	private MengdeADT<Bingokule> ulike_kjedet_mengde1;
	private MengdeADT<Bingokule> ulike_kjedet_mengde2;
	
	private Bingokule kule1;
	private Bingokule kule2;
	private Bingokule kule3;
	private Bingokule kule4;
	private Bingokule kule5;
	private Bingokule kule6;
	
	protected abstract MengdeADT<Bingokule> reset();
	
	@BeforeEach
	public void setUp() {
		
		kjedet_mengde1 = new KjedetMengde<>();
		kjedet_mengde2 = new KjedetMengde<>();
		
		// ulike_kjedet_mengde er mengder uten felles elementer.
		ulike_kjedet_mengde1 = new KjedetMengde<>();
		ulike_kjedet_mengde2 = new KjedetMengde<>();
		
		kule1 = new Bingokule(1);
		kule2 = new Bingokule(2);
		kule3 = new Bingokule(3);
		kule4 = new Bingokule(4);
		kule5 = new Bingokule(5);
		kule6 = new Bingokule(6);

		kjedet_mengde1.leggTil(kule1);
		kjedet_mengde1.leggTil(kule2);
		kjedet_mengde1.leggTil(kule3);
		kjedet_mengde1.leggTil(kule5);

		kjedet_mengde2.leggTil(kule1);
		kjedet_mengde2.leggTil(kule5);
		kjedet_mengde2.leggTil(kule2);
	
	
		// Ulike kjedet mengder:
		ulike_kjedet_mengde1.leggTil(kule1);
		ulike_kjedet_mengde1.leggTil(kule2);
		ulike_kjedet_mengde1.leggTil(kule3);

		ulike_kjedet_mengde2.leggTil(kule4);
		ulike_kjedet_mengde2.leggTil(kule5);
		ulike_kjedet_mengde2.leggTil(kule6);
	}
	
	@Test		
	public void testUnion() {
		MengdeADT<Bingokule> fasit = new KjedetMengde<>();
		MengdeADT<Bingokule> union = new KjedetMengde<>();
		fasit.leggTil(kule1);
		fasit.leggTil(kule2);
		fasit.leggTil(kule3);
		fasit.leggTil(kule5);
		
		union = kjedet_mengde1.union(kjedet_mengde2);
		assertTrue(union.equals(fasit));
	}
	
	@Test
	public void testSnitt() {
		MengdeADT<Bingokule> fasit = new KjedetMengde<>();
		MengdeADT<Bingokule> snitt = new KjedetMengde<>();
		fasit.leggTil(kule1);
		fasit.leggTil(kule2);
		fasit.leggTil(kule5);
		
		snitt = kjedet_mengde1.snitt(kjedet_mengde2);
		assertTrue(snitt.equals(fasit));
	}
	
	@Test
	public void testDifferens() {
		MengdeADT<Bingokule> fasit = new KjedetMengde<>();
		MengdeADT<Bingokule> differens = new KjedetMengde<>();
		fasit.leggTil(kule3);
		
		differens = kjedet_mengde1.differens(kjedet_mengde2);
		assertTrue(differens.equals(fasit));
	}
	
	// Ulike kjedet mengder:
	
	@Test		
	public void testUlikeUnion() {
		MengdeADT<Bingokule> fasit = new KjedetMengde<>();
		MengdeADT<Bingokule> union = new KjedetMengde<>();
		fasit.leggTil(kule1);
		fasit.leggTil(kule2);
		fasit.leggTil(kule3);
		fasit.leggTil(kule4);
		fasit.leggTil(kule5);
		fasit.leggTil(kule6);
		
		union = ulike_kjedet_mengde1.union(ulike_kjedet_mengde2);
		assertTrue(union.equals(fasit));
	}
	
	@Test
	public void testUlikeSnitt() {
		MengdeADT<Bingokule> fasit = new KjedetMengde<>();
		MengdeADT<Bingokule> snitt = new KjedetMengde<>();
	
		snitt = ulike_kjedet_mengde1.snitt(ulike_kjedet_mengde2);
		assertTrue(snitt.equals(fasit));
	}
	
	@Test
	public void testUlikeDifferens() {
		MengdeADT<Bingokule> fasit = new KjedetMengde<>();
		MengdeADT<Bingokule> differens = new KjedetMengde<>();
		fasit.leggTil(kule1);
		fasit.leggTil(kule2);
		fasit.leggTil(kule3);
		
		differens = ulike_kjedet_mengde1.differens(ulike_kjedet_mengde2);
		assertTrue(differens.equals(fasit));
	}
	
}
