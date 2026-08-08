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

import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

/**
 * Base class for Shumei (数美) anti-fraud operation helpers.
 * <p>See <a href="https://www.ishumei.com/help/documents.html?id=21110">the API overview</a>.</p>
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 1.0.0
 */
@Slf4j
public abstract class ShumeiAntiFraudOperations {

	/** {@code application/json} content-type value. */
	public final static String APPLICATION_JSON_VALUE = "application/json";
	/** {@code application/json;charset=UTF-8} content-type value. */
	public final static String APPLICATION_JSON_UTF8_VALUE = "application/json;charset=UTF-8";
	/** {@code application/json} media type. */
	public final static MediaType APPLICATION_JSON = MediaType.parse(APPLICATION_JSON_VALUE);
	/** {@code application/json;charset=UTF-8} media type. */
	public final static MediaType APPLICATION_JSON_UTF8 = MediaType.parse(APPLICATION_JSON_UTF8_VALUE);

	/** The shared template used to invoke the Shumei APIs. */
	protected ShumeiAntiFraudTemplate template;

	/**
	 * Creates an operation helper bound to the given template.
	 * @param template the template used to execute Shumei requests
	 */
	public ShumeiAntiFraudOperations(ShumeiAntiFraudTemplate template) {
		this.template = template;
	}

	/**
	 * Returns the underlying template.
	 * @return the template used to execute Shumei requests
	 */
	public ShumeiAntiFraudTemplate getTemplate() {
		return template;
	}

	/**
	 * Parses the given JSON into an instance of {@code cls}; returns a default instance on failure.
	 * @param <T> the target type
	 * @param json the JSON string
	 * @param cls the target class
	 * @return the parsed instance, or a default instance when parsing fails
	 */
	public <T> T readValue(String json, Class<T> cls) {
		try {
			if(Objects.isNull(json)){
				return BeanUtils.instantiateClass(cls);
			}
			return JSONObject.parseObject(json, cls);
//			return getTemplate().getObjectMapper().readValue(json, cls);
		} catch (Exception e) {
			log.error(e.getMessage());
			return BeanUtils.instantiateClass(cls);
		}
	}

	/**
	 * POSTs the given parameters as JSON to the Shumei API and parses the response.
	 * @param <T> the response type
	 * @param url the API endpoint URL
	 * @param params the request parameters object
	 * @param cls the response class
	 * @return the parsed response, or a default instance on failure
	 */
	public <T> T requestInvoke(String url, Object params, Class<T> cls) {
		long start = System.currentTimeMillis();
		T res = null;
		try {

			String paramStr = getTemplate().getObjectMapper().writeValueAsString(params);
			log.info("iShumei Request Param :  {}", paramStr);

			RequestBody requestBody = RequestBody.create(APPLICATION_JSON_UTF8, paramStr);
			Request request = new Request.Builder().url(url).post(requestBody).build();

			try(Response response = getTemplate().getOkhttp3Client().newCall(request).execute();) {
				if (response.isSuccessful()) {
					String body = response.body().string();
					log.info("iShumei Request Success : url : {}, params : {}, code : {}, body : {} , use time : {} ", url, paramStr, response.code(), body , System.currentTimeMillis() - start);
					res = this.readValue(body, cls);
				} else {
					log.error("iShumei Request Failure : url : {}, params : {}, code : {}, message : {}, use time : {} ", url, paramStr, response.code(), response.message(), System.currentTimeMillis() - start);
					res = BeanUtils.instantiateClass(cls);
				}
			}
		} catch (Exception e) {
			log.error("iShumei Request Error : url : {}, params : {}, use time : {} ,  {}", url, JSONObject.toJSONString(params), e.getMessage(), System.currentTimeMillis() - start);
			res = BeanUtils.instantiateClass(cls);
		}
		return res;
	}

}
