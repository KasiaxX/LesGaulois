package personnage;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villegeois; // un tableau avec les gaulois//
	private int nbVillageois = 0;

	public Village(String nom, int nbvillageoismax) {
		this.nom = nom;
		this.villegeois = new Gaulois[nbvillageoismax]; // creer un tableau//
	}

	public void ajouterHabitant(Gaulois gaulois) {
		villegeois[nbVillageois] = gaulois;
		nbVillageois++;
	}

	public Gaulois trouverHabitant(int x) {
		if( x < nbVillageois) {
			return villegeois[x];
		}else return null;
	}

	public String getNom() {
		return nom;
	}

	public void setChef(Chef chef) { // ajouter un Chef ds la classe (attribue chef)
		this.chef = chef;
	}

	public void affichierVillageois() {
		System.out.println("Dans village du chef " + chef.getNom() + " vivent les légendaires gaulois:");
		for (int i = 0; i < nbVillageois; i++) {
			System.out.println("-" + villegeois[i].getNom());
		}

	}

	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles", 30);
		// Gaulois gaulois = village.trouverHabitant(30);

		Chef chef = new Chef("Abraracourcix", 6, village);
		village.setChef(chef); // ??

		Gaulois asterix = new Gaulois("Asterix", 8);
		village.ajouterHabitant(asterix);
		
		Gaulois obelix = new Gaulois("Obélix", 25);
		village.ajouterHabitant(obelix);

//		Gaulois gaulois = village.trouverHabitant(1);
//		System.out.println(gaulois);
		
		village.affichierVillageois();

	}

}
