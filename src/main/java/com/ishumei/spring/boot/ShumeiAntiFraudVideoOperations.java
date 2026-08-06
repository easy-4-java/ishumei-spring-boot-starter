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

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import com.ishumei.spring.boot.model.AntiFraudVideoRequest;
import com.ishumei.spring.boot.model.AntiFraudVideoRequestData;
import com.ishumei.spring.boot.model.AntiFraudVideoResponse;

import lombok.extern.slf4j.Slf4j;

/**
 */
@Slf4j
public class ShumeiAntiFraudVideoOperations extends ShumeiAntiFraudOperations {

	public ShumeiAntiFraudVideoOperations(ShumeiAntiFraudTemplate timTemplate) {
		super(timTemplate);
	}
	private static final String URL = "https://kding-lan.oss-cn-hangzhou.aliyuncs.com/feed/2020-12/video/1608371840629.mp4";
	private static final String ACCESS_KEY = "{ACCESS_KEY";

	public AntiFraudVideoResponse antiFraud(String type, String tokenId, File img) throws UnsupportedEncodingException, IOException {
		AntiFraudVideoRequest payload = new AntiFraudVideoRequest();
		payload.setAccessKey(getTemplate().getProperties().getAccessKey());
		payload.setAppId(getTemplate().getProperties().getAppId());
		payload.setImgType("POLITICS_PORN_AD");
		payload.setAudioType("NONE");
		payload.setBtId("{BT_ID}12");
//		payload.put("callback", "https://jsonplaceholder.typicode.com/posts/");

		AntiFraudVideoRequestData data = new AntiFraudVideoRequestData();
		data.setUrl(URL);

		payload.setData(data);

		AntiFraudVideoResponse res = requestInvoke(getTemplate().getProperties().getAntiFraudTxtUrl(), payload, AntiFraudVideoResponse.class);
		return res;
	}
}
