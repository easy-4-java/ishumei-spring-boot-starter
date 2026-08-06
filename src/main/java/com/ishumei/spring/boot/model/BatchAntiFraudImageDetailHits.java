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
public class BatchAntiFraudImageDetailHits {

	/**
	 * 拦截的风险原因解释;仅供人了解风险原因时作为参考，程序请勿依赖该参数的值做逻辑处理
	 */
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("descriptionV2")
	private String descriptionV2;
	
	/**
	 * 策略规则标识; 用来标识命中的策略规则; 注：该参数为旧版API返回参数，兼容保留，后续版本会取消，请勿依赖此参数，仅供参考
	 */
	@JsonProperty("model")
	private String model;

	/**
	 * 风险级别 可能返回值： PASS：正常内容，建议直接放行 REVIEW：可疑内容，建议人工审核 REJECT：违规内容，建议直接拦截
	 */
	@JsonProperty("riskLevel")
	private String riskLevel;

	/**
	 * 标识风险类型，可能取值： 正常：0， 涉政：100， 色情：200， 性感：210， 广告：300， 二维码：310， 水印：320， 暴恐：400，
	 * 违规：500， 不良场景 ：510， 黑名单：700， 白名单：710， 高危账号：800， 自定义：900
	 */
	@JsonProperty("riskType")
	private int riskType;
	
	/**
	 * 风险分数；取值范围[0,1000]，分数越高风险越大
	 */
	@JsonProperty("score")
	private int score;

}
