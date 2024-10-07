//Import des librairies pour la gestion des fichiers
import java.io.File; 
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class JSONUtils {
    private String nomFichier = "fichier.json";
    Gson gson = new Gson(); // Instanciation du GSON

	public JSONUtils() {
		// File monFichier = new File(nomFichier);
		//try {
			//if(monFichier.exists()) {
				//monFichier.delete();
				//System.out.println("Suppression du fichier en cours.");
			//}
			//if (monFichier.createNewFile()) {
			    //System.out.println("Fichier JSON initié :" + monFichier.getName());
			  //}
		//} catch (IOException e) {
			//e.printStackTrace();
		//}
	}
	// Création de bonbon
	public void CreerBonbon(Bonbon b) {
		List<Bonbon> listeBonbon = lireBonbons(); // Lire la liste actuelle
        listeBonbon.add(b); // Ajouter le nouveau bonbon
        sauvegarderBonbons(listeBonbon); // Sauvegarder la liste mise à jour
	}
	private List<Bonbon> lireBonbons() {
        File fichier = new File(nomFichier);
        // Vérifier si le fichier existe
        if (!fichier.exists()) {
            return new ArrayList<>(); // Si le fichier n'existe pas, retourner une liste vide
        }

        try (Reader reader = new FileReader(nomFichier)) {
            // Utiliser TypeToken pour lire une liste de bonbons
            Type listeBonbonsType = new TypeToken<List<Bonbon>>() {}.getType(); // Voir : https://stackoverflow.com/questions/43117731/what-is-type-typetoken
            List<Bonbon> maSuperListe = gson.fromJson(reader, listeBonbonsType);

            return maSuperListe != null ? maSuperListe : new ArrayList<>();
        } catch (IOException e) {
            throw new RuntimeException("Erreur lors de la lecture du fichier JSON : " + e.getMessage(), e);
        }
    }

    // Sauvegarder la liste de bonbons dans le fichier JSON
    private void sauvegarderBonbons(List<Bonbon> listeBonbon) {
        try (FileWriter writer = new FileWriter(nomFichier)) {
            gson.toJson(listeBonbon, writer); // Convertir et écrire la liste dans le fichier
        } catch (IOException e) {
            throw new RuntimeException("Erreur lors de la sauvegarde du fichier JSON : " + e.getMessage(), e);
        }
    }
    public void afficherTousBonbons() {
    	List<Bonbon> listeBonbons = lireBonbons(); // Lire tous les bonbons

        if (listeBonbons.isEmpty()) {
            System.out.println("Aucun bonbon trouvé.");
        } else {
            System.out.println("Liste des bonbons :");
            for (Bonbon bonbon : listeBonbons) {
                System.out.println(bonbon); // Utilisation de la méthode toString() de la classe Bonbon
            }
        }
    }
    // Méthode pour mettre à jour un bonbon existant
    public void mettreAJourBonbon(String idProduit, Bonbon nouveauBonbon) {
        List<Bonbon> listeBonbons = lireBonbons(); // Lire la liste actuelle
        boolean bonbonTrouve = false;
        // Rechercher le bonbon par son idProduit
        for (int i = 0; i < listeBonbons.size(); i++) {
            Bonbon bonbon = listeBonbons.get(i);
            System.out.println(bonbon);
            if (bonbon.getIdProduit().equals(idProduit)) {
                listeBonbons.set(i, nouveauBonbon); // Mets à jours le bonbon à la position trouvé dans la liste.
                bonbonTrouve = true;
                break;
            }
        }
        if (bonbonTrouve) {
            sauvegarderBonbons(listeBonbons); // Sauvegarder les modifications
            System.out.println("Le bonbon avec l'ID " + idProduit + " a été mis à jour.");
        } else {
            System.out.println("Bonbon avec l'ID " + idProduit + " non trouvé.");
        }
    }
    public void supprimerunBonbon(String idProduit) {
        List<Bonbon> listeBonbons = lireBonbons(); // Lire la liste actuelle
        boolean bonbonTrouve = false;
        System.out.println("Ma super méthode V8");
        // Rechercher le bonbon par son idProduit
        for (int i = 0; i < listeBonbons.size(); i++) {
            Bonbon bonbon = listeBonbons.get(i);
            System.out.println(bonbon);
            if (bonbon.getIdProduit().equals(idProduit)) {
                listeBonbons.remove(bonbon); // Supprimer le bonbon de la liste
                bonbonTrouve = true;
                break;
            }
        }
        if (bonbonTrouve) {
            sauvegarderBonbons(listeBonbons); // Sauvegarder les modifications
            System.out.println("Le bonbon avec l'ID " + idProduit + " a été supprimé.");
        } else {
            System.out.println("Bonbon avec l'ID " + idProduit + " non trouvé.");
        }
    }
}
