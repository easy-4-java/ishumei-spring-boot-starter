package com.ishumei.spring.boot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Objects;

/**
 * Moderation response result.
 */
/**
 * Model class for AntiFraudImageResponse.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class AntiFraudImageResponse {

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
	 * Risk score in [0,1000]; higher means riskier.
	 */
	@JsonProperty("score")
	private int score;

	/**
	 * Risk level: PASS (normal, allow), REVIEW (suspicious, manual review), REJECT (violating, block).
	 */
	@JsonProperty("riskLevel")
	private String riskLevel;

	/**
	 * Service timeout indicator. normal=0, timeout=501.
	 */
	@JsonProperty("status")
	private int status;

	@JsonProperty("taskId")
	private String taskId;

	/**
	 * Risk detail (JSON object).
	 */
	@JsonProperty("detail")
	private AntiFraudImageDetail detail;

	public boolean isSuccess() {
		return status == 0 && Objects.nonNull(code) && code.equals("1100");
	}

	public boolean isPass() {
		return isSuccess() && riskLevel.equals("PASS");
	}

	public boolean isReview() {
		return isSuccess() && riskLevel.equals("REVIEW");
	}

	public boolean isReject() {
		return isSuccess() && riskLevel.equals("REJECT");
	}

}
