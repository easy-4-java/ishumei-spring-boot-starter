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
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AntiFraudDetail {

	/**
	 * 标识风险类型，可能取值： 正常：0， 涉政：100， 色情：200， 性感：210， 广告：300， 二维码：310， 水印：320， 暴恐：400，
	 * 违规：500， 不良场景 ：510， 黑名单：700， 白名单：710， 高危账号：800， 自定义：900
	 */
	@JsonProperty("riskType")
	private int riskType;

	/**
	 * 策略规则标识; 用来标识命中的策略规则; 注：该参数为旧版API返回参数，兼容保留，后续版本会取消，请勿依赖此参数，仅供参考
	 */
	@JsonProperty("model")
	private String model;
	
	/**
	 * 拦截的风险原因解释;仅供人了解风险原因时作为参考，程序请勿依赖该参数的值做逻辑处理
	 */
	@JsonProperty("description")
	private String description;
	
	/**
	 * 新版策略规则风险原因描述；注：该参数为新版API返回参数，过渡阶段只有新策略才会返回
	 */
	@JsonProperty("descriptionV2")
	private String descriptionV2;

}
