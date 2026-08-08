/*
 * Copyright (c) 2018, hiwepy (https://github.com/easy-4-java).
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.ishumei.spring.boot.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * Model class for AntiFraudRequestData.
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 1.0.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class AntiFraudRequestData {

	/**
	 * Unique client user id used for behaviour analysis (pass the user UID). Different users must use different tokenIds.
	 */
	@JsonProperty("tokenId")
	private String tokenId;

	/**
	 * Data scenario; the value must be agreed with Shumei.
	 */
	@JsonProperty("channel")
	private String channel;

	/**
	 * Client IP used for IP-based behaviour analysis.
	 */
	@JsonProperty("ip")
	private String ip;

	/**
	 * User phone number; can be matched against Shumei's phone blacklist.
	 */
	@JsonProperty("phone")
	private String phone;

	/**
	 * Shumei device fingerprint (strongly recommended). Detects malicious users that spoof mac/imei and can be matched against the device-fingerprint blacklist.
	 */
	@JsonProperty("deviceId")
	private String deviceId;

	/**
	 * Client IP used for IP-based behaviour analysis.
	 */
	@JsonProperty("receiveTokenId")
	private String receiveTokenId;

	/**
	 *User level; different interception strategies can be configured per level.
	 */
	@JsonProperty("level")
	private String level;

	/**
	 * Account registration time. Strongly recommended; newly registered accounts carry higher risk.
	 */
	@JsonProperty("registerTime")
	private String registerTime;

	/**
	 * Number of friends. Strongly recommended for social scenarios to indicate user quality.
	 */
	@JsonProperty("friendNum")
	private String friendNum;

	/**
	 * Number of fans. Strongly recommended for live/community scenarios to indicate user quality.
	 */
	@JsonProperty("fansNum")
	private String fansNum;

	/**
	 * User role; different strategies can be configured per role. Live: ADMIN (room admin), HOST (streamer), SYSTEM. Game: ADMIN, USER (default).
	 */
	@JsonProperty("role")
	private String role = "USER";

	/**
	 * Discussion topic id, e.g. a book-review section or forum post id.
	 */
	@JsonProperty("topic")
	private String topic;

	/**
	 * Whether the user is a premium (e.g. paid) user. premium=1, default=0.
	 */
	@JsonProperty("isPremiumUser")
	private int isPremiumUser = 0;
	
}
