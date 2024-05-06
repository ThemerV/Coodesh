package com.example;

import com.config.Config;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;


/**
 * Create an implementation of a Rest API client.
 * Prints out how many records exists for each gender and save this file to s3 bucket
 * API endpoint=> https://3ospphrepc.execute-api.us-west-2.amazonaws.com/prod/RDSLambda 
 * AWS s3 bucket => interview-digiage
 *
 */

public class TASK4 {
    public static void main(String[] args) {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(Config.API_URL))
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();

            // Parse JSON response
            JsonElement jsonElement = JsonParser.parseString(responseBody);
            JsonArray jsonArray = jsonElement.getAsJsonArray();

            // Count occurrences of each gender
            Map<String, Integer> genderCounts = new HashMap<String, Integer>();
            for (JsonElement element : jsonArray) {
                String gender = element.getAsJsonObject().get("gender").getAsString();
                genderCounts.put(gender, genderCounts.getOrDefault(gender, 0) + 1);
            }
            
            // Convert gender counts to JSON
            JsonObject jsonCounts = new JsonObject();
            for (Map.Entry<String, Integer> entry : genderCounts.entrySet()) {
                jsonCounts.addProperty(entry.getKey(), entry.getValue());
            }

            // Write JSON to file
            FileWriter fileWriter = null;
            try {
                fileWriter = new FileWriter("gender_counts.json");
                Gson gson = new Gson();
                gson.toJson(jsonCounts, fileWriter);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fileWriter != null) {
                    try {
                        fileWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            System.out.println("Gender counts saved to gender_counts.json");

            // Upload file to S3 bucket
            FileUploaderS3.uploadFileToS3("gender_counts.json");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
