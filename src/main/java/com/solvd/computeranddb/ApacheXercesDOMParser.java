/*
 * %W% %E% Pavel Shyrkavets
 *
 * Copyright (c) 2011-2025 Solvd, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Solvd,
 * Inc. ("Confidential Information.") You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Solvd.
 *
 * SOLVD MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF
 * THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE, OR NON-INFRINGEMENT. SOLVD SHALL NOT BE LIABLE FOR ANY DAMAGES
 * SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR DISTRIBUTING
 * THIS SOFTWARE OR ITS DERIVATIVES.
 */
package com.solvd.computeranddb;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApacheXercesDOMParser {
    private final static Logger LOGGER = LogManager.getLogger(ApacheXercesDOMParser.class);

    public static void main(String[] args) {
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(new File("src/main/resources/computers.xml"));
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("computer");
            Node firstNode = nodeList.item(0);
            NamedNodeMap firstNodeAttributeList = firstNode.getAttributes();
            NodeList firstNodeChildrenList = firstNode.getChildNodes();
            Element firstElement = (Element) nodeList.item(0);
            int n = firstNodeChildrenList.getLength();

            for (int i = 0; i < n; i++) {
                Node current = firstNodeChildrenList.item(i);

                if(current.getNodeType() == Node.ELEMENT_NODE) {
                    LOGGER.info("{}: {}", current.getNodeName(), current.getTextContent());
                }
            }

            assertEquals(1, nodeList.getLength());
            assertEquals(Node.ELEMENT_NODE, firstNode.getNodeType());
            assertEquals("computer", firstNode.getNodeName());
            assertEquals(1, firstNodeAttributeList.getLength());
            assertEquals("id", firstNodeAttributeList.item(0).getNodeName());
            assertEquals("1", firstNodeAttributeList.item(0).getNodeValue());
            assertEquals("1", firstElement.getAttribute("id"));
        } catch (ParserConfigurationException e) {
            LOGGER.error("ParserConfigurationException is caught.");
        } catch (IOException e) {
            LOGGER.error("IOException is caught.");
        } catch (SAXException e) {
            LOGGER.error("SAXException is caught.");
        }
    }
}
