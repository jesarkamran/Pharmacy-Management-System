package org.example;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoConnection {

    MongoConnection(){
        try (MongoClient mongoClient = new MongoClient("localhost", 27017)) {
            MongoDatabase database = mongoClient.getDatabase("Pharmacy_Management_System");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
