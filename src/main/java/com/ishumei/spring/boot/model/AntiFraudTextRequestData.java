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

@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AntiFraudTextRequestData extends AntiFraudRequestData{

	/**
	 * 要检测的文本内容； 文本上限2W字
	 */
	@JsonProperty("text")
	private String text;

	/**
	 * 用户的性别，可选值：女性：0，男性：1
	 */
	@JsonProperty("gender")
	private int gender;
	
	/**
	 * 用户昵称；强烈建议传递此参数，几乎所有平台的恶意用户都会通过昵称散播垃圾信息，存在涉政违禁和导流信息等风险
	 */
	@JsonProperty("nickname")
	private String nickname;

	/**
	 * 直播间/游戏房间编号； 可针对单个房间制定不同的策略
	 */
	@JsonProperty("room")
	private String room;

	/**
	 * 是否区分不同应用下的账号，可能取值： 不区分：0、 区分：1；: 默认值为0；
	 * 取值为1时不同应用下的账号体系各自独立，账号相关的策略特征在不同应用下单独统计和生效
	 */
	@JsonProperty("isTokenSeperate")
	private int isTokenSeperate = 0;

}
