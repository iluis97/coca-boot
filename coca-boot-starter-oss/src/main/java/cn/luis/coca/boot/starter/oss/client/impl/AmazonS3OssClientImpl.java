package cn.luis.coca.boot.starter.oss.client.impl;

import cn.luis.coca.boot.core.enums.ContentTypeEnum;
import cn.luis.coca.boot.starter.oss.client.OssClient;
import cn.luis.coca.boot.starter.oss.domain.OssDownFile;
import cn.luis.coca.boot.starter.oss.domain.OssUploadFile;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.DeleteObjectsRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.util.IOUtils;
import lombok.RequiredArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author luis
 */
@RequiredArgsConstructor
public class AmazonS3OssClientImpl implements OssClient {

    private final AmazonS3 amazonS3;

    @Override
    public AmazonS3 getS3Client() {
        return amazonS3;
    }

    @Override
    public S3Object getObjectInfo(String bucketName, String fileKey) {
        return amazonS3.getObject(bucketName, fileKey);
    }

    @Override
    public PutObjectResult putObject(String bucketName, String fileKey, InputStream stream, long size, String contextType) {
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(size);
        objectMetadata.setContentType(contextType);
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, fileKey, stream, objectMetadata);
        putObjectRequest.getRequestClientOptions().setReadLimit(Long.valueOf(size).intValue() + 1);
        return amazonS3.putObject(putObjectRequest);
    }

    @Override
    public void createBucket(String bucketName) {
        if (!amazonS3.doesBucketExistV2(bucketName)) {
            amazonS3.createBucket((bucketName));
        }
    }

    @Override
    public void deleteBucket(String bucketName) {
        if (amazonS3.doesBucketExistV2(bucketName)) {
            amazonS3.deleteBucket((bucketName));
        }
    }

    @Override
    public String getObjectUrl(String bucketName, String fileKey) {
        URL url = amazonS3.getUrl(bucketName, fileKey);
        return url.toString();
    }

    @Override
    public String getObjectPreviewUrl(String bucketName, String fileKey, LocalDateTime expiration) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = expiration.atZone(zoneId);
        Date date = Date.from(zdt.toInstant());
        URL url = amazonS3.generatePresignedUrl(bucketName, fileKey, date);
        return url.toString();
    }

    @Override
    public void deleteObject(String bucketName, String fileKeys) {
        amazonS3.deleteObject(bucketName, fileKeys);
    }

    @Override
    public void deleteObjects(String bucketName, List<String> fileKeys) {
        DeleteObjectsRequest deleteObjectsRequest = (new DeleteObjectsRequest(bucketName)).withKeys(fileKeys.toArray(new String[0]));
        amazonS3.deleteObjects(deleteObjectsRequest);
    }

    @Override
    public OssUploadFile upload(String bucketName, String fileFolder, String fileName, InputStream stream) throws IOException {
        ObjectMetadata objectMetadata = new ObjectMetadata();
        // 指示响应内容的格式
        objectMetadata.setContentType(ContentTypeEnum.DESSERT.getType());
        objectMetadata.setContentLength(stream.available());
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, fileFolder.concat(fileName), stream, objectMetadata);
        putObjectRequest.getRequestClientOptions().setReadLimit(Long.valueOf(stream.available()).intValue() + 1);
        // 存储
        amazonS3.putObject(putObjectRequest);

        OssUploadFile ossUploadFile = new OssUploadFile();
        // 文件名非随机生成，默认0
        ossUploadFile.setId("0");
        ossUploadFile.setUrl(File.separator + fileFolder + fileName);
        ossUploadFile.setFileName(fileName);
        return ossUploadFile;
    }

    @Override
    public OssUploadFile upload(String bucketName, String fileFolder, String fileName, InputStream stream, ObjectMetadata objectMetadata) throws IOException {
        objectMetadata.setContentLength(stream.available());

        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, fileFolder.concat(fileName), stream, objectMetadata);
        putObjectRequest.getRequestClientOptions().setReadLimit(Long.valueOf(stream.available()).intValue() + 1);
        // 存储
        amazonS3.putObject(putObjectRequest);

        OssUploadFile ossUploadFile = new OssUploadFile();
        // 文件名非随机生成，默认0
        ossUploadFile.setId("0");
        ossUploadFile.setUrl(File.pathSeparator + fileFolder + fileName);
        ossUploadFile.setFileName(fileName);
        return ossUploadFile;
    }

    @Override
    public OssDownFile down(String bucketName, String fileKey) {
        S3Object s3Object = amazonS3.getObject(bucketName, fileKey);

        byte[] file;
        try {
            file = IOUtils.toByteArray(s3Object.getObjectContent());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Path path = Paths.get(fileKey);
        ObjectMetadata objectMetadata = s3Object.getObjectMetadata();
        OssDownFile.ObjectMetadata metadata = new OssDownFile.ObjectMetadata(objectMetadata.getRawMetadata(), objectMetadata.getVersionId());
        return new OssDownFile(path.getFileName().toString(), file, metadata);
    }
}
