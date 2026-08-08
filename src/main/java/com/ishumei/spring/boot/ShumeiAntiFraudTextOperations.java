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
 * Text moderation operations for the Shumei (数美) anti-fraud service.
 * <p>See <a href="https://www.ishumei.com/help/documents.html?id=21110">the text API reference</a>.</p>
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 1.0.0
 */
@Slf4j
public class ShumeiAntiFraudTextOperations extends ShumeiAntiFraudOperations {

	/**
	 * Creates text-moderation operations bound to the given template.
	 * @param timTemplate the template used to execute Shumei requests
	 */
	public ShumeiAntiFraudTextOperations(ShumeiAntiFraudTemplate timTemplate) {
		super(timTemplate);
	}

	/**
	 * 1. Text moderation using the nickname as the text to check.
	 * <p>API: <a href="https://www.ishumei.com/help/documents.html?id=21110">text moderation</a>.</p>
	 * @param type platform business type (uppercase): ZHIBO, ECOM, GAME, NEWS, FORUM, SOCIAL
	 * @param tokenId unique client user id (for behaviour analysis); pass a distinct value per user
	 * @param nickname user nickname. Malicious users often spread spam/political/trafficking info
	 *                 via nicknames, so this parameter is strongly recommended.
	 * @return the moderation response
	 */
	public AntiFraudResponse antiFraud(String type, String tokenId, String nickname) {
		return this.antiFraud(type, tokenId, nickname, nickname);
	}

	/**
	 * 2. Text moderation.
	 * <p>API: <a href="https://www.ishumei.com/help/documents.html?id=21110">text moderation</a>.</p>
	 * @param type platform business type (uppercase): ZHIBO, ECOM, GAME, NEWS, FORUM, SOCIAL
	 * @param tokenId unique client user id (for behaviour analysis); pass a distinct value per user
	 * @param nickname user nickname. Malicious users often spread spam/political/trafficking info
	 *                 via nicknames, so this parameter is strongly recommended.
	 * @param text the text to check; up to 20000 characters
	 * @return the moderation response
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
