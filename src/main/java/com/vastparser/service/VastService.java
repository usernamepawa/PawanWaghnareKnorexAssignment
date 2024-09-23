package com.vastparser.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vastparser.model.VastTag;
import com.vastparser.parser.VastXmlService;
import com.vastparser.parser.XmlParser;

public class VastService {
    private final VastXmlService vastXmlService;
    private final XmlParser xmlParser;
    private final ObjectMapper objectMapper;
    private final MongoDbService mongoDbService;

    public VastService() {
        this.vastXmlService = new VastXmlService();
        this.xmlParser = new XmlParser();
        this.objectMapper = new ObjectMapper();
        this.mongoDbService = new MongoDbService(); // Assuming MongoDB service is implemented to handle DB operations
    }

    // Parse VAST from file
    public void parseVastFromFile(String filePath) {
        String xmlContent = vastXmlService.readXmlFromFile(filePath);
        if (xmlContent != null) {
            VastTag vastTag = xmlParser.parseXml(xmlContent);
            handleParsedVast(vastTag);
        } else {
            System.out.println("Error reading XML from file.");
        }
    }

    // Parse VAST from URL
    public void parseVastFromUrl(String url) {
        String xmlContent = vastXmlService.readXmlFromUrl(url);
        if (xmlContent != null) {
            VastTag vastTag = xmlParser.parseXml(xmlContent);
            handleParsedVast(vastTag);
        } else {
            System.out.println("Error reading XML from URL.");
        }
    }

    // Handle parsed VAST data, convert to JSON, and save to MongoDB
    private void handleParsedVast(VastTag vastTag) {
        try {
            String jsonOutput = objectMapper.writeValueAsString(vastTag);
            System.out.println("Parsed JSON: " + jsonOutput);
            mongoDbService.saveVastTagToMongo(vastTag); // Save the parsed data in MongoDB
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error converting parsed VAST to JSON.");
        }
    }
}

