package com.ngoproject.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BucketName {
	TODO_IMAGE("ngoevent");

	private final String bucketName;
}
