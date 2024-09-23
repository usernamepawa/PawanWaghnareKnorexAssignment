package com.vastparser.service;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.vastparser.model.VastTag;

public class MongoDbService {
    private MongoDatabase database;

    // Constructor to initialize the MongoDB client and select the database
    public MongoDbService() {
        // Use MongoClients.create() to create a connection to MongoDB
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017"); // Update with your MongoDB URI
        this.database = mongoClient.getDatabase("vastparser"); // Use the 'vastparser' database
    }

    // Save parsed VastTag to MongoDB
    public void saveVastTagToMongo(VastTag vastTag) {
        try {
            MongoCollection<Document> collection = database.getCollection("vast_tags"); // Save to 'vast_tags' collection
            Document doc = new Document("version", vastTag.getVersion())
                                .append("id", vastTag.getId())
                                .append("title", vastTag.getTitle())
                                .append("description", vastTag.getDescription())
                                .append("impression", new Document("id", vastTag.getImpression().getId())
                                                     .append("url", vastTag.getImpression().getUrl()));
            collection.insertOne(doc);
            System.out.println("VAST tag saved successfully to MongoDB.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error saving VAST tag to MongoDB.");
        }
    }
}

