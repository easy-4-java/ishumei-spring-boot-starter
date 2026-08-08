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
 * https://www.ishumei.com/
 * 
 * @author [@Loong Wan](https://github.com/loong10k)
 */
@ConfigurationProperties(ShumeiAntiFraudProperties.PREFIX)
public class ShumeiAntiFraudProperties {

	public static final String PREFIX = "shumei.anti-fraud";

	/**
	 * 应用标识： 用于区分相同公司的不同应用，该参数传递值可与数美服务协商用于区分应用，默认应用值：default
	 */
	private String appId;
	/**
	 * 公司密钥：用于权限认证，开通账号服务时由数美提供
	 */
	private String accessKey;
	/**
	 * 平台业务类型，可选值(必须大写) 直播：ZHIBO 电商：ECOM 游戏：GAME 新闻资讯 ：NEWS 论坛：FORUM 社交 ：SOCIAL
	 */
	private String type;
	/**
	 * 文本识别过滤时的渠道值
	 */
	private String channelTxt;
	/**
	 * 图片识别过滤时的渠道值
	 */
	private String channelImg;
	/**
	 * 音频识别过滤时的渠道值
	 */
	private String channelAudio;
	/**
	 * 视频识别过滤时的渠道值
	 */
	private String channelVideo;
	/**
	 * 文本识别请求地址；默认：http://api-text-bj.fengkongcloud.com/v2/saas/anti_fraud/text
	 */
	private String antiFraudTxtUrl = "http://api-text-bj.fengkongcloud.com/v2/saas/anti_fraud/text";
	/**
	 * 图片识别请求地址；默认：http://api-img-bj.fengkongcloud.com/v2/saas/anti_fraud/img
	 */
	private String antiFraudImgUrl = "http://api-img-bj.fengkongcloud.com/v2/saas/anti_fraud/img";
	/**
	 * 批量图片识别请求地址；默认：http://api-img-bj.fengkongcloud.com/v2/saas/anti_fraud/imgs
	 */
	private String antiFraudImgsUrl = "http://api-img-bj.fengkongcloud.com/v2/saas/anti_fraud/imgs";
	/**
	 * 音频识别请求地址；默认：http://api-audio-bj.fengkongcloud.com/v2/saas/anti_fraud/audio
	 */
	private String antiFraudAudioUrl = "http://api-audio-bj.fengkongcloud.com/v2/saas/anti_fraud/audio";
	/**
	 * 音频流识别请求地址；默认：http://api-audiostream-bj.fengkongcloud.com/v2/saas/anti_fraud/audiostream
	 */
	private String antiFraudAudioStreamUrl = "http://api-audiostream-bj.fengkongcloud.com/v2/saas/anti_fraud/audiostream";
	/**
	 * 视频识别请求地址；默认：http://api-video-bj.fengkongcloud.com/v2/saas/anti_fraud/video
	 */
	private String antiFraudVideoUrl = "http://api-video-bj.fengkongcloud.com/v2/saas/anti_fraud/video";
	/**
	 * 视频流识别请求地址；默认：http://api-videostream-bj.fengkongcloud.com/v3/saas/anti_fraud/videostream
	 */
	private String antiFraudVideoStreamUrl = "http://api-videostream-bj.fengkongcloud.com/v3/saas/anti_fraud/videostream";

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAccessKey() {
		return accessKey;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getChannelTxt() {
		return channelTxt;
	}

	public void setChannelTxt(String channelTxt) {
		this.channelTxt = channelTxt;
	}

	public String getChannelImg() {
		return channelImg;
	}

	public void setChannelImg(String channelImg) {
		this.channelImg = channelImg;
	}

	public String getChannelAudio() {
		return channelAudio;
	}

	public void setChannelAudio(String channelAudio) {
		this.channelAudio = channelAudio;
	}

	public String getChannelVideo() {
		return channelVideo;
	}

	public void setChannelVideo(String channelVideo) {
		this.channelVideo = channelVideo;
	}

	public String getAntiFraudTxtUrl() {
		return antiFraudTxtUrl;
	}

	public void setAntiFraudTxtUrl(String antiFraudTxtUrl) {
		this.antiFraudTxtUrl = antiFraudTxtUrl;
	}

	public String getAntiFraudImgUrl() {
		return antiFraudImgUrl;
	}

	public void setAntiFraudImgUrl(String antiFraudImgUrl) {
		this.antiFraudImgUrl = antiFraudImgUrl;
	}
	
	public String getAntiFraudImgsUrl() {
		return antiFraudImgsUrl;
	}

	public void setAntiFraudImgsUrl(String antiFraudImgsUrl) {
		this.antiFraudImgsUrl = antiFraudImgsUrl;
	}

	public String getAntiFraudAudioUrl() {
		return antiFraudAudioUrl;
	}

	public void setAntiFraudAudioUrl(String antiFraudAudioUrl) {
		this.antiFraudAudioUrl = antiFraudAudioUrl;
	}

	public String getAntiFraudAudioStreamUrl() {
		return antiFraudAudioStreamUrl;
	}

	public void setAntiFraudAudioStreamUrl(String antiFraudAudioStreamUrl) {
		this.antiFraudAudioStreamUrl = antiFraudAudioStreamUrl;
	}

	public String getAntiFraudVideoUrl() {
		return antiFraudVideoUrl;
	}

	public void setAntiFraudVideoUrl(String antiFraudVideoUrl) {
		this.antiFraudVideoUrl = antiFraudVideoUrl;
	}

	public String getAntiFraudVideoStreamUrl() {
		return antiFraudVideoStreamUrl;
	}

	public void setAntiFraudVideoStreamUrl(String antiFraudVideoStreamUrl) {
		this.antiFraudVideoStreamUrl = antiFraudVideoStreamUrl;
	}

}
