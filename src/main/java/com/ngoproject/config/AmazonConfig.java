package com.ngoproject.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmazonConfig {
	@Bean
	public AmazonS3 s3() {
		AWSCredentials awsCredentials = new BasicAWSCredentials("AKIAUF2CGJFLTA6O7JUE",
				"nfFN/3Mj3O6XMXOpQ8HXa6TEzSsAaV8Uun8nuE7S");
		return AmazonS3ClientBuilder.standard().withRegion("us-east-2")
				.withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).build();

	}
}