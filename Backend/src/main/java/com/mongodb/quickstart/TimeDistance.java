package com.mongodb.quickstart;

public class TimeDistance {


    public static double calculateMaxDistance(long dateStart, long dateEnd) {
        //Function that will calculate the maximum distance we can parcour during the time (datestart and dateend) in parameters with the speed of 100 km/h
        
        long timeInML = dateEnd - dateStart;
        
        //Conversion ml in h
        double timeInH = timeInML / (1000.0 * 60 * 60);

        //Max distance with the speed of 100km/h
        double maxDistance = 100.0 * timeInH;

        return maxDistance;

    }



}
