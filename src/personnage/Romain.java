package personnage;

public class Romain {

	private String nom;
	private int force;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert isInvariantVerified(); //arret le prog si faux
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		force -= forceCoup;
		assert isInvariantVerified();
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
	}
	
	private boolean isInvariantVerified() { //arret le prog si faux
		return force > 0;
	}

	public static void main(String[] args) {
		Romain tom = new Romain("Tom", 6);
		System.out.println(tom);
		
		tom.parler("Yooooo!");
		tom.recevoirCoup(3);
		
	}
}
