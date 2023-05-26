package org.example;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Double.parseDouble;
import static java.lang.Float.parseFloat;

public class JSONRead {
    public static void main(String[] args) throws IOException {
        JSONArray name;
        List<Double> latitude = new ArrayList<Double>(  100);
        List <Double> longitude = new ArrayList<Double>(100);
        String path = "C:\\Users\\willc\\Downloads\\monuments(3).json" ;
        try {
            String content =  new String((Files.readAllBytes(Paths.get(path))));
            JSONObject object = new JSONObject(content);
            JSONArray listJSON = object.getJSONArray("elements");
            for (int index =0 ; index < listJSON.length() ; index ++){

                latitude.add(parseDouble(listJSON.getJSONObject(index).get("latitude").toString()));
                latitude.add(parseDouble(listJSON.getJSONObject(index).get("longitude").toString()));
                listJSON.getJSONObject(index).get("longitude");
                listJSON.getJSONObject(index).get("name");
            }

            System.out.println( latitude);
            // System.out.println(name.toString());
            //System.out.println(latitude.toString());

        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
