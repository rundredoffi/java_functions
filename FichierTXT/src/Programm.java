import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.nio.file.StandardOpenOption;


public class Programm {

	private static String nomDuFichier;
	private static String emplacementDuFichier;
	private static String documentTXT;

    public static void main(String[] args)
    {
    	afficherMenu();
    }

    private static void initialisation() {
        Scanner leNomDuFichier = new Scanner(System.in);  // Créer un objet Scanner
        System.out.println("Entrez le nom du Fichier : ");
        nomDuFichier = leNomDuFichier.nextLine();  // Lis ce que écrit l'utilisateur
        
        // Split sur le point, en échappant le caractère
        if (nomDuFichier.contains(".txt")) {
        	nomDuFichier = nomDuFichier.split("\\.")[0];  // On prend juste la première partie avant le ".txt"
        } else {
        	nomDuFichier = nomDuFichier;  // Sinon on garde le nom tel quel
        }

        Scanner emplacementFichier = new Scanner(System.in);  // Créer un objet Scanner
        System.out.println("Entrez l'emplacement du Fichier : ");
        emplacementDuFichier = emplacementFichier.nextLine();  // Lis ce que écrit l'utilisateur

        // Concaténation du chemin d'accès et du nom de fichier avec l'extension .txt
        documentTXT = emplacementDuFichier + "\\" + nomDuFichier + ".txt";
        // System.out.println(documentTXT);
    }

    private static void ecriture() 
    {
    	Scanner leTexte = new Scanner(System.in);  // Créer un objet Scanner
		System.out.println("Entrez le contenu à ajouter a la fin du fichier : ");
		String leTexteDansLeFichier = leTexte.nextLine();  // Lis ce que écris l'utilisateur

        Path path = Paths.get(documentTXT);

        try {
            String str = leTexteDansLeFichier + "\n";
            byte[] bs = str.getBytes();
            Path writtenFilePath = Files.write(path, bs, StandardOpenOption.APPEND); // On ajoute le contenu dans le fichier
            System.out.println("Contenu écrit dans le fichier '"+ path +"' :\n"+ new String(Files.readAllBytes(writtenFilePath)));
        } catch (Exception e) {
            // e.printStackTrace();
        	System.out.println("Oups une erreur avec le fichier... :c");
        }

    }

    private static void supprContenuFichier() 
    {
    	Path path = Paths.get(documentTXT);
        try {
            String str = "";
            byte[] bs = str.getBytes();
            Path writtenFilePath = Files.write(path, bs);
            System.out.println("Le contenu du fichier  '"+ path +"' a été correctement supprimé.");
        } catch (Exception e) {
            // e.printStackTrace();
        	System.out.println("Oups une erreur avec le fichier... :c");
        }

    }

    private static void afficherContenuFichier() 
    {
    	Path path = Paths.get(documentTXT);
        try {
        	System.out.println("Contenu écrit dans le ficher '"+ path +"' :\n"+ new String(Files.readAllBytes(path))); // Affichage du contenu du fichier
        } catch (Exception e) {
            // e.printStackTrace();
        	System.out.println("Oups une erreur avec le fichier... :c");
        }

    }

    private static void supprFichier() 
    {
    	File FichierTXT = new File(documentTXT);
    	
    	try {
    		if (FichierTXT.delete()) // Suppression du fichier
                System.out.println("Le '"+ FichierTXT +"' fût supprimé avec succès");
            else
                System.out.println("Le '"+ FichierTXT +"' n'existe pas");
        } catch (Exception e) {
            // e.printStackTrace();
        	System.out.println("Oups une erreur avec le fichier... :c");
        }
        
    }

    private static void creationFichier()
    {
    	File FichierTXT = new File(documentTXT);

    	try {	
			if (FichierTXT.createNewFile()) // Création du fichier
			    System.out.println("Le " + nomDuFichier + " fût créé");
			else
			    System.out.println("Le Fichier existe déja");
		} catch (IOException e) {
			// e.printStackTrace();
			System.out.println("Oups une erreur avec le fichier... :c");
		}

    }

    private static void afficherMenu() 
    {
        String choix ="";

        while (!choix.equals("6")) // Tant que le choix est différent de quitter le programme
        {
            System.out.println("\nMenu des fichier TXT : \n"); // On affiche le menu
            System.out.println("1 - Créer un fichier.txt \n");
            System.out.println("2 - Écrire dans un fichier.txt existant \n");
            System.out.println("3 - Afficher le contenu d'un fichier.txt \n");
            System.out.println("4 - Supprimer tout le contenu d'un fichier.txt \n");
            System.out.println("5 - Supprimer un fichier.txt \n");
            System.out.println("6 - Sortie du programme \n");   

            Scanner nombre = new Scanner(System.in);
            System.out.println("Saisir votre choix : ");
            choix = nombre.nextLine(); // On récupère le choix de l'utilisateur
            
            if (!choix.equals("6"))
            	initialisation();
            
            switch (choix) // On effectue le choix de l'utilisateur
            {
                case "1": // Créer le fichier
                    creationFichier();
                    break;

                case "2": // Ecrire dans le fichier
                    ecriture();
                    break;

                case "3": // Afficher le contenu du fichier
                	afficherContenuFichier();
                    break;

                case "4": // Supprimer le contenu du fichier
                    supprContenuFichier();
                    break;

                case "5": // Supprimer le fichier
                    supprFichier();
                    break;

                case "6": // Quitter le programme
                    break;

                default: // Si l'utilisateur entre autre chose que souhaité
                    System.out.println("Vous devez saisir un choix compris entre 1 et 6");
                    break;
            }
            
        }

    }

}