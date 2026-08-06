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

import com.ishumei.spring.boot.model.AntiFraudResponse;
import com.ishumei.spring.boot.model.AntiFraudTextRequest;
import com.ishumei.spring.boot.model.AntiFraudTextRequestData;

import lombok.extern.slf4j.Slf4j;

/**
 *     智能文本识别
 * https://www.ishumei.com/help/documents.html?id=21110
 */
@Slf4j
public class ShumeiAntiFraudTextOperations extends ShumeiAntiFraudOperations {

	public ShumeiAntiFraudTextOperations(ShumeiAntiFraudTemplate timTemplate) {
		super(timTemplate);
	}

	/**
	 * 1、智能文本识别
	 * API：https://www.ishumei.com/help/documents.html?id=21110
	 * @param type  平台业务类型，可选值(必须大写)；直播：ZHIBO、电商：ECOM、游戏：GAME、新闻资讯 ：NEWS、论坛：FORUM、社交 ：SOCIAL
	 * @param tokenId 客户端用户唯一标识；用于用户行为分析，建议传入用户UID；注：不同用户务必传入不同的tokenId对其进行唯一标识
	 * @param nickname 用户昵称；强烈建议传递此参数，几乎所有平台的恶意用户都会通过昵称散播垃圾信息，存在涉政违禁和导流信息等风险
	 * @return
	 */
	public AntiFraudResponse antiFraud(String type, String tokenId, String nickname) {
		return this.antiFraud(type, tokenId, nickname, nickname);
	}

	/**
	 * 2、智能文本识别
	 * API：https://www.ishumei.com/help/documents.html?id=21110
	 * @param type  平台业务类型，可选值(必须大写)；直播：ZHIBO、电商：ECOM、游戏：GAME、新闻资讯 ：NEWS、论坛：FORUM、社交 ：SOCIAL
	 * @param tokenId 客户端用户唯一标识；用于用户行为分析，建议传入用户UID；注：不同用户务必传入不同的tokenId对其进行唯一标识
	 * @param nickname 用户昵称；强烈建议传递此参数，几乎所有平台的恶意用户都会通过昵称散播垃圾信息，存在涉政违禁和导流信息等风险
	 * @param text 要检测的文本内容；文本上限2W字
	 * @return
	 */
	public AntiFraudResponse antiFraud(String type, String tokenId, String nickname, String text) {

		AntiFraudTextRequest payload = new AntiFraudTextRequest();
		payload.setAccessKey(getTemplate().getProperties().getAccessKey());
		payload.setAppId(getTemplate().getProperties().getAppId());
		payload.setType(type);

		AntiFraudTextRequestData data = new AntiFraudTextRequestData();
		data.setChannel(getTemplate().getProperties().getChannelTxt());
		data.setTokenId(tokenId);
		data.setText(text);
		data.setNickname(nickname);

		payload.setData(data);

		AntiFraudResponse res = requestInvoke(getTemplate().getProperties().getAntiFraudTxtUrl(), payload, AntiFraudResponse.class);

		return res;
	}

}
