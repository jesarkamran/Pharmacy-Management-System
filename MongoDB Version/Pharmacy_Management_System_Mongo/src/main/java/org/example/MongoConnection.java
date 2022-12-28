package org.example;

public class MongoConnection {

    MongoConnection(){
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("mydatabase");
    }
}
