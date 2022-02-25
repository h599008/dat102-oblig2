package no.hvl.dat102.oppgave2;

public class Klient extends Tekstgrensesnitt	{
  
	public static void main(String[] args) {
		Datakontakt arkiv = new Datakontakt();

		leggTilMedlemmer(arkiv);
		arkiv.leggTilMedlem(lesMedlem());
		finnPartnere(arkiv);
		skrivParListe(arkiv);
	
	}
}