package test;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class domTest {

	public static void main(String[] args) {
		try {
		String url = "./src/test/testXML.xml";
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		Document doc = builder.parse(url);
			
		doc.getDocumentElement().normalize();
		
		System.out.println("Root element" +doc.getDocumentElement().getNodeName());
		
		NodeList nodeList = doc.getElementsByTagName("data");
		for(int i=0; i<nodeList.getLength(); i++){
			Node node = nodeList.item(i);
			NodeList childList = node.getChildNodes();
			for(int j=0; j<childList.getLength();j++){
				Node child = childList.item(j);
				if(child.getNodeType() == node.ELEMENT_NODE){
					System.out.println(child.getNodeName() +" : " + child.getTextContent());
				}
			}
			System.out.println("=================================");
		}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
