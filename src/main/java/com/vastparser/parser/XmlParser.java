package com.vastparser.parser;

import com.vastparser.model.VastTag;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.*;
import org.xml.sax.InputSource;
import java.io.StringReader;

public class XmlParser {
    
    public VastTag parseXml(String xmlContent) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(xmlContent)));
            document.getDocumentElement().normalize();

            VastTag vastTag = new VastTag();
            vastTag.setVersion(document.getDocumentElement().getAttribute("version"));

            NodeList nodes = document.getElementsByTagName("Ad");
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    // Fill the model object with the parsed data
                    vastTag.setId(element.getAttribute("id"));
                    // Parse more fields and fill in vastTag
                }
            }
            return vastTag;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

