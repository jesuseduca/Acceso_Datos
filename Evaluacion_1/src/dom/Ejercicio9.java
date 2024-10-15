package dom;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class Ejercicio9 {
	public final static String FICHATRABAJO = "ejercicio9.xml";

	public static void main(String[] args) {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			try {
				Document doc = db.parse(new File(Ejercicio3.RUTA_DATOS + FICHATRABAJO));
			
				URL url = new URL ("https://acortar.link/dO4FNx");
				Document docWeb = db.parse(url.openStream());
		
				TransformerFactory tF = TransformerFactory.newInstance();
				Transformer t = tF.newTransformer();
				t.transform(new DOMSource(doc), new StreamResult(System.out));
				System.out.println("DOCUMENTO WEB");
				t.transform(new DOMSource(docWeb), new StreamResult(System.out));

			
			
			} catch (TransformerConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TransformerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	}
	
