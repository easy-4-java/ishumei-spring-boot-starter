package com.ishumei.spring.boot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


/**
 * Model class for AntiFraudVideoResponse.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class AntiFraudVideoResponse {

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


}
