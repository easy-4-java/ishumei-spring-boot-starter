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
import lombok.EqualsAndHashCode;

/**
 * Model class for BatchAntiFraudImageDetailHits.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BatchAntiFraudImageDetailHits {

	/**
	 * Human-readable explanation of the risk reason; for reference only, do not use in logic.
	 */
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("descriptionV2")
	private String descriptionV2;
	
	/**
	 * Strategy rule id identifying the matched rule. Legacy API field kept for compatibility; do not depend on it.
	 */
	@JsonProperty("model")
	private String model;

	/**
	 * Risk level: PASS (normal, allow), REVIEW (suspicious, manual review), REJECT (violating, block).
	 */
	@JsonProperty("riskLevel")
	private String riskLevel;

	/**
	 * Risk type. Values: normal=0, political=100, porn=200, sexy=210, ad=300, qrcode=310, watermark=320, violence=400, violation=500, bad-scene=510, blacklist=700, whitelist=710, high-risk-account=800, custom=900.
	 */
	@JsonProperty("riskType")
	private int riskType;
	
	/**
	 * Risk score in [0,1000]; higher means riskier.
	 */
	@JsonProperty("score")
	private int score;

}
