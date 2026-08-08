package com.ishumei.spring.boot;

import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.OkHttpClient;

/**
 * Core template for invoking the Shumei (数美) anti-fraud APIs.
 * <p>Exposes grouped operation helpers for text, image and video moderation.</p>
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 1.0.0
 */
public class ShumeiAntiFraudTemplate {

	/** JSON mapper used to serialise requests. */
	private ObjectMapper objectMapper;
	/** OkHttp client used to send requests. */
	private OkHttpClient okhttp3Client;
	private final ShumeiAntiFraudTextOperations antiTextOps = new ShumeiAntiFraudTextOperations(this);
	private final ShumeiAntiFraudImageOperations antiImageOps = new ShumeiAntiFraudImageOperations(this);
	private final ShumeiAntiFraudVideoOperations antiVideoOps = new ShumeiAntiFraudVideoOperations(this);
	private final ShumeiAntiFraudProperties properties;

	/**
	 * Creates a template bound to the given properties, mapper and HTTP client.
	 * @param properties the Shumei anti-fraud properties
	 * @param objectMapper the JSON mapper
	 * @param okhttp3Client the OkHttp client
	 */
	public ShumeiAntiFraudTemplate(ShumeiAntiFraudProperties properties, ObjectMapper objectMapper, OkHttpClient okhttp3Client) {
		this.objectMapper = objectMapper;
		this.okhttp3Client = okhttp3Client;
		this.properties = properties;
	}

	/** @return the text-moderation operation helper */
	public ShumeiAntiFraudTextOperations opsForText() {
		return antiTextOps;
	}

	/** @return the image-moderation operation helper */
	public ShumeiAntiFraudImageOperations opsForImage() {
		return antiImageOps;
	}

    /** @return the video-moderation operation helper */
    public ShumeiAntiFraudVideoOperations opsForVideo() {
		return antiVideoOps;
	}

	/** @return the JSON mapper used to serialise requests */
	public ObjectMapper getObjectMapper() {
		return objectMapper;
	}

	/** @return the Shumei anti-fraud properties */
	public ShumeiAntiFraudProperties getProperties() {
		return properties;
	}

	/** @return the OkHttp client used to send requests */
	public OkHttpClient getOkhttp3Client() {
		return okhttp3Client;
	}

}
