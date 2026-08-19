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
package com.ishumei.spring.boot;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Configuration properties for the Shumei (数美) anti-fraud/content-moderation service.
 * <p>See <a href="https://www.ishumei.com/">https://www.ishumei.com/</a>.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
@ConfigurationProperties(ShumeiAntiFraudProperties.PREFIX)
public class ShumeiAntiFraudProperties {

	/** Configuration prefix. */
	public static final String PREFIX = "shumei.anti-fraud";

	/**
	 * Application id used to distinguish different applications of the same company. Agreed with
	 * Shumei; defaults to {@code default}.
	 */
	private String appId;
	/**
	 * Company access key used for authentication; provided by Shumei when the account is opened.
	 */
	private String accessKey;
	/**
	 * Platform business type (must be uppercase):
	 * live={@code ZHIBO}, e-commerce={@code ECOM}, game={@code GAME},
	 * news={@code NEWS}, forum={@code FORUM}, social={@code SOCIAL}.
	 */
	private String type;
	/** Channel value used for text moderation. */
	private String channelTxt;
	/** Channel value used for image moderation. */
	private String channelImg;
	/** Channel value used for audio moderation. */
	private String channelAudio;
	/** Channel value used for video moderation. */
	private String channelVideo;
	/**
	 * Text moderation endpoint.
	 * Defaults to {@code http://api-text-bj.fengkongcloud.com/v2/saas/anti_fraud/text}.
	 */
	private String antiFraudTxtUrl = "http://api-text-bj.fengkongcloud.com/v2/saas/anti_fraud/text";
	/**
	 * Image moderation endpoint.
	 * Defaults to {@code http://api-img-bj.fengkongcloud.com/v2/saas/anti_fraud/img}.
	 */
	private String antiFraudImgUrl = "http://api-img-bj.fengkongcloud.com/v2/saas/anti_fraud/img";
	/**
	 * Batch image moderation endpoint.
	 * Defaults to {@code http://api-img-bj.fengkongcloud.com/v2/saas/anti_fraud/imgs}.
	 */
	private String antiFraudImgsUrl = "http://api-img-bj.fengkongcloud.com/v2/saas/anti_fraud/imgs";
	/**
	 * Audio moderation endpoint.
	 * Defaults to {@code http://api-audio-bj.fengkongcloud.com/v2/saas/anti_fraud/audio}.
	 */
	private String antiFraudAudioUrl = "http://api-audio-bj.fengkongcloud.com/v2/saas/anti_fraud/audio";
	/**
	 * Audio-stream moderation endpoint.
	 * Defaults to {@code http://api-audiostream-bj.fengkongcloud.com/v2/saas/anti_fraud/audiostream}.
	 */
	private String antiFraudAudioStreamUrl = "http://api-audiostream-bj.fengkongcloud.com/v2/saas/anti_fraud/audiostream";
	/**
	 * Video moderation endpoint.
	 * Defaults to {@code http://api-video-bj.fengkongcloud.com/v2/saas/anti_fraud/video}.
	 */
	private String antiFraudVideoUrl = "http://api-video-bj.fengkongcloud.com/v2/saas/anti_fraud/video";
	/**
	 * Video-stream moderation endpoint.
	 * Defaults to {@code http://api-videostream-bj.fengkongcloud.com/v3/saas/anti_fraud/videostream}.
	 */
	private String antiFraudVideoStreamUrl = "http://api-videostream-bj.fengkongcloud.com/v3/saas/anti_fraud/videostream";
	/** Gets the app id. */

	public String getAppId() {
		return appId;
	}
	/** Sets the app id. */

	public void setAppId(String appId) {
		this.appId = appId;
	}
	/** Gets the access key. */

	public String getAccessKey() {
		return accessKey;
	}
	/** Sets the access key. */

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}
	/** Gets the type. */

	public String getType() {
		return type;
	}
	/** Sets the type. */

	public void setType(String type) {
		this.type = type;
	}
	/** Gets the channel txt. */

	public String getChannelTxt() {
		return channelTxt;
	}
	/** Sets the channel txt. */

	public void setChannelTxt(String channelTxt) {
		this.channelTxt = channelTxt;
	}
	/** Gets the channel img. */

	public String getChannelImg() {
		return channelImg;
	}
	/** Sets the channel img. */

	public void setChannelImg(String channelImg) {
		this.channelImg = channelImg;
	}
	/** Gets the channel audio. */

	public String getChannelAudio() {
		return channelAudio;
	}
	/** Sets the channel audio. */

	public void setChannelAudio(String channelAudio) {
		this.channelAudio = channelAudio;
	}
	/** Gets the channel video. */

	public String getChannelVideo() {
		return channelVideo;
	}
	/** Sets the channel video. */

	public void setChannelVideo(String channelVideo) {
		this.channelVideo = channelVideo;
	}
	/** Gets the anti fraud txt url. */

	public String getAntiFraudTxtUrl() {
		return antiFraudTxtUrl;
	}
	/** Sets the anti fraud txt url. */

	public void setAntiFraudTxtUrl(String antiFraudTxtUrl) {
		this.antiFraudTxtUrl = antiFraudTxtUrl;
	}
	/** Gets the anti fraud img url. */

	public String getAntiFraudImgUrl() {
		return antiFraudImgUrl;
	}
	/** Sets the anti fraud img url. */

	public void setAntiFraudImgUrl(String antiFraudImgUrl) {
		this.antiFraudImgUrl = antiFraudImgUrl;
	}
	/** Gets the anti fraud imgs url. */
	
	public String getAntiFraudImgsUrl() {
		return antiFraudImgsUrl;
	}
	/** Sets the anti fraud imgs url. */

	public void setAntiFraudImgsUrl(String antiFraudImgsUrl) {
		this.antiFraudImgsUrl = antiFraudImgsUrl;
	}
	/** Gets the anti fraud audio url. */

	public String getAntiFraudAudioUrl() {
		return antiFraudAudioUrl;
	}
	/** Sets the anti fraud audio url. */

	public void setAntiFraudAudioUrl(String antiFraudAudioUrl) {
		this.antiFraudAudioUrl = antiFraudAudioUrl;
	}
	/** Gets the anti fraud audio stream url. */

	public String getAntiFraudAudioStreamUrl() {
		return antiFraudAudioStreamUrl;
	}
	/** Sets the anti fraud audio stream url. */

	public void setAntiFraudAudioStreamUrl(String antiFraudAudioStreamUrl) {
		this.antiFraudAudioStreamUrl = antiFraudAudioStreamUrl;
	}
	/** Gets the anti fraud video url. */

	public String getAntiFraudVideoUrl() {
		return antiFraudVideoUrl;
	}
	/** Sets the anti fraud video url. */

	public void setAntiFraudVideoUrl(String antiFraudVideoUrl) {
		this.antiFraudVideoUrl = antiFraudVideoUrl;
	}
	/** Gets the anti fraud video stream url. */

	public String getAntiFraudVideoStreamUrl() {
		return antiFraudVideoStreamUrl;
	}
	/** Sets the anti fraud video stream url. */

	public void setAntiFraudVideoStreamUrl(String antiFraudVideoStreamUrl) {
		this.antiFraudVideoStreamUrl = antiFraudVideoStreamUrl;
	}

}
