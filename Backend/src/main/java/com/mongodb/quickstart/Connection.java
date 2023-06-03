package com.mongodb.quickstart;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.mongodb.quickstart.Filters.setMonumentByRegionAndCentury;
import static com.mongodb.quickstart.Filters.setMonumentBydistrict;

public class Connection {
    public static final String connectionString = "mongodb+srv://William:123@cluster0.1m46zow.mongodb.net/";
    public static ArrayList<JSONObject> monuments = new ArrayList<>();

    // Getters, monuments

    public static ArrayList<JSONObject> getMonuments() {
        return monuments;
    }

    public static void main(String[] args) {

        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoCollection<Document> collection = mongoClient.getDatabase("sample-monuments").getCollection("monument");

            /*List<Document> databases = mongoClient.listDatabases().into(new ArrayList<>());
            databases.forEach(db -> System.out.println(db.toJson()));
            */

            // The Filters
            //setMonumentBydistrict(collection,"Saint-Jean-d'Angle");
            setMonumentByRegionAndCentury(collection,"Nouvelle-Aquitaine", 16);

            System.out.println(getMonuments());

            //Document doc = collection.find(Filters.eq("Commune","Saint-Jean-d'Angle")).first();
            //MongoCursor<Document> cursor = collection.find(Filters.eq("Commune","Saint-Jean-d'Angle")).iterator();
            mongoClient.close();
        }
    }


}


