package com.home.services;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FileService {

    @Autowired
    AmazonS3 s3Client;


    public String fileUpload(MultipartFile multipartFile) throws IOException {

        File fileToUpload = new File(multipartFile.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(fileToUpload);
        fos.write(multipartFile.getBytes());

        List<PartETag> partETags = new ArrayList<PartETag>();
        String bucketName = "gtk-" + System.currentTimeMillis();
        //Step1- create bucket
        s3Client.createBucket(bucketName);

        //Step-2 - initiate multipart upload
        InitiateMultipartUploadRequest initRequest = new InitiateMultipartUploadRequest(bucketName, multipartFile.getOriginalFilename());
        InitiateMultipartUploadResult initResponse = s3Client.initiateMultipartUpload(initRequest);

        //step-3 - upload part(s)
        int read ;
        int part = 1;
            UploadPartRequest uploadPartRequest = new UploadPartRequest();
            uploadPartRequest.setBucketName(bucketName);
            uploadPartRequest.setFile(fileToUpload);
            uploadPartRequest.setKey(multipartFile.getOriginalFilename());
            uploadPartRequest.setUploadId(initResponse.getUploadId());
            uploadPartRequest.setPartNumber(part++);
            partETags.add(s3Client.uploadPart(uploadPartRequest).getPartETag());

        //step-4 - completed multi part upload
        return s3Client.completeMultipartUpload(
                new CompleteMultipartUploadRequest()
                        .withUploadId(initResponse.getUploadId())
                        .withBucketName(bucketName)
                        .withPartETags(partETags)
                        .withKey(multipartFile.getOriginalFilename())
        ).getKey();
    }

    public List<String> getBuckets() {
        List<Bucket> buckets = s3Client.listBuckets();
        return buckets.stream().map(b -> b.getName()).collect(Collectors.toList());
    }

    public String deleteAll() {
        List<Bucket> buckets = s3Client.listBuckets();
        for (Bucket bucket : buckets) {
            ObjectListing objectListing = s3Client.listObjects(bucket.getName());
            Iterator<S3ObjectSummary> objects = objectListing.getObjectSummaries().iterator();
            while (objects.hasNext()) {
                S3ObjectSummary object = objects.next();
                s3Client.deleteObject(bucket.getName(), object.getKey());
                System.out.println("Object deleted -->" + object.getKey());
            }
            s3Client.deleteBucket(bucket.getName());
            System.out.println("Bucket deleted -->" + bucket.getName());
        }
        return !buckets.isEmpty() ? "All buckets and it's associated objects has been deleted.... :" : "No bucket exist to delete....";
    }
}
