import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XmlUpd {

    public static void main(String[] args) {
        try {
            // Charger le fichier XML
            File inputFile = new File("./test.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(inputFile);
            

            // Normaliser le document (optionnel, mais recommandé)
            document.getDocumentElement().normalize();

            // Trouver l'élément que vous souhaitez modifier
            NodeList nodes = document.getElementsByTagName("name"); // Remplacer par l'élément à modifier
            if (nodes.getLength() > 0) {
                Node node = nodes.item(0);
                node.setTextContent("Test"); // Mettre à jour la valeur
            }
            
            
            // Accéder aux éléments <employee>
            NodeList employeeList = document.getElementsByTagName("employee");  // Récupère tous les éléments <employee>.

            // Modifier le premier élément employee (id = 1)
            for (int i = 0; i < employeeList.getLength(); i++) {
                Node employee = employeeList.item(i);  // Récupère le i-ème élément <employee>.

                if (employee.getNodeType() == Node.ELEMENT_NODE) {  // Vérifie si c'est bien un élément (type de nœud).
                    Element employeeElement = (Element) employee;  // Convertit le nœud en un élément.

                    // Exemple : Modifier l'attribut 'id' de l'employé
                    String id = employeeElement.getAttribute("id");  // Récupère l'attribut 'id'.
                    if (id.equals("1")) {  // Si l'id est égal à "1".
                        employeeElement.setAttribute("id", "4");  // Change l'id à 100.
                    }
                }
            }
            
            
            

            // Enregistrer les modifications dans le fichier
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("./test.xml"));
            transformer.transform(source, result);

            System.out.println("Mise à jour du fichier XML réussie!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}