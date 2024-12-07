package WordCloudGenerator.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.nio.file.Paths;

@Service
public class S3Service {

    @Value("${aws.s3.bucket-name}")
    private String bucketName;

    @Value("${aws.s3.access-key}")
    private String accessKey;

    @Value("${aws.s3.secret-key}")
    private String secretKey;

    @Value("${aws.s3.region}")
    private String region;

    public void uploadFileToS3(String fileName) {
//S3Client is part of the AWS SDK for Java.
// It is the main class that allows you to interact with Amazon S3 (Simple Storage Service) from your Java code.
//Example Methods in S3Client:
//
//    putObject(): Uploads a file to an S3 bucket.
//    getObject(): Downloads a file from an S3 bucket.
//    createBucket(): Creates a new S3 bucket.
//    deleteObject(): Deletes a file from an S3 bucket.
        S3Client s3Client = S3Client.builder()
                .region(Region.of(region))
                .credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create(accessKey, secretKey)))
                .build();



//PutObjectRequest is another class from the AWS SDK for Java.
// It represents the request that you make when you want to upload an object (a file) to S3.
        PutObjectRequest request = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(fileName)
                .build();

        s3Client.putObject(request, Paths.get(fileName));
    }
}
