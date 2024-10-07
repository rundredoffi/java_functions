import java.io.*; 

public class XmlSupp {
    public static void main(String[] args) 
    { 
        File myFile = new File("./test.xml"); 
          
        if(myFile.delete()) 
        { 
            System.out.println("Fichier supprimé avec succès"); 
        } 
        else
        { 
            System.out.println("Impossible de supprimer le fichier"); 
        } 
    } 
}