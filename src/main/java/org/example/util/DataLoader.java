package org.example.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DataLoader {
    public List<String> getDataByColumn(int columnNumber) throws FileNotFoundException {

        FileInputStream fileInputStream = new FileInputStream(".\\airports.csv");
        BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));

        String splitCSV = ",";

        List<String> lines = new ArrayList<>();
        try {
            String str;
            while ((str = reader.readLine()) != null) {
                String[] airportData = str.replaceAll("\"", "").split(splitCSV);
                lines.add(airportData[columnNumber - 1]);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return lines;
    }
}
