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

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AntiFraudImageRequestItem {

	/**
	 * 要检测的图片； 可使用图片的base64编码或者图片的url链接；
	 * 支持格式：jpg，jpeg，jp2，png，webp，gif，bmp，tiff，tif，dib，ppm，pgm，pbm，hdr，pic；
	 * 建议图片像素不小于256*256
	 */
	@JsonProperty("img")
	private String img;
	
	/**
	 * 客户端用户唯一标识，用于用户行为分析，建 议传入用户 UID 注：不同用户务必传入不同的 tokenId 对其进 行唯一标识
	 */
	@JsonProperty("tokenId")
	private String tokenId;

	/**
	 * 用户指定的图片标识；当callback存在时，在回调请求中向用户返回；不支持特殊字符
	 */
	@JsonProperty("btId")
	private String btId;
	
}
