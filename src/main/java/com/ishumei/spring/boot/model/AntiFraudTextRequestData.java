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
 * Model class for AntiFraudTextRequestData.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AntiFraudTextRequestData extends AntiFraudRequestData{

	/**
	 * Text content to check; up to 20000 characters.
	 */
	@JsonProperty("text")
	private String text;

	/**
	 * User gender. female=0, male=1.
	 */
	@JsonProperty("gender")
	private int gender;
	
	/**
	 * User nickname. Strongly recommended; malicious users often spread spam/political/trafficking info via nicknames.
	 */
	@JsonProperty("nickname")
	private String nickname;

	/**
	 * Live/game room id; different strategies can be configured per room.
	 */
	@JsonProperty("room")
	private String room;

	/**
	 * Whether to distinguish accounts across applications. 0=no (default), 1=yes. When 1 each application keeps independent account strategies/features.
	 */
	@JsonProperty("isTokenSeperate")
	private int isTokenSeperate = 0;

}
