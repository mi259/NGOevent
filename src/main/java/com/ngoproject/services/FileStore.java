package com.ngoproject.services;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@Service
public class FileStore {
    private final AmazonS3 amazonS3;

    public void upload(String path,
                       String fileName,
                       Optional<Map<String, String>> optionalMetaData,
                       InputStream inputStream){
        ObjectMetadata objectMetadata = new ObjectMetadata();

        // loops through the optionalMetaData map adding all of the
        // file information to the S3 objectMetaData
        optionalMetaData.ifPresent(map -> {
            if (!map.isEmpty()){
                map.forEach(objectMetadata:: addUserMetadata);
            }
        });

        try{
            amazonS3.putObject(path, fileName, inputStream, objectMetadata); // saves file to s3

        } catch (AmazonServiceException e){
            throw new IllegalStateException("Failed to upload the file to s3", e);
        }
    }

}
