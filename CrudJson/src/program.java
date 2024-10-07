public class program {
	public static void main(String[] args) {
		System.out.println("Hello world!");
		Bonbon monSuperbonbon = new Bonbon("bar33","Des super barres 22", 5.0); // Création d'un objet BONBON
		Bonbon monBonbon = new Bonbon("bar43","Des super barres 22", 5.0); // Création d'un objet BONBON
		Bonbon monBonbonDiesel = new Bonbon("diesel","Des super barres 22", 5.0); // Création d'un objet BONBON
		Bonbon monBonbonSuperV8 = new Bonbon("diesel","Max rebo (Ou Mansa Moussa) qui est le cousin a Brandon", 5.0); // Création d'un objet BONBON

		JSONUtils monUtils = new JSONUtils();
		monUtils.afficherTousBonbons();
		System.out.println("//////////////////////////////////////");
		monUtils.CreerBonbon(monSuperbonbon);
		monUtils.CreerBonbon(monBonbon);
		monUtils.CreerBonbon(monBonbonDiesel);
		monUtils.afficherTousBonbons();
		System.out.println("//////////////////////////////////////");
		System.out.println("Mise à jour du bonbon Diesel");
		monUtils.mettreAJourBonbon("diesel", monBonbonSuperV8);
		monUtils.afficherTousBonbons();
		System.out.println("//////////////////////////////////////");
		System.out.println("Suppression d'un bonbon");
		monUtils.supprimerunBonbon("bar43");
		System.out.println("//////////////////////////////////////");
		System.out.println("Nouvelle état de la liste");
		monUtils.afficherTousBonbons();
	}
}