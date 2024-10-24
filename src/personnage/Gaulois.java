package personnage;

public class Gaulois {

	private String nom;
	private int force;
	private int effetPotion = 1;
	private int force, nb_trophees;
	private Equipement trophees[] = new Equipement[100];

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + ">>");
	}

//	private String prendreParole() {
//		return "Le Gaulois " + nom + " : ";
//
//	}

//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoi un grand coup dans la mâchoire de " + romain.getNom());
//		romain.recevoirCoup(force / 3 * effetPotion);
//	}

	public void boirePotion(int force) {
		effetPotion = force;
		parler("Merci Druide, je sens que ma force est " + force + " fois décuplée");

	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	
	private String prendreParole() {
		String texte = "Le gaulois " + nom + " : ";
		return texte;
	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement trophees[] = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; trophees != null && i < trophees.length; i++, nb_trophees++) {
			this.trophees[nb_trophees] = trophees[i];
		}
		return;
	}


	public static void main(String[] args) {
		//creer gaulois asterix
		Gaulois asterix = new Gaulois("Astérix", 8);
		
		//print nom, force, effetPotion
		System.out.println(asterix);
		
		//prendreParole verif
		asterix.prendreParole();
		
		//parler verif
		asterix.parler("Hello");

		//creer Romain Tom
		Romain tom = new Romain("Tom", 5);

		// frapper verif
		asterix.frapper(tom);
		
		//boirePotion verif
		asterix.boirePotion(4);

	}

}
