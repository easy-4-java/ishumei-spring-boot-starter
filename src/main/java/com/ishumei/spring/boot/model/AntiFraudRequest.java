package com.ishumei.spring.boot.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * Moderation request base.
 */
/**
 * Model class for AntiFraudRequest.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class AntiFraudRequest {

	/**
	 * Application id used to distinguish applications of the same company (agreed with Shumei). Defaults to {@code default}.
	 */
	@JsonProperty("appId")
	private String appId = "default";
	
	/**
	 * Company access key for authentication; provided by Shumei when the account is opened.
	 */
	@JsonProperty("accessKey")
	private String accessKey;

	/**
	 * Platform business type (uppercase): ZHIBO, ECOM, GAME, NEWS, FORUM, SOCIAL.
	 */
	@JsonProperty("type")
	private String type;

}
