package com.ngoproject.services;

import com.ngoproject.config.BucketName;
import com.ngoproject.model.Event;
import com.ngoproject.model.Image;
import com.ngoproject.repository.EventRepository;
import com.ngoproject.repository.ImageRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

import static org.apache.http.entity.ContentType.*;
import static org.apache.http.entity.ContentType.IMAGE_JPEG;

@AllArgsConstructor
@Service
public class ImageService {

    private final FileStore fileStore;

    @Autowired
    private final EventRepository eventRepo;

    @Autowired
    private final ImageRepository imageRepo;

   

    public void uploadImage(int id, MultipartFile file){
        // check if file is empty;
        if (file.isEmpty()) {
            throw new IllegalStateException("Cannot upload empty file");
        }

        //Check if the file is an image
        if (!Arrays.asList(IMAGE_PNG.getMimeType(),
                IMAGE_BMP.getMimeType(),
                IMAGE_GIF.getMimeType(),
                IMAGE_JPEG.getMimeType()).contains(file.getContentType())) {
            throw new IllegalStateException("FIle uploaded is not an image");
        }

        //get file metadata
        Map<String, String> metadata = new HashMap<>();
        metadata.put("Content-Type", file.getContentType());
        metadata.put("Content-Length", String.valueOf(file.getSize()));

        // Save image in s3 and then save todo in the database
        String path = String.format("%s/%s", BucketName.TODO_IMAGE.getBucketName(), UUID.randomUUID());
        String fileName = String.format("%s", file.getOriginalFilename());

        try {
            fileStore.upload(path, fileName, Optional.of(metadata), file.getInputStream());
        } catch (IOException e){
            throw new IllegalStateException("Failed to upload file to S3", e);
        }

        Event event = eventRepo.findById(id).get();
      

        Image image = Image.builder()
                .imagePath(path)
                .imageFileName(fileName)
                .event(event)
                .build();

        imageRepo.save(image);

    }


	



}
