package com.ishumei.spring.boot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;


/**
 * Model class for BatchAntiFraudImageItem.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class BatchAntiFraudImageItem {

	/**
	 * User-specified image id; returned in the callback when one is configured; special characters are not supported.
	 */
	@JsonProperty("btId")
	private String btId;

	/**
	 * Return code (see https://www.ishumei.com/help/documents.html?id=24000). Only present when code is 1100.
	 */
	@JsonProperty("code")
	private String code;

	/**
	 * Risk detail (present when no callback is configured and code is 1100).
	 */
	@JsonProperty("detail")
	private BatchAntiFraudImageDetail detail;

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
	 * Risk level: PASS (normal, allow), REVIEW (suspicious, manual review), REJECT (violating, block).
	 */
	@JsonProperty("riskLevel")
	private String riskLevel;
	
	/**
	 * Risk score in [0,1000]; higher means riskier.
	 */
	@JsonProperty("score")
	private int score;
	/**
	 * <p>Is pass.</p>
	 * @return the boolean
	 */

	public boolean isPass() {
		return code.equals("1100") && riskLevel.equals("PASS");
	}
	/**
	 * <p>Is review.</p>
	 * @return the boolean
	 */
	
	public boolean isReview() {
		return code.equals("1100") && riskLevel.equals("REVIEW");
	}
	/**
	 * <p>Is reject.</p>
	 * @return the boolean
	 */
	
	public boolean isReject() {
		return code.equals("1100") && riskLevel.equals("REJECT");
	}
	
}
