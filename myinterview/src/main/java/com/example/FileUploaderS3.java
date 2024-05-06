package com.example;

import java.io.File;
import com.config.Config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;

public class FileUploaderS3 {
     public static void uploadFileToS3(String filePath) {
        //Define AWS crentials
        String accessKey = (Config.ACCESS_KEY_ID);
        String secretKey = (Config.SECRET_ACCESS_KEY);
        String region = "us-west-2";
        String bucketName = "interview-digiage";

        BasicAWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
        
        //Connect to s3 bucket
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(
                    "https://s3." + region + ".amazonaws.com", region))
                .build();

        try {
            
            //Define file name and send it to s3 bucket
            String fileName = "gender_counts.json";
            File file = new File("gender_counts.json"); 

            s3Client.putObject(new PutObjectRequest(bucketName, fileName, file));
            System.out.println("File uploaded to S3 bucket: " + bucketName);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
