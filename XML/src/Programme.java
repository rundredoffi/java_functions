import java.io.*;
import org.jdom2.*;
import org.jdom2.output.*;

public class Programme {

    public static void main(String[] args) {
        try {
             Element entreprise = new Element("entreprise");
            Document doc = new Document(entreprise);
            Element employee1 = new Element("employee");
            employee1.setAttribute(new Attribute("id", "1"));
            employee1.addContent(new Element("name").setText("Mael"));
            employee1.addContent(new Element("age").setText("19"));
            employee1.addContent(new Element("address").setText("Tarbes"));
            doc.getRootElement().addContent(employee1);
            Element employee2 = new Element("employee");
            employee2.setAttribute(new Attribute("id", "2"));
            employee2.addContent(new Element("name").setText("Mabou"));
            employee2.addContent(new Element("age").setText("23"));
            employee2.addContent(new Element("address").setText("Vendome"));
            doc.getRootElement().addContent(employee2);
            XMLOutputter xml = new XMLOutputter();
            xml.setFormat(Format.getPrettyFormat());
            xml.output(doc, new FileWriter("./test.xml"));
            System.out.println("Fichier enregistré!");
        } catch (Exception e) {
           e.printStackTrace();
        }
      }
    
}