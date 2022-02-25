package no.hvl.dat102.oppgave2;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;

public class Medlem {

	private String navn;
	private MengdeADT<Hobby> hobbyer;
	private int statusIndeks;

	public Medlem(String navn) {
		this.navn = navn;
		hobbyer = new KjedetMengde<Hobby>();
		statusIndeks = -1;
	}

	public boolean passerTil(Medlem medlem2) {
		if (this == medlem2) {
			return false;
		}

		if (hobbyer.erTom())
			return false;

		return (hobbyer.equals(medlem2.getHobbyer()));
	}

	public void leggTilHobby(String hobby) {
		hobbyer.leggTil(new Hobby(hobby));
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Navn: ");
		sb.append(navn);
		sb.append('\n');
		sb.append("Hobbyer: ");
		sb.append(hobbyer.toString());
		sb.append('\n');
		sb.append("Statusindeks: ");
		sb.append(statusIndeks);

		return (sb.toString());
	}

	public String getNavn() {
		return navn;
	}

	public MengdeADT<Hobby> getHobbyer() {
		return hobbyer;
	}

	public int getStatusIndeks() {
		return statusIndeks;
	}

	public void setStatusIndeks(int statusIndeks) {
		this.statusIndeks = statusIndeks;
	}
	
	public void SkrivUt() {
		System.out.println(navn);
		System.out.println(hobbyer);
		System.out.println(statusIndeks);
	}
	
}