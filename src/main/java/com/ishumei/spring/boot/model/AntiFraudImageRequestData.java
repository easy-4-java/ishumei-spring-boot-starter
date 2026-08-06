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

@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AntiFraudImageRequestData extends AntiFraudRequestData {

	/**
	 * 要检测的图片； 可使用图片的base64编码或者图片的url链接；
	 * 支持格式：jpg，jpeg，jp2，png，webp，gif，bmp，tiff，tif，dib，ppm，pgm，pbm，hdr，pic；
	 * 建议图片像素不小于256*256
	 */
	@JsonProperty("img")
	private String img;
	
	/**
	 * 要检测的图片数组，要求数组长度在 100 以内； 可使用图片的base64编码或者图片的url链接；
	 * 支持格式：jpg，jpeg，jp2，png，webp，gif，bmp，tiff，tif，dib，ppm，pgm，pbm，hdr，pic；
	 * 建议图片像素不小于256*256
	 */
	@JsonProperty("imgs")
	private List<AntiFraudImageRequestItem> imgs;

	/**
	 * 用户指定的图片标识；当callback存在时，在回调请求中向用户返回；不支持特殊字符
	 */
	@JsonProperty("btId")
	private String btId;

	/**
	 * 用户的性别，可选值：女性：0，男性：1
	 */
	@JsonProperty("sex")
	private int sex;

	/**
	 * 用户的年龄，可选值：青年（大约18-45岁）：0、中年（大约45-60岁）：1、老年（大于60岁）：2
	 */
	@JsonProperty("age")
	private int age = 0;

	/**
	 * 用户android设备唯一标识；相比tokenId和IP，imei和mac更难被更换，当恶意用户使用多个不同账户和IP进作恶时，通过imei和mac能够有效关联识别此类恶意行为，同时可用于比对数美设备黑名单
	 */
	@JsonProperty("imei")
	private String imei;

	/**
	 */
	@JsonProperty("mac")
	private String mac;

	/**
	 * 用户iOS应用唯一标识，相比tokenId和IP，idfv不能被修改，当恶意用户使用多个不同账户和IP进行恶意行为时，使用idfv能够发现和识别此类恶意行为
	 */
	@JsonProperty("idfv")
	private String idfv;

	/**
	 */
	@JsonProperty("idfa")
	private String idfa;

	/**
	 * 最大截帧数量;GIF图检测专用，默认值为20;当interval*maxFrame小于该图片所包含的图片数量时，截帧间隔会自动修改为该图片所包含的图片数/maxFrame，以提高整体检测效果
	 */
	@JsonProperty("maxFrame")
	private int maxFrame = 20;

	/**
	 * 截帧频率;GIF图检测专用，默认值为1;每interval张图片抽取一张进行检测
	 */
	@JsonProperty("interval")
	private int interval = 1;

}
