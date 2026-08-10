package com.ishumei.spring.boot.model;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * Moderation response result.
 */
/**
 * Model class for BatchAntiFraudImageResponse.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class BatchAntiFraudImageResponse {

	/**
	 * Return code (see https://www.ishumei.com/help/documents.html?id=24000). Only present when code is 1100.
	 */
	@JsonProperty("code")
	private String code;

	/**
	 * Return code description.
	 */
	@JsonProperty("message")
	private String message;

	/**
	 * Unique request id, usable for later data queries.
	 */
	@JsonProperty("requestId")
	private String requestId;

	/**
	 * Per-image recognition results (present when code is 1100).
	 */
	@JsonProperty("imgs")
	private List<BatchAntiFraudImageItem> imgs;

	/**
	 * Integer array of length 4: reject count, review count, pass count (when code is 1100) and error count.
	 */
	@JsonProperty("statistics")
	private List<Integer> statistics;

	public boolean isSuccess() {
		return Objects.nonNull(code) && code.equals("1100");
	}

}
