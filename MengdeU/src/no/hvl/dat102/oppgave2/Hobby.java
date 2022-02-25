package no.hvl.dat102.oppgave2;

public class Hobby {

	private String hobbyNavn;

	public Hobby(String hobby) {
		hobbyNavn = hobby;
	}

	@Override
	public String toString() {
		return ("<" + hobbyNavn + ">");
	}

	@Override
	public boolean equals(Object hobby2) {

		if (this == hobby2)
			return true;

		if (hobby2 == null)
			return false;

		if (getClass() != hobby2.getClass())
			return false;

		String hobby2Navn = ((Hobby) hobby2).getHobbyNavn();
		return (hobbyNavn.equals(hobby2Navn));
	}

	public String getHobbyNavn() {
		return hobbyNavn;
	}

	public void setHobbyNavn(String hobby) {
		hobbyNavn = hobby;
	}
	
	
}