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
 * Model class for AntiFraudImageRequestItem.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AntiFraudImageRequestItem {

	/**
	 * Image to check: a Base64-encoded string or a URL. Supports jpg, jpeg, jp2, png, webp, gif, bmp, tiff, tif, dib, ppm, pgm, pbm, hdr, pic. Recommended at least 256x256 pixels.
	 */
	@JsonProperty("img")
	private String img;
	
	/**
	 * Unique client user id used for behaviour analysis (pass the user UID). Different users must use different tokenIds.
	 */
	@JsonProperty("tokenId")
	private String tokenId;

	/**
	 * User-specified image id; returned in the callback when one is configured; special characters are not supported.
	 */
	@JsonProperty("btId")
	private String btId;
	
}
