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

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Model class for AntiFraudImageRequestData.
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AntiFraudImageRequestData extends AntiFraudRequestData {

	/**
	 * Image to check: a Base64-encoded string or a URL. Supports jpg, jpeg, jp2, png, webp, gif, bmp, tiff, tif, dib, ppm, pgm, pbm, hdr, pic. Recommended at least 256x256 pixels.
	 */
	@JsonProperty("img")
	private String img;
	
	/**
	 * Image array to check (length <= 100): Base64-encoded strings or URLs. Supports jpg, jpeg, jp2, png, webp, gif, bmp, tiff, tif, dib, ppm, pgm, pbm, hdr, pic. Recommended at least 256x256 pixels.
	 */
	@JsonProperty("imgs")
	private List<AntiFraudImageRequestItem> imgs;

	/**
	 * User-specified image id; returned in the callback when one is configured; special characters are not supported.
	 */
	@JsonProperty("btId")
	private String btId;

	/**
	 * User gender. female=0, male=1.
	 */
	@JsonProperty("sex")
	private int sex;

	/**
	 * User age group. youth(~18-45)=0, middle(45-60)=1, senior(60+)=2.
	 */
	@JsonProperty("age")
	private int age = 0;

	/**
	 * Android device id (IMEI). Harder to change than tokenId/IP, so it helps correlate malicious behaviour across accounts/IPs and can be matched against Shumei's device blacklist.
	 */
	@JsonProperty("imei")
	private String imei;

	/**
	 */
	@JsonProperty("mac")
	private String mac;

	/**
	 * iOS application id (IDFV). Cannot be modified, so it helps detect malicious behaviour across accounts/IPs.
	 */
	@JsonProperty("idfv")
	private String idfv;

	/**
	 */
	@JsonProperty("idfa")
	private String idfa;

	/**
	 * Maximum frame count for GIF checks (default 20). When interval*maxFrame < frame count the interval is auto-adjusted to frame-count/maxFrame.
	 */
	@JsonProperty("maxFrame")
	private int maxFrame = 20;

	/**
	 * Frame sampling interval for GIF checks (default 1): one frame is sampled every {@code interval} frames.
	 */
	@JsonProperty("interval")
	private int interval = 1;

}
