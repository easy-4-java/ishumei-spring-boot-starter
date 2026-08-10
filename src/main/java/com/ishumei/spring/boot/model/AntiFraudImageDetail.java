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

import java.util.List;

/**
 * Model class for AntiFraudImageDetail.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AntiFraudImageDetail {

	/**
	 * Human-readable explanation of the risk reason; for reference only, do not use in logic.
	 */
	@JsonProperty("description")
	private String description;

	@JsonProperty("descriptionV2")
	private String descriptionV2;

	/**
	 * OCR-recognised text, returned on demand.
	 */
	@JsonProperty("text")
	private String text;

	/**
	 * Porn label. Values: "porn", "sexy", "normal"; returned on demand.
	 */
	@JsonProperty("pornLabel")
	private String pornLabel;

	/**
	 * Probability of pornographic image; returned on demand.
	 */
	@JsonProperty("pornRate")
	private float pornRate;

	/**
	 * Probability of sexy image; returned on demand.
	 */
	@JsonProperty("sexyRate")
	private float sexyRate;

	/**
	 * Probability of normal image; returned on demand.
	 */
	@JsonProperty("normalRate")
	private float normalRate;

	/**
	 * Name of the most similar political figure; returned on demand.
	 */
	@JsonProperty("polityName")
	private String polityName;

	/**
	 * Probability of the most similar political figure; returned on demand.
	 */
	@JsonProperty("polityRate")
	private float polityRate;

	/**
	 * Violence label. Values: "riot", "flag", "uniform", "terrorist-org", "weapon", "blood", "game-weapon", "china-map", "tank", "candle", "uniform", "normal"; returned on demand.
	 */
	@JsonProperty("violenceLabel")
	private String violenceLabel;

	/**
	 * Probability of riot scene; returned on demand.
	 */
	@JsonProperty("rebelRate")
	private float rebelRate;

	/**
	 * Probability of national flag/emblem; returned on demand.
	 */
	@JsonProperty("flagRate")
	private float flagRate;

	/**
	 * Probability of military uniform; returned on demand.
	 */
	@JsonProperty("armyRate")
	private float armyRate;

	/**
	 * Probability of terrorist organisation; returned on demand.
	 */
	@JsonProperty("terrorismRate")
	private float terrorismRate;

	/**
	 * Probability of weapon (gun/knife); returned on demand.
	 */
	@JsonProperty("weaponRate")
	private float weaponRate;

	/**
	 * Probability of bloody scene; returned on demand.
	 */
	@JsonProperty("bloodRate")
	private float bloodRate;

	/**
	 * Probability of in-game weapon; returned on demand.
	 */
	@JsonProperty("gameWeaponRate")
	private float gameWeaponRate;

	/**
	 * Probability of China map; returned on demand.
	 */
	@JsonProperty("chinamapRate")
	private float chinamapRate;

	/**
	 * Probability of tank; returned on demand.
	 */
	@JsonProperty("tankRate")
	private float tankRate;

	/**
	 * Probability of candle; returned on demand.
	 */
	@JsonProperty("candleRate")
	private float candleRate;

	/**
	 * Probability of uniform; returned on demand.
	 */
	@JsonProperty("uniformRate")
	private float uniformRate;

	/**
	 * Probability of non-violent image; returned on demand.
	 */
	@JsonProperty("nonViolenceRate")
	private float nonViolenceRate;

	/**
	 * New strategy rule risk description (new API field; only new strategies return it during transition).
	 */
	@JsonProperty("hits")
	private List<AntiFraudImageDetailHits> hits;

	/**
	 * Strategy rule id identifying the matched rule. Legacy API field kept for compatibility; do not depend on it.
	 */
	@JsonProperty("model")
	private String model;

	/**
	 * Risk type. Values: normal=0, political=100, porn=200, sexy=210, ad=300, qrcode=310, watermark=320, violence=400, violation=500, bad-scene=510, blacklist=700, whitelist=710, high-risk-account=800, custom=900.
	 */
	@JsonProperty("riskType")
	private int riskType;

	@JsonProperty("original_text")
	private String originalText;

	@JsonProperty("sexy_risk_tokenid")
	private int sexyRiskTokenId;

	@JsonProperty("riskSource")
	private int riskSource;

}
