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
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BatchAntiFraudImageDetail {

	/**
	 * 拦截的风险原因解释;仅供人了解风险原因时作为参考，程序请勿依赖该参数的值做逻辑处理
	 */
	@JsonProperty("description")
	private String description;

	@JsonProperty("descriptionV2")
	private String descriptionV2;

	/**
	 * OCR 识别出的文字，可根据需求返回该参 数
	 */
	@JsonProperty("text")
	private String text;

	/**
	 * 色情识别标签，标识色情识别结果，可选值： "色情"、"性感"、"正常"，可根据需求返回 该参
	 */
	@JsonProperty("pornLabel")
	private String pornLabel;

	/**
	 * 色情图片概率，可根据需求返回该参数
	 */
	@JsonProperty("pornRate")
	private float pornRate;

	/**
	 * 性感图片概率，可根据需求返回该参数
	 */
	@JsonProperty("sexyRate")
	private float sexyRate;

	/**
	 * 正常图片概率，可根据需求返回该参数
	 */
	@JsonProperty("normalRate")
	private float normalRate;

	/**
	 * 最相似的涉政人物名称，可根据需求返回该 参数
	 */
	@JsonProperty("polityName")
	private String polityName;

	/**
	 * 最相似的涉政人物概率，可根据需求返回该 参数
	 */
	@JsonProperty("polityRate")
	private float polityRate;

	/**
	 * 暴恐识别标签，标识暴恐识别结果，可选值： "暴乱场景"、"国旗国徽"、"军装"、"恐怖组 织"、"枪支刀具"、"血腥场景"、”游戏枪支 刀具”、"中国地图"、"坦克"、"蜡烛"、"制服 "、"正常"，可根据需求返回该参数
	 */
	@JsonProperty("violenceLabel")
	private String violenceLabel;

	/**
	 * 暴乱场景概率，可根据需求返回该参数
	 */
	@JsonProperty("rebelRate")
	private float rebelRate;

	/**
	 * 国旗国徽概率，可根据需求返回该参数
	 */
	@JsonProperty("flagRate")
	private float flagRate;

	/**
	 * 军装概率，可根据需求返回该参数
	 */
	@JsonProperty("armyRate")
	private float armyRate;

	/**
	 * 恐怖组织概率，可根据需求返回该参数
	 */
	@JsonProperty("terrorismRate")
	private float terrorismRate;

	/**
	 * 枪支刀具概率，可根据需求返回该参数
	 */
	@JsonProperty("weaponRate")
	private float weaponRate;

	/**
	 * 血腥场景概率，可根据需求返回该参数
	 */
	@JsonProperty("bloodRate")
	private float bloodRate;

	/**
	 * 游戏枪支刀具概率，可根据需求返回该参数
	 */
	@JsonProperty("gameWeaponRate")
	private float gameWeaponRate;

	/**
	 * 中国地图概率，可根据需求返回该参数
	 */
	@JsonProperty("chinamapRate")
	private float chinamapRate;

	/**
	 * 坦克概率，可根据需求返回该参数
	 */
	@JsonProperty("tankRate")
	private float tankRate;

	/**
	 * 蜡烛概率，可根据需求返回该参数
	 */
	@JsonProperty("candleRate")
	private float candleRate;

	/**
	 * 制服概率，可根据需求返回该参数
	 */
	@JsonProperty("uniformRate")
	private float uniformRate;

	/**
	 * 非暴恐图片概率，可根据需求返回该参数
	 */
	@JsonProperty("nonViolenceRate")
	private float nonViolenceRate;

	/**
	 * 新版策略规则风险原因描述；注：该参数为新版API返回参数，过渡阶段只有新策略才会返回
	 */
	@JsonProperty("hits")
	private List<BatchAntiFraudImageDetailHits> hits;

	/**
	 * 策略规则标识; 用来标识命中的策略规则; 注：该参数为旧版API返回参数，兼容保留，后续版本会取消，请勿依赖此参数，仅供参考
	 */
	@JsonProperty("model")
	private String model;

	/**
	 * 标识风险类型，可能取值： 正常：0， 涉政：100， 色情：200， 性感：210， 广告：300， 二维码：310， 水印：320， 暴恐：400，
	 * 违规：500， 不良场景 ：510， 黑名单：700， 白名单：710， 高危账号：800， 自定义：900
	 */
	@JsonProperty("riskType")
	private int riskType;

	@JsonProperty("original_text")
	private String originalText;

	@JsonProperty("sexy_risk_tokenid")
	private int sexyRiskTokenId;

	@JsonProperty("tokenScore")
	private int tokenScore;

}
