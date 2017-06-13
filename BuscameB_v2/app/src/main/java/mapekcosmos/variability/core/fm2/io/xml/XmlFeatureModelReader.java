package mapekcosmos.variability.core.fm2.io.xml;



import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import mapekcosmos.variability.core.fm2.*;
import mapekcosmos.variability.core.fm2.io.AbstractFeatureModelReader;
import mapekcosmos.variability.core.fm2.io.UnsupportedModelException;
import mapekcosmos.variability.core.prop4j.*;
import mapekcosmos.variability.prov.IManager;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;

public class XmlFeatureModelReader extends AbstractFeatureModelReader
    implements XmlFeatureModelTags {
    IManager manager;

    public XmlFeatureModelReader(IManager manager) {
        super();
        this.manager = manager;
        featureModel = new FeatureModel();
    }

    @Override protected void parseInputStream(InputStream inputStream)
        throws UnsupportedModelException {
        featureModel.reset();
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
        for (Element e : getElements(doc.getElementsByTagName(FEATURE_MODEL))) {
            parseStruct(e.getElementsByTagName(STRUCT));
            parseConstraints(e.getElementsByTagName(CONSTRAINTS));
        }
        featureModel.handleModelDataLoaded();
    }

    /**
     * @param nodeList
     * @return The child nodes from type Element of the given NodeList.
     */
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

    /**
     * Parse the struct section to add mapekcosmos.features to the model.
     */
    private void parseStruct(NodeList struct) throws UnsupportedModelException {
        for (Element e : getElements(struct)) {
            parseFeatures(e.getChildNodes(), null);
        }
    }

    private void parseFeatures(NodeList nodeList, IFeature parent)
        throws UnsupportedModelException {

        for (Element e : getElements(nodeList)) {
            String nodeName = e.getNodeName();
            /* read the description */
            if (nodeName.equals(DESCRIPTION)) {
                String nodeValue = e.getFirstChild().getNodeValue();
                if (nodeValue != null) {
                    nodeValue = nodeValue.replace("\t", "");
                    nodeValue = nodeValue.substring(1, nodeValue.length() - 1);
                    nodeValue = nodeValue.trim();
                }
                parent.setDescription(nodeValue);
                continue;//read the other child
            }
            //data of a feature
            boolean mandatory = false;
            boolean _abstract = false;
            boolean dynamic = false;
            boolean sensor = false;
            String name = "";
            FMPoint featureLocation = null;

            if (e.hasAttributes()) {
                NamedNodeMap nodeMap = e.getAttributes();
                for (int i = 0; i < nodeMap.getLength(); i++) {

                    org.w3c.dom.Node node = nodeMap.item(i);
                    String attributeName = node.getNodeName();
                    String attributeValue = node.getNodeValue();

                    if (attributeName.equals(ABSTRACT)) {
                        _abstract = attributeValue.equals(TRUE);
                    } else if (attributeName.equals(MANDATORY)) {
                        mandatory = attributeValue.equals(TRUE);
                    } else if (attributeName.equals(NAME)) {
                        name = attributeValue;
                    } else if (attributeName.equals(DYNAMIC)) {
                        dynamic = attributeValue.equals(TRUE);
                    } else if (attributeName.equals(SENSOR)) {
                        sensor = attributeValue.equals(TRUE);
                    } else if (attributeName.equals(COORDINATES)) {
                        String subStringX =
                            attributeValue.substring(0, attributeValue.indexOf(", "));
                        String subStringY =
                            attributeValue.substring(attributeValue.indexOf(", ") + 2);
                        try {
                            featureLocation = new FMPoint(Integer.parseInt(subStringX),
                                Integer.parseInt(subStringY));
                        } catch (NumberFormatException error) {
                            throwError(error.getMessage() + "is no valid Integer Value", e);
                        }
                    }

                }
            }
            if (featureModel.getFeature(name) != null) {
                throwError("Duplicate entry for feature: " + name, e);
            }

            IFeature f = new Feature(name);
            f.setMandatory(true);
            if (nodeName.equals(AND)) {
                f.setAnd();
            } else if (nodeName.equals(ALT)) {
                f.setAlternative();
            } else if (nodeName.equals(OR)) {
                f.setOr();
            }
            f.setAbstract(_abstract);
            f.setMandatory(mandatory);
            f.setSensor(sensor);
            f.setDynamic(dynamic);
            if (featureLocation != null) {
                f.setNewLocation(featureLocation);
            }

            featureModel.addFeature(f);
            if (parent == null) {
                featureModel.setRoot(f);
            } else {
                parent.addChild(f);
            }
            if (e.hasChildNodes()) {
                parseFeatures(e.getChildNodes(), f);//getChild return a nodeList
            }
        }
    }

    /**
     * Parses the constraint section.
     */
    private void parseConstraints(NodeList nodeList) throws UnsupportedModelException {
        for (Element e : getElements(nodeList)) {
            for (Element child : getElements(e.getChildNodes())) {
                String nodeName = child.getNodeName();
                if (nodeName.equals(RULE)) {
                    IConstraint c = new Constraint(featureModel,
                        parseConstraints2(child.getChildNodes()).getFirst());

                    if (child.hasAttributes()) {
                        NamedNodeMap nodeMap = child.getAttributes();
                        for (int i = 0; i < nodeMap.getLength(); i++) {
                            org.w3c.dom.Node node = nodeMap.item(i);
                            String attributeName = node.getNodeName();
                            String attributeValue = node.getNodeValue();
                            if (attributeName.equals(COORDINATES)) {
                                String subStringX =
                                    attributeValue.substring(0, attributeValue.indexOf(", "));
                                String subStringY =
                                    attributeValue.substring(attributeValue.indexOf(", ") + 2);
                                try {
                                    c.setLocation(new FMPoint(Integer.parseInt(subStringX),
                                        Integer.parseInt(subStringY)));
                                } catch (NumberFormatException error) {
                                    throwError(error.getMessage() + "is no valid Integer Value",
                                        child);
                                }
                            }
                        }
                    }
                    featureModel.addConstraint(c);
                }
            }
        }
    }

    private LinkedList<Node> parseConstraints2(NodeList nodeList) throws UnsupportedModelException {
        LinkedList<Node> nodes = new LinkedList<Node>();
        for (Element e : getElements(nodeList)) {
            String nodeName = e.getNodeName();
            if (nodeName.equals(DISJ)) {
                nodes.add(new Or(parseConstraints2(e.getChildNodes())));
            } else if (nodeName.equals(CONJ)) {
                nodes.add(new And(parseConstraints2(e.getChildNodes())));
            } else if (nodeName.equals(EQ)) {
                LinkedList<Node> children = parseConstraints2(e.getChildNodes());
                nodes.add(new Equals(children.get(0), children.get(1)));
            } else if (nodeName.equals(IMP)) {
                LinkedList<Node> children = parseConstraints2(e.getChildNodes());
                nodes.add(new Implies(children.get(0), children.get(1)));
            } else if (nodeName.equals(NOT)) {
                nodes.add(new Not((parseConstraints2(e.getChildNodes())).getFirst()));
            } else if (nodeName.equals(ATMOST1)) {
                nodes.add(new AtMost(1, parseConstraints2(e.getChildNodes())));
            } else if (nodeName.equals(VAR)) {
                String featureName = e.getTextContent();
                if (featureModel.getFeature(featureName) != null) {
                    nodes.add(new Literal(featureName));
                } else {
                    throwError("Feature \"" + featureName + "\" does not exists", e);
                }
            } else {
                throwError("Unknown constraint type: " + nodeName, e);
            }
        }
        return nodes;
    }

    private void throwError(String message, org.w3c.dom.Node node)
        throws UnsupportedModelException {
        throw new UnsupportedModelException(message, Integer
            .parseInt(node.getUserData(PositionalXMLReader.getLineNumberKeyName()).toString()));
    }
}
