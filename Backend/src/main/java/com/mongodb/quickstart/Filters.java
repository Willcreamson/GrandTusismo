package com.mongodb.quickstart;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.mongodb.client.model.Filters.and;

public class Filters {

    public static String districtName = "";
    public static String regionName = "";
    public static int travelTime = 0;

    public static void setMonumentByRegion(MongoCollection<Document> collection , String RegionName) {


        ArrayList<JSONObject> monumentsFilteredByRegion = new ArrayList<>();

        try (MongoCursor<Document> cursor = collection.find(com.mongodb.client.model.Filters.eq("Commune", RegionName)).iterator()) {
            while (cursor.hasNext()) {
                monumentsFilteredByRegion.add(new JSONObject(cursor.next().toJson()));
            }
            Connection.monuments = monumentsFilteredByRegion;
        }
        catch (Exception e){
            System.err.println("Null pointer Exception or "+ e);
        }


    }

    public static void setMonumentBydistrict(MongoCollection<Document> collection ,String districtName) {

        ArrayList<JSONObject> monumentsFilteredByDistrict = new ArrayList<>();

        try (MongoCursor<Document> cursor = collection.find(com.mongodb.client.model.Filters.eq("Commune", districtName)).iterator()) {
            while (cursor.hasNext()) {
                monumentsFilteredByDistrict.add(new JSONObject(cursor.next().toJson()));
            }
            Connection.monuments = monumentsFilteredByDistrict ;
        }
        catch (Exception e){
            System.err.println(e);
        }
    }

    public static void setMonumentByCenturySup(MongoCollection<Document> collection ,int century) {

        String SIECLE = "e siecle";
        ArrayList<JSONObject> monumentsFilteredByCentury = new ArrayList<>();

        try (MongoCursor<Document> cursor = collection.find(com.mongodb.client.model.Filters.gte("Siecle", century + SIECLE)).iterator()) {
            while (cursor.hasNext()) {
                monumentsFilteredByCentury.add(new JSONObject(cursor.next().toJson()));
            }
            Connection.monuments = monumentsFilteredByCentury ;
        }
        catch (Exception e){
            System.err.println(e);
        }

    }
    public static void setMonumentByCenturyEq(MongoCollection<Document> collection ,int century) {

        String SIECLE = "e siecle";
        ArrayList<JSONObject> monumentsFilteredByCentury = new ArrayList<>();

        try (MongoCursor<Document> cursor = collection.find(com.mongodb.client.model.Filters.eq("Siecle", century + SIECLE)).iterator()) {
            while (cursor.hasNext()) {
                monumentsFilteredByCentury.add(new JSONObject(cursor.next().toJson()));
            }
            Connection.monuments = monumentsFilteredByCentury ;
        }
        catch (Exception e){
            System.err.println(e);
        }
    }

    public static void setMonumentByDistrictAndCentury(MongoCollection<Document> collection ,String districtName ,int century) {

        String SIECLE = "e siecle";
        ArrayList<JSONObject> monumentsFilteredByCentury = new ArrayList<>();

        try (MongoCursor<Document> cursor = collection.find(
                and(
                        com.mongodb.client.model.Filters.eq("Region", districtName),
                        com.mongodb.client.model.Filters.eq("Siecle", century + SIECLE)
                )
                ).iterator()){
            while (cursor.hasNext())
            {
                monumentsFilteredByCentury.add(new JSONObject(cursor.next().toJson()));
            }
            Connection.monuments = monumentsFilteredByCentury ;
        }
        catch (Exception e){
            System.err.println(e);
        }
    }

    public static void setMonumentByRegionAndCentury(MongoCollection<Document> collection ,String regionName ,int century) {

        String SIECLE = "e siecle";
        ArrayList<JSONObject> monumentsFilteredByCentury = new ArrayList<>();

        try (MongoCursor<Document> cursor = collection.find(
                and(
                        com.mongodb.client.model.Filters.eq("Region", regionName),
                        com.mongodb.client.model.Filters.eq("Siecle", century + SIECLE)
                )
        ).iterator()){
            while (cursor.hasNext())
            {
                monumentsFilteredByCentury.add(new JSONObject(cursor.next().toJson()));
            }
            Connection.monuments = monumentsFilteredByCentury ;
        }
        catch (Exception e){
            System.err.println(e);
        }
    }

}
