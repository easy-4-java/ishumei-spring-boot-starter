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

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class AntiFraudRequestData {

	/**
	 * 客户端用户唯一标识，用于用户行为分析，建 议传入用户 UID 注：不同用户务必传入不同的 tokenId 对其进 行唯一标识
	 */
	@JsonProperty("tokenId")
	private String tokenId;

	/**
	 * 数据场景，取值需要与数美协商
	 */
	@JsonProperty("channel")
	private String channel;

	/**
	 * 客户端IP;该参数用于IP维度的用户行为分析
	 */
	@JsonProperty("ip")
	private String ip;

	/**
	 * 用户手机号；可用于比对数美手机号黑库
	 */
	@JsonProperty("phone")
	private String phone;

	/**
	 * 强烈建议传入；数美设备指纹标识，用于用户行为分析；当恶意用户篡改mac、imei等设备信息时；使用deviceId能够发现和识别此类恶意行为，同时可用于比对数美设备指纹黑名单
	 */
	@JsonProperty("deviceId")
	private String deviceId;

	/**
	 * 客户端IP;该参数用于IP维度的用户行为分析
	 */
	@JsonProperty("receiveTokenId")
	private String receiveTokenId;

	/**
	 *用户等级；针对不同等级的用户可配置不同拦截策略
	 */
	@JsonProperty("level")
	private String level;

	/**
	 * 帐号注册时间; 强烈建议传递此参数，新注册帐号的异常操作风险较高
	 */
	@JsonProperty("registerTime")
	private String registerTime;

	/**
	 * 帐号好友数; 社交场景强烈推荐传此参数，标识用户质量
	 */
	@JsonProperty("friendNum")
	private String friendNum;

	/**
	 * 帐号粉丝数; 直播/社区场景强烈推荐传此参数，标识用户质量
	 */
	@JsonProperty("fansNum")
	private String fansNum;

	/**
	 * 用户角色; 对不同角色可配置不同策略。 直播领域可取值： 房管：ADMIN、 主播：HOST、 系统角色：SYSTEM； 游戏领域可取值：
	 * 管理员：ADMIN、 普通用户：USER； 缺失或者默认普通用户：USER
	 */
	@JsonProperty("role")
	private String role = "USER";

	/**
	 * 讨论的话题编号； 可为书评区编号、论坛帖子编号
	 */
	@JsonProperty("topic")
	private String topic;

	/**
	 * 是否为优质（如付费）用户；配置不同等级，标识用户质量，可能取值：优质账号：1、默认值：0
	 */
	@JsonProperty("isPremiumUser")
	private int isPremiumUser = 0;
	
}
