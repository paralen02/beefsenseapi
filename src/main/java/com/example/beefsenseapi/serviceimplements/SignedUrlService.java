package com.example.beefsenseapi.serviceimplements;

import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.HttpMethod;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.auth.oauth2.ServiceAccountCredentials;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class SignedUrlService {

    public String generateV4PutObjectSignedUrl(String fileName) throws IOException {
        String projectId = "beefsenseapp";
        String bucketName = "beefsensedatasetv1";
        String keyFilePath = "/app/src/main/resources/beefsenseapp-f1d007644db8.json"; // Update this path

        // Load credentials from the service account key file
        ServiceAccountCredentials credentials = ServiceAccountCredentials.fromStream(new FileInputStream(keyFilePath));

        Storage storage = StorageOptions.newBuilder()
                .setProjectId(projectId)
                .setCredentials(credentials)
                .build()
                .getService();

        BlobInfo blobInfo = BlobInfo.newBuilder(BlobId.of(bucketName, fileName)).build();

        Map<String, String> extensionHeaders = new HashMap<>();
        extensionHeaders.put("Content-Type", "application/octet-stream");

        URL url = storage.signUrl(
                blobInfo,
                15,
                TimeUnit.MINUTES,
                Storage.SignUrlOption.httpMethod(HttpMethod.PUT),
                Storage.SignUrlOption.withExtHeaders(extensionHeaders),
                Storage.SignUrlOption.withV4Signature()
        );

        return url.toString();
    }
}