package personnage;

public class Romain {

	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;

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
		assert forceCoup > 0; //pre condition
		int forceTemp = force;
		
		force -= forceCoup;
		assert isInvariantVerified();
		
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
		assert forceTemp > force; //post condition
	}
	
	private boolean isInvariantVerified() { //arret le prog si faux
		return force > 0;
	}
	
	public void sEquiper(Equipement equip) {
		switch (nbEquipement) {
		case 2: 
			System.out.println("Le soldat " + nom + " est déjà bien protégé !");
		
		break;
		case 1:
			if (equipements[0] == equip) {
				System.out.println("Le soldat " + nom +" possède déjà un/une " + equip);
			} else {
				equipements[1] = equip;
				nbEquipement++;
				System.out.println("Le soldat " + nom + " s’équipe avec un/une " + equip);
			}
		
		break;
		default:
			equipements[0] = equip;
			nbEquipement++;
			System.out.println("Le soldat " + nom + " s’équipe avec un/une " + equip);
		}
	}

	public static void main(String[] args) {
		Romain tom = new Romain("Tom", 6);
		System.out.println(tom);
		
		tom.parler("Yooooo!");
		tom.recevoirCoup(3);
		
		
		for(Equipement equip : Equipement.values()) {
			System.out.println("-" + equip);
		}
		
		tom.sEquiper(Equipement.CASQUE);
		tom.sEquiper(Equipement.CASQUE);
		tom.sEquiper(Equipement.BOUCLIER);
		tom.sEquiper(Equipement.BOUCLIER);
		
	}
}
