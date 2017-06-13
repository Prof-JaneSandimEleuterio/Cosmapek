package mapekcosmos.reader.core.io.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import mapekcosmos.reader.core.io.AbstractConfigurationReader;
import mapekcosmos.reader.core.io.UnsupportedModelException;
import mapekcosmos.reader.prov.IManager;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * @author Junior Cupe Casquina
 */
public class XmlConfigurationReader extends AbstractConfigurationReader
    implements XmlConfigurationTags {
    private XmlManager xmlM;
    private IManager manager;

    public XmlConfigurationReader(IManager manager) {
        this.manager = manager;
        this.xmlM = new XmlManager(manager);
    }

    @Override protected void parseInputStream(InputStream inputStream)
        throws UnsupportedModelException {

        Document doc = null;//represent the xml
        try {
            doc = PositionalXMLReader.readXML(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        doc.getDocumentElement().normalize();
        for (Element e : getElements(doc.getElementsByTagName(CONFIG))) {
            parseComponets(e.getElementsByTagName(COMPONENTS));
            parseFeatures(e.getElementsByTagName(FEATURES));
            parseConnectors(e.getElementsByTagName(CONNECTORS));
        }
    }

    private void parseConnectors(NodeList connectors) {
        for (Element e : getElements(connectors)) {
            parseConnector(e.getChildNodes());
        }
    }

    private void parseConnector(NodeList connector) {
        String name = "";
        String origin = "";
        String destination = "";
        int orderT = 1;
        for (Element e : getElements(connector)) {
            String nodeName = e.getNodeName();
            if (nodeName.equals(CONNECTOR)) {
                if (e.hasAttributes()) {
                    NamedNodeMap nodeMap = e.getAttributes();
                    for (int i = 0; i < nodeMap.getLength(); i++) {
                        org.w3c.dom.Node node = nodeMap.item(i);
                        String attributeName = node.getNodeName();
                        String attributeValue = node.getNodeValue();
                        if (attributeName.equals(NAME)) {
                            name = attributeValue;
                        } else if (attributeName.equals(ORIGIN)) {
                            origin = attributeValue;
                        } else if (attributeName.equals(DESTINATION)) {
                            destination = attributeValue;
                        } else if (attributeName.equals(ORDERT)) {
                            orderT = Integer.parseInt(attributeValue);
                        }
                    }
                }
                //code
                xmlM.createConnector(name, origin, destination, orderT);
            }
        }
    }

    private void parseFeatures(NodeList features) {
        for (Element e : getElements(features)) {
            parseFeature(e.getChildNodes());
        }
    }

    private void parseFeature(NodeList feature) {
        String name = "";
        //String featureN = "";
        //boolean isSensor = false;
        //int orderT = 1;
        for (Element e : getElements(feature)) {
            String nodeName = e.getNodeName();
            if (nodeName.equals(FEATURE)) {
                if (e.hasAttributes()) {
                    NamedNodeMap nodeMap = e.getAttributes();
                    for (int i = 0; i < nodeMap.getLength(); i++) {
                        org.w3c.dom.Node node = nodeMap.item(i);
                        String attributeName = node.getNodeName();
                        String attributeValue = node.getNodeValue();
                        if (attributeName.equals(NAME)) {
                            name = attributeValue;
                        }
                    }
                }
                //code
                xmlM.createFeature(name);
            }
        }
    }

    private void parseComponets(NodeList comps) {
        for (Element e : getElements(comps)) {
            parseComp(e.getChildNodes());
        }
    }

    private void parseComp(NodeList comp) {
        String name = "";
        String feature = "";
        boolean isSensor = false;
        int orderT = 1;
        for (Element e : getElements(comp)) {
            String nodeName = e.getNodeName();
            if (nodeName.equals(COMPONENT)) {
                if (e.hasAttributes()) {
                    NamedNodeMap nodeMap = e.getAttributes();
                    for (int i = 0; i < nodeMap.getLength(); i++) {
                        org.w3c.dom.Node node = nodeMap.item(i);
                        String attributeName = node.getNodeName();
                        String attributeValue = node.getNodeValue();
                        if (attributeName.equals(NAME)) {
                            name = attributeValue;
                        } else if (attributeName.equals(FEATURE)) {
                            feature = attributeValue;
                        } else if (attributeName.equals(ISSENSOR)) {
                            isSensor = attributeValue.equals(TRUE);
                        } else if (attributeName.equals(ORDERT)) {
                            orderT = Integer.parseInt(attributeValue);
                        }
                    }
                    //code
                    if (!isSensor) {
                        xmlM.createComponent(name, feature, isSensor, orderT);
                    } else {
                        xmlM.createSensor(name, feature, isSensor, orderT);
                    }
                } else {
                    //nothing
                }

            }
        }
    }

    private ArrayList<Element> getElements(NodeList nodeList) {
        int length = nodeList.getLength();
        ArrayList<Element> elements = new ArrayList<Element>(length);
        for (int i = 0; i < length; i++) {
            org.w3c.dom.Node nNode = nodeList.item(i);
            if (nNode.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                elements.add(eElement);
            }
        }
        return elements;
    }
}
