package org.example.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataLoader {
    public List<String> getDataByColumn(int columnNumber) throws IOException {

        try (InputStream inputStream = getClass().getResourceAsStream("/airports.csv")) {
            assert inputStream != null;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
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
                return lines;// Use resource
            }
        }
    }
}
